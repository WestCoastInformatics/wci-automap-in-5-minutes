import os
import re
import shlex
import subprocess
import sys

"""Read README.md, run listed Gradle test commands, and refresh sample files."""

healthy_scripts = []
unhealthy_scripts = []
BASE_DIR = os.path.dirname(os.path.abspath(__file__))
SCRIPTS_DIR = os.path.abspath(os.path.join(BASE_DIR, "..", "scripts"))
if SCRIPTS_DIR not in sys.path:
    sys.path.insert(0, SCRIPTS_DIR)

from automap_auth import publish_credentials_from_args
from process_output import configure_standard_streams, print_process_failure


configure_standard_streams()


README_PATH = os.path.join(BASE_DIR, "README.md")
GRADLE_USER_HOME = os.path.join(BASE_DIR, ".gradle-user-home")
COMMANDS = "commands"
FILES = "files"


def mark_healthy(command):
    """Track a successful Gradle command without duplicating summary entries."""
    if command not in healthy_scripts:
        healthy_scripts.append(command)


def mark_unhealthy(command):
    """Track a failed Gradle command and remove any earlier healthy entry."""
    if command in healthy_scripts:
        healthy_scripts.remove(command)
    if command not in unhealthy_scripts:
        unhealthy_scripts.append(command)


def check_java_installation():
    """Verify Java is available before running Gradle sample tests."""
    try:
        subprocess.run(["java", "--version"], capture_output=True, check=True, text=True, encoding="utf-8", errors="replace")
    except (FileNotFoundError, subprocess.CalledProcessError):
        print("Java is not installed or not accessible.", file=sys.stderr)
        sys.exit(1)


def run_gradle_test(command):
    """Run a Java Gradle test command and return the raw output."""
    try:
        os.makedirs(GRADLE_USER_HOME, exist_ok=True)
        gradle_env = os.environ.copy()
        gradle_env.setdefault("GRADLE_USER_HOME", GRADLE_USER_HOME)

        gradle_args = shlex.split(command, posix=sys.platform != "win32")
        if gradle_args and gradle_args[0] in ("./gradlew", "gradlew"):
            if sys.platform == "win32":
                gradle_args[0] = "gradlew.bat" if os.path.exists(os.path.join(BASE_DIR, "gradlew.bat")) else "gradlew"
            else:
                gradle_args[0] = "./gradlew"
        if "--rerun-tasks" not in gradle_args:
            gradle_args.append("--rerun-tasks")

        result = subprocess.run(
            gradle_args,
            cwd=BASE_DIR,
            env=gradle_env,
            capture_output=True,
            text=True,
            encoding="utf-8",
            errors="replace",
        )
        if result.returncode == 0:
            mark_healthy(command)
            return result.stdout + result.stderr

        mark_unhealthy(command)
        print(f"Error executing: {command}", file=sys.stderr)
        print_process_failure("gradlew", result)
        return None
    except Exception as error:
        print(f"Exception running gradlew: {error}", file=sys.stderr)
        mark_unhealthy(command)
        return None


def process_markdown():
    """Parse README.md and extract Gradle test commands with sample files."""
    if not os.path.exists(README_PATH):
        print("Error: README.md not found.", file=sys.stderr)
        sys.exit(1)

    with open(README_PATH, "r", encoding="utf-8") as handle:
        lines = handle.readlines()

    sections = []
    current_section = {COMMANDS: [], FILES: []}
    in_section = False

    for line in lines:
        if line.startswith("### ") and not in_section:
            current_section = {COMMANDS: [], FILES: []}
            in_section = True
            continue

        if line.startswith("[Back to Top]") and in_section:
            in_section = False
            if current_section[COMMANDS]:
                sections.append(current_section)
            current_section = {COMMANDS: [], FILES: []}
            continue

        if in_section:
            java_match = re.match(r"^`?(\./gradlew test[^`]*)`?$", line.strip())
            if java_match:
                current_section[COMMANDS].append(java_match.group(1))

            file_matches = re.findall(r"`samples/([^`]+)`", line)
            for match in file_matches:
                current_section[FILES].append(f"samples/{match}")

    if in_section and current_section[COMMANDS]:
        sections.append(current_section)

    return sections


def extract_standard_output(output):
    """Extract sample response text from Gradle's STANDARD_OUT blocks."""
    lines = re.findall(r"STANDARD_OUT\s+(.*?)\s+PASSED", output, re.DOTALL)
    return "".join(line for line in lines)


def run_sections(sections):
    """Run Gradle commands and update corresponding sample files."""
    for section in sections:
        for sample_index, gradle_command in enumerate(section[COMMANDS]):
            print(f"Running: {gradle_command}")
            response = run_gradle_test(gradle_command)
            if response is not None and sample_index >= len(section[FILES]):
                mark_unhealthy(gradle_command)
                print(f"No sample file configured in README for {gradle_command}.", file=sys.stderr)
                continue
            if response is not None:
                sample_output = extract_standard_output(response)
                if not sample_output.strip():
                    mark_unhealthy(gradle_command)
                    print(
                        f"No sample output captured for {gradle_command}; "
                        f"not updating {section[FILES][sample_index]}.",
                        file=sys.stderr,
                    )
                    continue
                sample_path = os.path.join(BASE_DIR, section[FILES][sample_index])
                with open(sample_path, "w", encoding="utf-8") as handle:
                    handle.write(sample_output)
                print(f"Updated: {section[FILES][sample_index]}")


def report_script_health():
    """Print a health summary for all Gradle tests exercised in the run."""
    if unhealthy_scripts:
        print("Healthy scripts (count {}): ".format(len(healthy_scripts))) if healthy_scripts else None
        for script in healthy_scripts:
            print(script)
        print("Unhealthy scripts (count {}):".format(len(unhealthy_scripts)))
        for script in unhealthy_scripts:
            print(script)
    else:
        print("\nAll scripts executed successfully and all test endpoints are healthy.")


if __name__ == "__main__":
    publish_credentials_from_args(sys.argv[1:])
    check_java_installation()
    readme_sections = process_markdown()
    run_sections(readme_sections)
    report_script_health()
    sys.exit(1 if unhealthy_scripts else 0)
