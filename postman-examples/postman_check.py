import json
import os
import shutil
import subprocess
import sys
import tempfile
import time


BASE_DIR = os.path.dirname(os.path.abspath(__file__))
SCRIPTS_DIR = os.path.abspath(os.path.join(BASE_DIR, "..", "scripts"))
if SCRIPTS_DIR not in sys.path:
    sys.path.insert(0, SCRIPTS_DIR)

from automap_auth import DEFAULT_API_URL, credentials_from_args, request_access_token, token_from_env
from process_output import configure_standard_streams, redact_secrets


configure_standard_streams()


COLLECTION_FILE = "Automap-Postman-Client.json"
API_URL = os.environ.get("API_URL", DEFAULT_API_URL).rstrip("/")


def env_int(name, default, minimum=0):
    """Read an integer environment setting with a safe fallback."""
    try:
        return max(minimum, int(os.environ.get(name, str(default))))
    except ValueError:
        return default


NEWMAN_REQUEST_DELAY_MS = env_int(
    "AUTOMAP_POSTMAN_DELAY_MS",
    env_int("AUTOMAP_REQUEST_DELAY_MS", 1500),
)
RATE_LIMIT_RETRIES = env_int("AUTOMAP_POSTMAN_429_RETRIES", 1)
RATE_LIMIT_RETRY_DELAY_MS = env_int("AUTOMAP_POSTMAN_429_DELAY_MS", 30000)


def get_auth_token(auth_args):
    """Use an existing token or request one for Newman checks."""
    existing_token = token_from_env()
    if existing_token:
        return existing_token

    username, password = credentials_from_args(auth_args)
    if not username or not password:
        print("Postman checks require AUTOMAP_TOKEN or an Automap username/password.", file=sys.stderr)
        print("Usage: python postman_check.py <username> <password>", file=sys.stderr)
        print("Or set AUTOMAP_USER and AUTOMAP_PASSWORD.", file=sys.stderr)
        return None

    try:
        return request_access_token(API_URL, username, password)
    except RuntimeError as error:
        print(redact_secrets(str(error)), file=sys.stderr)
        return None


def newman_runner_command():
    """Find Newman directly or through npx for cross-platform runs."""
    newman = shutil.which("newman")
    if newman:
        return [newman]

    npx = shutil.which("npx")
    if npx:
        return [npx, "--yes", "newman"]

    print("Newman is not installed, and npx is not available to run it.", file=sys.stderr)
    print("Install Node.js and Newman, then retry: npm install -g newman", file=sys.stderr)
    return None


def status_test_event(extra_script=None):
    """Build a Postman test event that fails non-2xx responses."""
    script = [
        "pm.test('Status code is 2xx', function () {",
        "  pm.expect(pm.response.code).to.be.within(200, 299);",
        "});",
    ]
    if extra_script:
        script.extend(extra_script)
    return {
        "listen": "test",
        "script": {
            "type": "text/javascript",
            "exec": script,
        },
    }


def patch_url_variables(value):
    """Convert old Postman $taskId variables to collection variables."""
    if isinstance(value, str):
        return value.replace("$taskId", "{{taskId}}").replace("$termId", "{{termId}}")
    if isinstance(value, list):
        return [patch_url_variables(item) for item in value]
    if isinstance(value, dict):
        return {key: patch_url_variables(item) for key, item in value.items()}
    return value


def patch_item(item):
    """Patch one Postman item with status tests and audit variable capture."""
    if "item" in item:
        for child in item["item"]:
            patch_item(child)
        return

    item["request"] = patch_url_variables(item.get("request", {}))
    extra_script = None
    if item.get("name") == "Map from a simple text string with auditing":
        extra_script = [
            "if (pm.response.code >= 200 && pm.response.code < 300) {",
            "  const body = pm.response.json();",
            "  if (body && body.id && body.terms && body.terms.length && body.terms[0].id) {",
            "    pm.collectionVariables.set('taskId', body.id);",
            "    pm.collectionVariables.set('termId', body.terms[0].id);",
            "  }",
            "}",
        ]
    item["event"] = [event for event in item.get("event", []) if event.get("listen") != "test"]
    item["event"].append(status_test_event(extra_script))


