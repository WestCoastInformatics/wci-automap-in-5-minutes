import json
import os
import re
import shlex
import shutil
import subprocess
import sys
import time


BASE_DIR = os.path.dirname(os.path.abspath(__file__))
SCRIPTS_DIR = os.path.abspath(os.path.join(BASE_DIR, "..", "scripts"))
if SCRIPTS_DIR not in sys.path:
    sys.path.insert(0, SCRIPTS_DIR)

from automap_auth import DEFAULT_API_URL, require_credentials, request_access_token, token_from_env
from process_output import configure_standard_streams, print_process_failure, redact_secrets


configure_standard_streams()


API_URL = os.environ.get("API_URL", DEFAULT_API_URL).rstrip("/")
README_PATH = os.path.join(BASE_DIR, "README.md")
LOGIN_COMMAND = "__curl_login__"
COMMANDS = "commands"
FILES = "files"


def env_int(name, default, minimum=0):
    """Read an integer environment setting with a safe fallback."""
    try:
        return max(minimum, int(os.environ.get(name, str(default))))
    except ValueError:
        return default


RETRY_ATTEMPTS = env_int("AUTOMAP_RETRY_ATTEMPTS", 5, minimum=1)
RETRY_DELAY_MS = env_int("AUTOMAP_RETRY_DELAY_MS", 5000)

healthy_endpoints = []
unhealthy_endpoints = []
audit_ids = {}


def mark_healthy(endpoint):
    """Track a successful endpoint without duplicating summary entries."""
    if endpoint not in healthy_endpoints:
        healthy_endpoints.append(endpoint)


def mark_unhealthy(endpoint):
    """Track a failed endpoint and remove any earlier healthy entry."""
    if endpoint in healthy_endpoints:
        healthy_endpoints.remove(endpoint)
    if endpoint not in unhealthy_endpoints:
        unhealthy_endpoints.append(endpoint)


def check_curl_installation():
    """Verify curl is available for README-driven sample calls."""
    if shutil.which("curl") is None:
        print("Error: curl is not installed or not available on PATH.", file=sys.stderr)
        sys.exit(1)


def get_auth_token():
    """Use an existing token or request one for cURL sample calls."""
    token = token_from_env()
    if token:
        return token

    username, password = require_credentials(sys.argv[1:], "python curl_check.py <username> <password>")
    try:
        return request_access_token(API_URL, username, password)
    except RuntimeError as error:
        print(redact_secrets(str(error)), file=sys.stderr)
        raise SystemExit(1) from error


def code_block_command(block):
    """Convert a fenced README shell block into a runnable sample command."""
    if "curl" not in block:
        return None
    if "/auth/token" in block:
        return LOGIN_COMMAND

    lines = block.splitlines()
    curl_start = next((index for index, line in enumerate(lines) if line.strip().startswith("curl ")), None)
    if curl_start is None:
        return None

    command = "\n".join(lines[curl_start:]).strip()
    return re.sub(r"\s*\|\s*jq\s*$", "", command, flags=re.DOTALL)


def process_markdown():
    """Parse README.md and extract runnable cURL blocks with sample files."""
    if not os.path.exists(README_PATH):
        print("Error: README.md not found.", file=sys.stderr)
        sys.exit(1)

    with open(README_PATH, "r", encoding="utf-8") as handle:
        lines = handle.readlines()

    sections = []
    current_section = {COMMANDS: [], FILES: []}
    in_code_block = False
    code_lines = []

    def finish_section():
        """Save the current README section when it has runnable commands."""
        nonlocal current_section
        if current_section[COMMANDS]:
            sections.append(current_section)
        current_section = {COMMANDS: [], FILES: []}

    for line in lines:
        stripped = line.strip()

        if stripped.startswith("```"):
            if in_code_block:
                command = code_block_command("\n".join(code_lines))
                if command:
                    current_section[COMMANDS].append(command)
                code_lines = []
                in_code_block = False
            else:
                in_code_block = True
                code_lines = []
            continue

        if in_code_block:
            code_lines.append(line.rstrip("\n"))
            continue

        if stripped.startswith("#"):
            finish_section()
            continue

        file_matches = re.findall(r"`samples/([^`]+)`", line)
        for match in file_matches:
            current_section[FILES].append(f"samples/{match}")

    finish_section()
    return sections


def split_curl_output(stdout):
    """Split curl body and appended HTTP status code."""
    if "\n" not in stdout:
        return stdout, ""
    body, status_code = stdout.rsplit("\n", 1)
    return body, status_code.strip()


def endpoint_from_args(args):
    """Return the first HTTP URL in a cURL argument list."""
    return next((arg for arg in args if arg.startswith("http://") or arg.startswith("https://")), "curl command")


def substitute_runtime_values(value, token):
    """Replace README shell variables with runtime values before invoking curl."""
    value = value.replace("$API_URL", API_URL)
    value = value.replace("$token", token)
    if "$taskId" in value or "$termId" in value:
        if not audit_ids.get("taskId") or not audit_ids.get("termId"):
            raise RuntimeError("Audit trail command requires a prior audited task response.")
        value = value.replace("$taskId", audit_ids["taskId"])
        value = value.replace("$termId", audit_ids["termId"])
    return value


