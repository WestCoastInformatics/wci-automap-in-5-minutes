import argparse
import json
import os
import shlex
import subprocess
import sys


SEVERITIES = ("CRITICAL", "HIGH", "MEDIUM", "LOW", "UNKNOWN")


def parse_args():
    """Parse the Trivy scan area and passthrough scan options."""
    parser = argparse.ArgumentParser(description="Run one Trivy scan and write a summary file.")
    parser.add_argument("--name", required=True, help="Human-readable scan area name.")
    parser.add_argument("--path", required=True, help="Path to scan.")
    parser.add_argument("--scanners", default="vuln", help="Comma-separated Trivy scanners to enable.")
    parser.add_argument("--report-dir", default=os.path.join("build", "trivy", "reports"))
    parser.add_argument("--trivy-flags", default="", help="Extra flags to pass to Trivy.")
    parser.add_argument("--skip-dir", action="append", default=[], help="Directory to skip.")
    parser.add_argument("--skip-file", action="append", default=[], help="File to skip.")
    return parser.parse_args()


def slugify(name):
    """Convert a scan name into a stable report filename stem."""
    return "".join(character.lower() if character.isalnum() else "-" for character in name).strip("-")


def scanner_enabled(scanners, scanner_name):
    """Return whether a Trivy scanner name is enabled for this run."""
    return scanner_name in {scanner.strip() for scanner in scanners.split(",") if scanner.strip()}


def command_for(args, report_path):
    """Build a Trivy JSON command for the requested scan area."""
    command = [
        "trivy",
        "fs",
        "--format",
        "json",
        "--output",
        report_path,
        "--scanners",
        args.scanners,
    ]
    for skip_dir in args.skip_dir:
        command.extend(["--skip-dirs", skip_dir])
    for skip_file in args.skip_file:
        command.extend(["--skip-files", skip_file])
    command.extend(shlex.split(args.trivy_flags))
    command.append(args.path)
    return command


def severity_counts(items):
    """Count Trivy findings by severity."""
    counts = {severity: 0 for severity in SEVERITIES}
    for item in items:
        severity = str(item.get("Severity") or "UNKNOWN").upper()
        counts[severity if severity in counts else "UNKNOWN"] += 1
    return counts


def count_findings(report):
    """Count vulnerabilities, secrets, and misconfigurations in a Trivy report."""
    vulnerabilities = []
    secrets = []
    misconfigurations = []

    for result in report.get("Results", []):
        vulnerabilities.extend(result.get("Vulnerabilities", []) or [])
        secrets.extend(result.get("Secrets", []) or [])
        misconfigurations.extend(result.get("Misconfigurations", []) or [])

    return {
        "vulnerabilities": len(vulnerabilities),
        "secrets": len(secrets),
        "misconfigurations": len(misconfigurations),
        "severity_counts": severity_counts(vulnerabilities),
    }


def format_count(count, singular, plural=None):
    """Format a count with the right singular or plural label."""
    return f"{count} {singular if count == 1 else plural or singular + 's'}"


def format_severities(counts):
    """Format nonzero vulnerability severities for compact summaries."""
    nonzero = [f"{count} {severity.lower()}" for severity, count in counts.items() if count]
    return ", ".join(nonzero)


def summary_sentence(summary):
    """Create one human-readable summary line for a scan area."""
    counts = summary["counts"]
    parts = [format_count(counts["vulnerabilities"], "vulnerability", "vulnerabilities")]
    if summary["scans_secrets"]:
        parts.append(format_count(counts["secrets"], "secret"))
    if summary["scans_misconfigurations"]:
        parts.append(format_count(counts["misconfigurations"], "misconfiguration"))

    severity_text = format_severities(counts["severity_counts"])
    suffix = f" ({severity_text})" if severity_text else ""
    return f"{summary['name']}: found {', '.join(parts)}{suffix}."


def read_report(report_path):
    """Load the JSON report emitted by Trivy."""
    with open(report_path, "r", encoding="utf-8") as handle:
        return json.load(handle)


def write_summary(summary_path, summary):
    """Persist scan counts for the final repo-level summary."""
    with open(summary_path, "w", encoding="utf-8") as handle:
        json.dump(summary, handle, indent=2)
        handle.write("\n")


def main():
    """Run Trivy for one area and write its JSON report and summary."""
    args = parse_args()
    os.makedirs(args.report_dir, exist_ok=True)

    report_path = os.path.abspath(os.path.join(args.report_dir, f"{slugify(args.name)}.trivy.json"))
    summary_path = os.path.abspath(os.path.join(args.report_dir, f"{slugify(args.name)}.summary.json"))
    command = command_for(args, report_path)

    print(f"Running Trivy scan for {args.name}: {args.path}")
    result = subprocess.run(command, text=True, encoding="utf-8", errors="replace", capture_output=True)
    if result.stdout:
        print(result.stdout, end="")
    if result.stderr:
        print(result.stderr, end="")
    if result.returncode != 0:
        print(f"Trivy scan for {args.name} failed with exit code {result.returncode}.", file=sys.stderr)
        return result.returncode

    try:
        report = read_report(report_path)
    except (OSError, json.JSONDecodeError) as error:
        print(f"Unable to read Trivy report for {args.name}: {error}", file=sys.stderr)
        return 1

    summary = {
        "name": args.name,
        "path": args.path,
        "report": report_path,
        "scanners": args.scanners,
        "scans_secrets": scanner_enabled(args.scanners, "secret"),
        "scans_misconfigurations": scanner_enabled(args.scanners, "misconfig"),
        "counts": count_findings(report),
    }
    write_summary(summary_path, summary)

    print(summary_sentence(summary))
    print(f"Report: {report_path}")
    return 0


if __name__ == "__main__":
    sys.exit(main())
