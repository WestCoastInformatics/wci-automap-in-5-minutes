import argparse
import glob
import json
import os
import shutil
import sys


SEVERITIES = ("CRITICAL", "HIGH", "MEDIUM", "LOW", "UNKNOWN")


def parse_args():
    """Parse summary options for Trivy scan reports."""
    parser = argparse.ArgumentParser(description="Summarize Trivy scan results across repo scan areas.")
    parser.add_argument("--report-dir", default=os.path.join("build", "trivy", "reports"))
    parser.add_argument("--strict", action="store_true", help="Exit nonzero when any finding exists.")
    parser.add_argument("--reset", action="store_true", help="Delete old scan reports before a new run.")
    return parser.parse_args()


def reset_reports(report_dir):
    """Remove old Trivy report files so final summaries only reflect this run."""
    if os.path.isdir(report_dir):
        shutil.rmtree(report_dir)
    os.makedirs(report_dir, exist_ok=True)


def load_summaries(report_dir):
    """Load all scan summary files produced during this run."""
    summaries = []
    for path in sorted(glob.glob(os.path.join(report_dir, "*.summary.json"))):
        with open(path, "r", encoding="utf-8") as handle:
            summaries.append(json.load(handle))
    display_order = {"source": 0, "java": 1, "python": 2, "postman": 3}
    summaries.sort(key=lambda summary: (display_order.get(summary["name"].lower(), 99), summary["name"]))
    return summaries


def total_counts(summaries):
    """Combine finding counts across every scan area."""
    counts = {
        "vulnerabilities": 0,
        "secrets": 0,
        "misconfigurations": 0,
        "severity_counts": {severity: 0 for severity in SEVERITIES},
    }
    for summary in summaries:
        summary_counts = summary["counts"]
        counts["vulnerabilities"] += summary_counts["vulnerabilities"]
        counts["secrets"] += summary_counts["secrets"]
        counts["misconfigurations"] += summary_counts["misconfigurations"]
        for severity, count in summary_counts["severity_counts"].items():
            counts["severity_counts"][severity] = counts["severity_counts"].get(severity, 0) + count
    return counts


def format_count(count, singular, plural=None):
    """Format a count with the right singular or plural label."""
    return f"{count} {singular if count == 1 else plural or singular + 's'}"


def format_area(summary):
    """Format one scan area's finding counts for final output."""
    counts = summary["counts"]
    parts = [format_count(counts["vulnerabilities"], "vulnerability", "vulnerabilities")]
    if summary["scans_secrets"]:
        parts.append(format_count(counts["secrets"], "secret"))
    if summary["scans_misconfigurations"]:
        parts.append(format_count(counts["misconfigurations"], "misconfiguration"))
    return f"  - {summary['name']}: found {', '.join(parts)}"


def format_overall(counts):
    """Format the combined repo finding counts."""
    if not has_findings(counts):
        return "Overall: found no vulnerabilities, secrets, or misconfigurations."

    return (
        "Overall: found "
        f"{format_count(counts['vulnerabilities'], 'vulnerability', 'vulnerabilities')}, "
        f"{format_count(counts['secrets'], 'secret')}, "
        f"{format_count(counts['misconfigurations'], 'misconfiguration')}."
    )


def has_findings(counts):
    """Return whether any vulnerability, secret, or misconfiguration was found."""
    return bool(counts["vulnerabilities"] or counts["secrets"] or counts["misconfigurations"])


def main():
    """Print a repo-level Trivy summary and apply strict exit behavior."""
    args = parse_args()
    if args.reset:
        reset_reports(args.report_dir)
        return 0

    summaries = load_summaries(args.report_dir)
    if not summaries:
        print("Trivy scan summary: no scan reports found.", file=sys.stderr)
        return 1

    counts = total_counts(summaries)
    print("\nTrivy scan summary")
    for summary in summaries:
        print(format_area(summary))
    print(format_overall(counts))

    if args.strict and has_findings(counts):
        print("Strict scan failed because Trivy reported findings.", file=sys.stderr)
        return 1
    return 0


if __name__ == "__main__":
    sys.exit(main())
