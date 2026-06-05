import re
import sys


SECRET_PATTERNS = (
    (re.compile(r"(Authorization:\s*Bearer\s+)[^\"'\s]+", re.IGNORECASE), r"\1<redacted>"),
    (re.compile(r"(Bearer\s+)[^\"'\s]+", re.IGNORECASE), r"\1<redacted>"),
    (re.compile(r'("(?:access_token|refresh_token|token|password)"\s*:\s*")[^"]+', re.IGNORECASE), r"\1<redacted>"),
    (re.compile(r"(-Ppassword=)[^\s]+", re.IGNORECASE), r"\1<redacted>"),
    (re.compile(r"(--password\s+)[^\s]+", re.IGNORECASE), r"\1<redacted>"),
)


def configure_standard_streams():
    """Keep runner output live and safe on narrow Windows encodings."""
    for stream_name in ("stdout", "stderr"):
        stream = getattr(sys, stream_name, None)
        reconfigure = getattr(stream, "reconfigure", None)
        if reconfigure is None:
            continue
        try:
            reconfigure(errors="replace", line_buffering=True)
        except (TypeError, ValueError):
            try:
                reconfigure(errors="replace")
            except (TypeError, ValueError):
                pass


def redact_secrets(text):
    """Remove bearer tokens and password-like values from diagnostic output."""
    redacted = text or ""
    for pattern, replacement in SECRET_PATTERNS:
        redacted = pattern.sub(replacement, redacted)
    return redacted


def print_process_failure(tool_name, result, stream=sys.stderr):
    """Print return code plus stderr/stdout for a failed subprocess."""
    print(f"{tool_name} exit code: {result.returncode}", file=stream)

    stderr = redact_secrets(result.stderr).rstrip()
    stdout = redact_secrets(result.stdout).rstrip()
    if stderr:
        print(f"{tool_name} stderr:", file=stream)
        print(stderr, file=stream)
    if stdout:
        print(f"{tool_name} stdout:", file=stream)
        print(stdout, file=stream)
    if not stderr and not stdout:
        print(f"{tool_name} produced no stdout or stderr.", file=stream)
