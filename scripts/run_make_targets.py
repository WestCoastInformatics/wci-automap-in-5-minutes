import argparse
import os
import re
import subprocess
import sys

from process_output import configure_standard_streams


configure_standard_streams()


PROJECT_ROOT = os.path.dirname(os.path.dirname(os.path.abspath(__file__)))
FAILURE_SECTION_PATTERN = re.compile(r"^Unhealthy .*\((?:count|total) \d+\):?$")
SUMMARY_STOP_PATTERN = re.compile(r"^(Healthy |Unhealthy |All |make\[|Running |Check summary|Run summary)")


def log(message=""):
    """Write runner status to stderr so it stays ordered with tool logs."""
    print(message, file=sys.stderr, flush=True)


def parse_args():
    """Parse the make executable, forwarded variable assignments, and targets."""
    parser = argparse.ArgumentParser(description="Run Make targets and summarize failures at the end.")
    parser.add_argument("--make", default="make", help="Make executable to use for nested target runs.")
    parser.add_argument("--label", default="target", help="Name to show before each target.")
    parser.add_argument("--summary-title", default="Run summary", help="Heading to print before the final summary.")
    parser.add_argument("--success-message", default="All targets passed.", help="Message to print when no targets fail.")
    parser.add_argument("--failure-label", default="Failed targets", help="Label to use for the failed target list.")
    parser.add_argument(
        "--set",
        action="append",
        default=[],
        metavar="NAME=VALUE",
        help="Variable assignment to forward to each nested make target.",
    )
    parser.add_argument("targets", nargs="+", help="Make targets to run in order.")
    return parser.parse_args()


def run_target(make_command, forwarded_variables, label, target):
    """Run one Make target, echo its output, and return its status and output."""
    command = [make_command, *forwarded_variables, target]
    log(f"\nRunning {label}: {target}")
    try:
        process = subprocess.Popen(
            command,
            cwd=PROJECT_ROOT,
            stdout=subprocess.PIPE,
            stderr=subprocess.STDOUT,
            text=True,
            encoding="utf-8",
            errors="replace",
            bufsize=1,
        )
    except OSError as error:
        message = f"Unable to run {target}: {error}"
        log(message)
        return 127, message

    output = []
    for line in process.stdout:
        output.append(line)
        print(line, end="", flush=True)
    return process.wait(), "".join(output)


def extract_failed_items(output):
    """Extract failed commands/tests from check runner health summaries."""
    failed_items = []
    collecting = False

    for line in output.splitlines():
        stripped = line.strip()
        if not stripped:
            continue

        if FAILURE_SECTION_PATTERN.match(stripped):
            collecting = True
            continue

        if collecting and SUMMARY_STOP_PATTERN.match(stripped):
            collecting = False

        if collecting:
            failed_items.append(stripped)

    return failed_items


def print_summary(failures, summary_title, success_message, failure_label):
    """Print the final status after all requested targets have run."""
    log(f"\n{summary_title}")
    if not failures:
        log(f"  {success_message}")
        return

    log(f"  {failure_label} ({len(failures)}):")
    for target, exit_code, failed_items in failures:
        reason = f"exit code {exit_code}" if exit_code else "reported failed tests"
        log(f"  - {target} ({reason})")
        if failed_items:
            for item in failed_items:
                log(f"    - {item}")
        else:
            log("    - No specific failed test list was reported by this check.")


def main():
    """Run all requested Make targets and exit nonzero if any target failed."""
    args = parse_args()
    failures = []

    for target in args.targets:
        exit_code, output = run_target(args.make, args.set, args.label, target)
        failed_items = extract_failed_items(output)
        if exit_code != 0 or failed_items:
            failures.append((target, exit_code, failed_items))

    print_summary(failures, args.summary_title, args.success_message, args.failure_label)
    return 1 if failures else 0


if __name__ == "__main__":
    sys.exit(main())
