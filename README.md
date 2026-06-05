# WCI Automap in 5 Minutes Tutorial

This is an easy-to-use tutorial for accessing WCI Automap APIs through automap.terminology.tools.
[WCI Automap](https://www.westcoastinformatics.com/products/mapping) healthcare data 
standardization/normalization platform that takes data in a variety of forms and performs
AI-assisted terminology linking.  

This system supports use cases including
* Automated mapping between local coding systems and standards 
* Automated mapping between standard coding systems
* Checking that codes used in data are active and valid in current verisons of coding systems
* Updating retired codes through history mechanisms to verison codes
* Linking of snippets of clinical text to standard terminology codes

[Tutorial Training Video](https://youtu.be/2WHiJzzVUi8)

**Reference deployments**

To test against our Automap server, you will need a username/password account in our 
reference depoyment server at https://automap-ui.terminology.tools.  To request an
account, send email to info@westcoastinformatics.com.

## Table of Contents

1. [Tutorials by Language](#tutorials-by-language)
2. [Use Cases](#use-cases)
3. [Maintenance Commands](#maintenance-commands)
4. [Resources](#resources)
5. [Contributing](#contributing)
6. [License](#license)

## Tutorials by Language

- [Click for Curl examples.](../master/curl-examples/ "Curl Examples")
- [Click for Postman examples.](../master/postman-examples/ "Postman Examples")
- [Click for Java examples.](../master/java-examples/ "Java Examples")


**[Back to top](#table-of-contents)**

## Use Cases

The following cases will be used to demonstrate accessing the WCI Automap API.  These include
access to metadata and config information as well as various modes of requesting mappings to be
performed as individual or batch calls and how to search and retrieve results after the fact.

- Login
- Get entity configuration
- Get application metadata
- Get version information for components of the application
- Health check
- Map from a starting terminology and code
- Map from a starting terminology and inactive code
- Map from a starting terminology and invalid code
- Map from a simple bodyPart text string
- Map from a simple condition text string
- Map from a simple labResult text string
- Map from a simple medication text string
- Map from a simple procedure text string
- Map from a complex text string
- Map from a simple text string without specifying entity type
- Map from a simple text string with extra tagging information
- Map from a simple text string with auditing and retrieve audit trail
- Find tasks
- Find terms

All of the tutorials use an environment variable for the API URL of the deployment:

- API_URL=`https://automap.terminology.tools`

**[Back to top](#table-of-contents)**

## Maintenance Commands

This repo includes a root `Makefile` to refresh samples, run checks, scan dependencies, and regenerate the Java SDK demo client. The commands use the existing cURL, Java, and Postman sample groups only.

Set credentials in the environment before running authenticated checks. Open a terminal, run the two commands for your operating system, and then run `make` in that same terminal window. Replace `<username>` and `<password>` with your Automap username and password, without the angle brackets.

For bash or zsh:

```bash
export AUTOMAP_USER=<username>
export AUTOMAP_PASSWORD=<password>
```

For Windows PowerShell:

```powershell
$env:AUTOMAP_USER="<username>"
$env:AUTOMAP_PASSWORD="<password>"
```

If you already have a bearer token, set `AUTOMAP_TOKEN` or `TOKEN` instead. Existing `TERMHUB_USER`, `TERMHUB_PASSWORD`, and `TERMHUB_TOKEN` variables also work as compatibility aliases.

Common commands:

```bash
make check
make resample
make check-curl
make check-java
make check-postman
make scan
make scan-strict
make regenerate-java
```

`make check` runs cURL, Java, and Postman checks and prints grouped failed commands or tests at the end. `make resample` refreshes cURL and Java sample files. `make scan` runs Trivy source and Java dependency scans, saves JSON reports under `build/trivy/reports`, and prints a final summary of findings by scan area. `make scan-strict` uses the same scans but exits nonzero when Trivy reports vulnerabilities, secrets, or misconfigurations. `make regenerate-java` runs the Java SDK generator.

The Java dependency scan does not require a committed lockfile. `make scan-java` first runs `make scan-prepare-java`, which creates `java-examples/gradle.lockfile` locally with Gradle dependency locking so Trivy can inspect resolved Java dependencies. That file is ignored by Git and can be deleted at any time; the next scan recreates it.

You can override `API_URL` when you need to point checks at another deployment:

```bash
API_URL=https://automap.terminology.tools make check
```

On Windows PowerShell, set the variable before running make:

```powershell
$env:API_URL="https://automap.terminology.tools"
make check
```

**[Back to top](#table-of-contents)**


## Resources

- API Documentation - https://automap.terminology.tools/swagger-ui/index.html

**[Back to top](#table-of-contents)**

## Contributing

1. Fork it!
2. Create your feature branch: `git checkout -b my-new-feature`
3. Commit your changes: `git commit -am 'Add some feature'`
4. Push to the branch: `git push origin my-new-feature`
5. Submit a pull request

**[Back to top](#table-of-contents)**

## Current Contributors

- [Brian Carlsen](https://github.com/bcarlsenca)
- [Other Contributors](https://github.com/WestCoastInformatics/termhub-in-5-minutes/graphs/contributors)

**[Back to top](#table-of-contents)**

## License

See the included [`LICENSE.txt`](LICENSE.txt) file for details.

**[Back to top](#table-of-contents)**
