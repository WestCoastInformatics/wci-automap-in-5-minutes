VERSION ?= 1.0.0
BUILD_DIR ?= ./build
PYTHON ?= python
TRIVY_FLAGS ?=
TRIVY_REPORT_DIR ?= $(BUILD_DIR)/trivy/reports

API_URL ?= https://automap.terminology.tools
AUTOMAP_USERNAME ?= $(AUTOMAP_USER)

export API_URL
export AUTOMAP_USER
export AUTOMAP_USERNAME
export AUTOMAP_PASSWORD
export AUTOMAP_TOKEN
export TERMHUB_USER
export TERMHUB_USERNAME
export TERMHUB_PASSWORD
export TERMHUB_TOKEN
export TOKEN

.PHONY: help all resample samples check test check-curl check-java check-postman scan scan-strict scan-source scan-java scan-prepare scan-prepare-java regenerate regenerate-java clean

help:
	@echo "WCI Automap in 5 Minutes maintenance targets"
	@echo "  make resample          Recreate curl and Java sample outputs"
	@echo "  make check             Run curl, Java, and Postman checks"
	@echo "  make scan              Run Trivy source and Java dependency scans"
	@echo "  make scan-strict       Run Trivy scans and fail if vulnerabilities are found"
	@echo "  make regenerate        Regenerate Java client into doc/code-generator/build"
	@echo ""
	@echo "Credentials: set AUTOMAP_USER and AUTOMAP_PASSWORD, or AUTOMAP_TOKEN."

all: check

resample: check-curl check-java

samples: resample

check:
	$(PYTHON) scripts/run_make_targets.py --make "$(MAKE)" --label "check" --summary-title "Check summary" --success-message "All checks passed." --failure-label "Failed checks" check-curl check-java check-postman

test: check

check-curl:
	cd curl-examples && $(PYTHON) curl_check.py

check-java:
	cd java-examples && $(PYTHON) java_check.py

check-postman:
	cd postman-examples && $(PYTHON) postman_check.py

scan:
	$(PYTHON) scripts/trivy_scan_summary.py --report-dir "$(TRIVY_REPORT_DIR)" --reset
	$(MAKE) --no-print-directory scan-source
	$(MAKE) --no-print-directory scan-java
	$(PYTHON) scripts/trivy_scan_summary.py --report-dir "$(TRIVY_REPORT_DIR)"

scan-strict:
	$(PYTHON) scripts/trivy_scan_summary.py --report-dir "$(TRIVY_REPORT_DIR)" --reset
	$(MAKE) --no-print-directory scan-source
	$(MAKE) --no-print-directory scan-java
	$(PYTHON) scripts/trivy_scan_summary.py --report-dir "$(TRIVY_REPORT_DIR)" --strict

scan-source:
	$(PYTHON) scripts/run_trivy_scan.py --name source --path . --scanners vuln,secret,misconfig --report-dir "$(TRIVY_REPORT_DIR)" --trivy-flags "$(TRIVY_FLAGS)" --skip-dir .git --skip-dir .gradle --skip-dir .gradle-user-home --skip-dir build --skip-dir node_modules --skip-file java-examples/gradle.lockfile

scan-prepare: scan-prepare-java

scan-prepare-java:
	$(PYTHON) scripts/run_gradle.py java-examples resolveAndLockAll --write-locks

scan-java: scan-prepare-java
	$(PYTHON) scripts/run_trivy_scan.py --name java --path java-examples --scanners vuln --report-dir "$(TRIVY_REPORT_DIR)" --trivy-flags "$(TRIVY_FLAGS)" --skip-dir .gradle --skip-dir .gradle-user-home --skip-dir build

regenerate:
	$(PYTHON) scripts/run_gradle.py doc/code-generator buildClients

regenerate-java:
	$(PYTHON) scripts/run_gradle.py doc/code-generator buildJavaSdk

clean:
	@echo "Cleaning ${BUILD_DIR} directory if it exists"