def curl_args(command, token):
    """Parse a README cURL command into cross-platform subprocess arguments."""
    normalized_command = command.replace("\\\r\n", " ").replace("\\\n", " ")
    args = shlex.split(normalized_command, posix=True)
    if not args or args[0] != "curl":
        raise RuntimeError(f"README block did not parse as a curl command: {command}")
    args = [substitute_runtime_values(arg, token) for arg in args]
    return args + ["-w", "\n%{http_code}"]


def run_curl_command(command, token):
    """Run one README cURL command and return the response body."""
    if command == LOGIN_COMMAND:
        endpoint = f"{API_URL}/auth/token"
        mark_healthy(endpoint)
        return endpoint, json.dumps({"access_token": "<redacted>"})

    try:
        args = curl_args(command, token)
        endpoint = endpoint_from_args(args)
        for attempt in range(1, RETRY_ATTEMPTS + 1):
            print(f"Running: {endpoint}")
            result = subprocess.run(args, cwd=BASE_DIR, capture_output=True, text=True, encoding="utf-8", errors="replace")
            if result.returncode != 0:
                print(f"Error executing: {redact_secrets(command)}", file=sys.stderr)
                print_process_failure("curl", result)
                mark_unhealthy(endpoint)
                return endpoint, None

            body, status_code = split_curl_output(result.stdout)
            if status_code == "429" and attempt < RETRY_ATTEMPTS:
                delay_seconds = (RETRY_DELAY_MS * attempt) / 1000
                print(f"HTTP 429 from {endpoint}; retrying in {delay_seconds:.1f}s.", file=sys.stderr)
                time.sleep(delay_seconds)
                continue

            if not status_code.isdigit() or not 200 <= int(status_code) < 300:
                print(f"ERROR: {endpoint} returned HTTP {status_code or 'unknown'}, expected 2xx", file=sys.stderr)
                if body.strip():
                    print(redact_secrets(body), file=sys.stderr)
                mark_unhealthy(endpoint)
                return endpoint, None

            mark_healthy(endpoint)
            return endpoint, body
    except Exception as error:
        endpoint = redact_secrets(command)
        print(f"Exception running curl: {error}", file=sys.stderr)
        mark_unhealthy(endpoint)
        return endpoint, None


def format_response(response):
    """Pretty-print JSON response bodies for sample files."""
    try:
        return json.dumps(json.loads(response), indent=2)
    except json.JSONDecodeError:
        return response


def capture_audit_ids(sample_file, response):
    """Remember audited task identifiers for the audit-trail sample call."""
    if sample_file != "samples/map-withAudit-text.txt":
        return
    try:
        payload = json.loads(response)
        audit_ids["taskId"] = str(payload["id"])
        audit_ids["termId"] = str(payload["terms"][0]["id"])
    except (KeyError, IndexError, TypeError, json.JSONDecodeError) as error:
        raise RuntimeError(f"Unable to derive audit ids from {sample_file}: {error}") from error


def run_sections(sections, token):
    """Execute cURL commands and update corresponding sample files."""
    for section in sections:
        print(f"Processing section with {len(section[COMMANDS])} curl commands and {len(section[FILES])} sample files.")
        for sample_index, curl_command in enumerate(section[COMMANDS]):
            if sample_index >= len(section[FILES]):
                mark_unhealthy(redact_secrets(curl_command))
                print(f"No sample file configured in README for {redact_secrets(curl_command)}.", file=sys.stderr)
                continue

            sample_file = section[FILES][sample_index]
            endpoint, response = run_curl_command(curl_command, token)
            if response is None:
                continue

            try:
                capture_audit_ids(sample_file, response)
            except RuntimeError as error:
                mark_unhealthy(endpoint)
                print(str(error), file=sys.stderr)
                continue

            sample_output = redact_secrets(format_response(response))
            sample_path = os.path.join(BASE_DIR, sample_file)
            with open(sample_path, "w", encoding="utf-8") as handle:
                handle.write(sample_output.rstrip() + "\n")
            print(f"Updated: {sample_file}")


def report_endpoints():
    """Print a health summary for all cURL endpoints exercised in the run."""
    if unhealthy_endpoints:
        print("\nHealthy endpoints (total {}):".format(len(healthy_endpoints))) if healthy_endpoints else print("\nNo healthy endpoints found.")
        for endpoint in healthy_endpoints:
            print(endpoint)

        print("\nUnhealthy endpoints (total {}):".format(len(unhealthy_endpoints)))
        for endpoint in unhealthy_endpoints:
            print(endpoint)
    else:
        print("\nAll endpoints are healthy.")


if __name__ == "__main__":
    print(f"Using API_URL={API_URL}")
    check_curl_installation()
    auth_token = get_auth_token()
    readme_sections = process_markdown()
    run_sections(readme_sections, auth_token)
    report_endpoints()
    sys.exit(1 if unhealthy_endpoints else 0)