def write_runtime_collection(collection_file, token):
    """Write a temporary Postman collection with bearer auth and tests injected."""
    with open(collection_file, "r", encoding="utf-8") as handle:
        collection = json.load(handle)

    collection["auth"] = {
        "type": "bearer",
        "bearer": [
            {
                "key": "token",
                "value": token,
                "type": "string",
            }
        ],
    }

    variables = collection.setdefault("variable", [])
    existing_keys = {variable.get("key") for variable in variables}
    if "API_URL" not in existing_keys:
        variables.append({"key": "API_URL", "value": API_URL, "type": "string"})
    if "taskId" not in existing_keys:
        variables.append({"key": "taskId", "value": "", "type": "string"})
    if "termId" not in existing_keys:
        variables.append({"key": "termId", "value": "", "type": "string"})
    for variable in variables:
        if variable.get("key") == "API_URL":
            variable["value"] = API_URL

    for item in collection.get("item", []):
        patch_item(item)

    temp_file = tempfile.NamedTemporaryFile(
        mode="w",
        encoding="utf-8",
        suffix=".postman_collection.json",
        delete=False,
    )
    with temp_file:
        json.dump(collection, temp_file)
    try:
        os.chmod(temp_file.name, 0o600)
    except OSError:
        pass
    return temp_file.name


def failed_request_names(report_path):
    """Extract failed request names from Newman JSON output."""
    if not os.path.exists(report_path):
        return []
    try:
        with open(report_path, "r", encoding="utf-8") as handle:
            report = json.load(handle)
    except json.JSONDecodeError:
        return []

    failures = []
    for failure in report.get("run", {}).get("failures", []):
        source = failure.get("source") or {}
        name = source.get("name") or failure.get("error", {}).get("test") or "Unknown Postman request"
        if name not in failures:
            failures.append(name)
    return failures


def report_has_rate_limit_failure(report_path):
    """Return whether Newman reported HTTP 429 in its JSON failure details."""
    if not os.path.exists(report_path):
        return False
    try:
        with open(report_path, "r", encoding="utf-8") as handle:
            report = json.load(handle)
    except json.JSONDecodeError:
        return False
    return any("429" in json.dumps(failure) for failure in report.get("run", {}).get("failures", []))


def run_collection(token):
    """Run the Automap Postman collection with Newman."""
    collection_file = os.path.join(BASE_DIR, COLLECTION_FILE)
    if not os.path.exists(collection_file):
        print(f"Collection file not found: {collection_file}", file=sys.stderr)
        return 1, [COLLECTION_FILE]

    command = newman_runner_command()
    if command is None:
        return 1, [COLLECTION_FILE]

    runtime_collection = write_runtime_collection(collection_file, token)
    with tempfile.NamedTemporaryFile(suffix=".newman.json", delete=False) as report_handle:
        report_file = report_handle.name
    env = os.environ.copy()
    env.setdefault("NODE_OPTIONS", "--dns-result-order=ipv4first")
    try:
        result = None
        failures = []
        for attempt in range(1, RATE_LIMIT_RETRIES + 2):
            print(f"Running {COLLECTION_FILE} with API_URL={API_URL}")
            newman_args = command + [
                "run",
                runtime_collection,
                "--env-var",
                f"API_URL={API_URL}",
                "--delay-request",
                str(NEWMAN_REQUEST_DELAY_MS),
                "--reporters",
                "cli,json",
                "--reporter-json-export",
                report_file,
            ]
            result = subprocess.run(
                newman_args,
                cwd=BASE_DIR,
                env=env,
                capture_output=True,
                text=True,
                encoding="utf-8",
                errors="replace",
            )
            if result.stdout:
                print(redact_secrets(result.stdout), end="")
            if result.stderr:
                print(redact_secrets(result.stderr), file=sys.stderr, end="")

            failures = failed_request_names(report_file)
            if result.returncode == 0 or not report_has_rate_limit_failure(report_file) or attempt > RATE_LIMIT_RETRIES:
                break

            delay_seconds = RATE_LIMIT_RETRY_DELAY_MS / 1000
            print(
                f"Newman saw HTTP 429 rate limiting; retrying collection in {delay_seconds:.1f}s.",
                file=sys.stderr,
            )
            time.sleep(delay_seconds)

        return result.returncode, failures
    finally:
        for path in (runtime_collection, report_file):
            try:
                os.remove(path)
            except OSError:
                pass


def report_postman_health(failures):
    """Print a health summary for Newman collection failures."""
    if failures:
        print("Unhealthy Postman requests (total {}):".format(len(failures)))
        for failure in failures:
            print(failure)
    else:
        print("\nAll Postman requests executed successfully.")


def main():
    """Parse CLI/env settings and run the Automap Postman collection."""
    token = get_auth_token(sys.argv[1:])
    if not token:
        return 1

    status, failures = run_collection(token)
    if status != 0 and not failures:
        failures = [COLLECTION_FILE]
    report_postman_health(failures)
    return 1 if status != 0 or failures else 0


if __name__ == "__main__":
    sys.exit(main())
