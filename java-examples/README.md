# AutoMap in 5 Minutes: Java Tutorial

This tutorial shows how to use Java to interact with the AutoMap API. Most examples use the generated Java client. Health checks and FHIR mapping use small raw Java HTTP helpers so the Java demonstrations stay aligned with the cURL and Postman examples while the generated response models catch up to the live response shapes.

## Prerequisites

- JDK 17+
- The Gradle wrapper included in this directory

The default API URL is `https://automap.terminology.tools`. Override it from the project root with `API_URL=...` when using `make`, or through the generated client configuration in custom Java code.

## Authentication

Set credentials in the environment before running tests. Open a terminal, run the two commands for your operating system, and then run the Gradle or `make` command in that same terminal window. Replace `<username>` and `<password>` with your Automap username and password, without the angle brackets.

```bash
export AUTOMAP_USER=<username>
export AUTOMAP_PASSWORD=<password>
```

On Windows PowerShell:

```powershell
$env:AUTOMAP_USER="<username>"
$env:AUTOMAP_PASSWORD="<password>"
```

Gradle project properties `-Pusername=... -Ppassword=...` are still accepted for ad hoc local runs so older commands keep working. Prefer environment variables because command-line secrets can be visible to local process-list tools.

Do not put real credentials into `build.gradle`. The Java tests fail fast when credentials are missing.

## Run Tests Automatically

To automatically run the Gradle test commands listed in this README and refresh sample output files:

```
python java_check.py
```

From the project root, this is also available as `make check-java`.

## Sample Java Tests

- [Login](#login)
- [Get entity configuration](#get-entity-configuration)
- [Get application metadata](#get-application-metadata)
- [Get version information for components of the application](#get-version-information-for-components-of-the-application)
- [Health check](#health-check)
- [Map from a starting terminology and code](#map-from-a-starting-terminology-and-code)
- [Map from a starting terminology and inactive code](#map-from-a-starting-terminology-and-inactive-code)
- [Map from a starting terminology and invalid code](#map-from-a-starting-terminology-and-invalid-code)
- [Map from a simple bodyPart text string](#map-from-a-simple-bodypart-text-string)
- [Map from a simple condition text string](#map-from-a-simple-condition-text-string)
- [Map from a simple labResult text string](#map-from-a-simple-labresult-text-string)
- [Map from a simple medication text string](#map-from-a-simple-medication-text-string)
- [Map from a simple procedure text string](#map-from-a-simple-procedure-text-string)
- [Map from a complex text string](#map-from-a-complex-text-string)
- [Map from a simple text string without specifying entity type](#map-from-a-simple-text-string-without-specifying-entity-type)
- [Map from a simple text string with extra tagging information](#map-from-a-simple-text-string-with-extra-tagging-information)
- [Map from a simple text string with auditing and retrieve audit trail](#map-from-a-simple-text-string-with-auditing-and-retrieve-audit-trail)
- [Find tasks](#find-tasks)
- [Find terms](#find-terms)
- [Map from a FHIR resource](#map-from-a-fhir-resource)
- [Map from a FHIR bundle](#map-from-a-fhir-bundle)

[Back to Top](#automap-in-5-minutes-java-tutorial)

### Login

Login and acquire an access token for a username and password. The test validates the token without printing it.

```
./gradlew test --tests api.LoginApiTest.authTest
```

See sample payload data from this call in [`samples/login.txt`](samples/login.txt)

[Back to Top](#automap-in-5-minutes-java-tutorial)

### Get entity configuration

Return entity configuration info, including terminology bindings.

```
./gradlew test --tests api.MappingApiTest.getEntityConfigTest
```

See sample payload data from this call in [`samples/get-entity-configuration.txt`](samples/get-entity-configuration.txt)

[Back to Top](#automap-in-5-minutes-java-tutorial)

### Get application metadata

Return application metadata, including values that can be passed as various parameters in mapping tasks.

```
./gradlew test --tests api.MappingApiTest.getApplicationMetadataTest
```

See sample payload data from this call in [`samples/get-application-metadata.txt`](samples/get-application-metadata.txt)

[Back to Top](#automap-in-5-minutes-java-tutorial)

### Get version information for components of the application

Return application version information and versions for included components.

```
./gradlew test --tests api.MappingApiTest.getVersionInfoTest
```

See sample payload data from this call in [`samples/get-version-information.txt`](samples/get-version-information.txt)

[Back to Top](#automap-in-5-minutes-java-tutorial)

### Health check

Perform a health check on the service.

```
./gradlew test --tests api.MappingApiTest.healthCheckTest
```

See sample payload data from this call in [`samples/health-check.txt`](samples/health-check.txt)

[Back to Top](#automap-in-5-minutes-java-tutorial)

### Map from a starting terminology and code

Perform mapping to verify that a terminology and code are valid for a known entity type.

```
./gradlew test --tests api.MappingApiTest.mapSimpleTerminologyCodeTest
```

See sample payload data from this call in [`samples/map-simple-terminology-code.txt`](samples/map-simple-terminology-code.txt)

[Back to Top](#automap-in-5-minutes-java-tutorial)

### Map from a starting terminology and inactive code

Perform mapping on an inactive code in a terminology for a known entity type.

```
./gradlew test --tests api.MappingApiTest.mapSimpleTerminologyInactiveCodeTest
```

See sample payload data from this call in [`samples/map-simple-terminology-inactive-code.txt`](samples/map-simple-terminology-inactive-code.txt)

[Back to Top](#automap-in-5-minutes-java-tutorial)

### Map from a starting terminology and invalid code

Perform mapping on an invalid code in a terminology for a known entity type.

```
./gradlew test --tests api.MappingApiTest.mapSimpleTerminologyInvalidCodeTest
```

See sample payload data from this call in [`samples/map-simple-terminology-invalid-code.txt`](samples/map-simple-terminology-invalid-code.txt)

[Back to Top](#automap-in-5-minutes-java-tutorial)

### Map from a simple bodyPart text string

Perform mapping on a text string for a body part entity type.

```
./gradlew test --tests api.MappingApiTest.mapBodyPartTextTest
```

See sample payload data from this call in [`samples/map-bodyPart-text.txt`](samples/map-bodyPart-text.txt)

[Back to Top](#automap-in-5-minutes-java-tutorial)

### Map from a simple condition text string

Perform mapping on a text string for a condition entity type.

```
./gradlew test --tests api.MappingApiTest.mapConditionTextTest
```

See sample payload data from this call in [`samples/map-condition-text.txt`](samples/map-condition-text.txt)

[Back to Top](#automap-in-5-minutes-java-tutorial)

### Map from a simple labResult text string

Perform mapping on a text string for a lab result entity type.

```
./gradlew test --tests api.MappingApiTest.mapLabResultTextTest
```

See sample payload data from this call in [`samples/map-labResult-text.txt`](samples/map-labResult-text.txt)

[Back to Top](#automap-in-5-minutes-java-tutorial)

### Map from a simple medication text string

Perform mapping on a text string for a medication entity type.

```
./gradlew test --tests api.MappingApiTest.mapMedicationTextTest
```

See sample payload data from this call in [`samples/map-medication-text.txt`](samples/map-medication-text.txt)

[Back to Top](#automap-in-5-minutes-java-tutorial)

### Map from a simple procedure text string

Perform mapping on a text string for a procedure entity type.

```
./gradlew test --tests api.MappingApiTest.mapProcedureTextTest
```

See sample payload data from this call in [`samples/map-procedure-text.txt`](samples/map-procedure-text.txt)

[Back to Top](#automap-in-5-minutes-java-tutorial)

### Map from a complex text string

Perform mapping on a text string with multiple values for the condition entity type.

```
./gradlew test --tests api.MappingApiTest.mapConditionComplexTextTest
```

See sample payload data from this call in [`samples/map-conditionComplex-text.txt`](samples/map-conditionComplex-text.txt)

[Back to Top](#automap-in-5-minutes-java-tutorial)

### Map from a simple text string without specifying entity type

Perform mapping on a text string without specifying entity type.

```
./gradlew test --tests api.MappingApiTest.mapNoEntityTypeTextTest
```

See sample payload data from this call in [`samples/map-noEntityType-text.txt`](samples/map-noEntityType-text.txt)

[Back to Top](#automap-in-5-minutes-java-tutorial)

### Map from a simple text string with extra tagging information

Perform mapping on a text string with client-provided tags.

```
./gradlew test --tests api.MappingApiTest.mapWithTagsTextTest
```

See sample payload data from this call in [`samples/map-withTags-text.txt`](samples/map-withTags-text.txt)

[Back to Top](#automap-in-5-minutes-java-tutorial)

### Map from a simple text string with auditing

Perform mapping on a text string and enable auditing.

```
./gradlew test --tests api.MappingApiTest.mapWithAuditTextTest
```

See sample payload data from this call in [`samples/map-withAudit-text.txt`](samples/map-withAudit-text.txt)

Retrieve the audit trail for a term from an audited mapping task.

```
./gradlew test --tests api.MappingApiTest.getAuditTrailTest
```

See sample payload data from this call in [`samples/map-audit-trail.txt`](samples/map-audit-trail.txt)

[Back to Top](#automap-in-5-minutes-java-tutorial)

### Find tasks

Find tasks matching search parameters.

```
./gradlew test --tests api.MappingApiTest.findTasksTest
```

See sample payload data from this call in [`samples/find-tasks.txt`](samples/find-tasks.txt)

[Back to Top](#automap-in-5-minutes-java-tutorial)

### Find terms

Find mapped terms matching search parameters.

```
./gradlew test --tests api.MappingApiTest.findTermsTest
```

See sample payload data from this call in [`samples/find-terms.txt`](samples/find-terms.txt)

[Back to Top](#automap-in-5-minutes-java-tutorial)

### Map from a FHIR resource

Perform mapping on the shared FHIR `Condition` sample payload from the cURL examples and return the updated resource with suggested codes.

```
./gradlew test --tests api.MappingApiTest.mapFhirResourceTest
```

See sample payload data from this call in [`samples/map-fhir-resource.txt`](samples/map-fhir-resource.txt)

[Back to Top](#automap-in-5-minutes-java-tutorial)

### Map from a FHIR bundle

Perform mapping on the shared FHIR `Bundle` sample payload from the cURL examples and return the updated bundle with suggested codes.

```
./gradlew test --tests api.MappingApiTest.mapFhirBundleTest
```

See sample payload data from this call in [`samples/map-fhir-bundle.txt`](samples/map-fhir-bundle.txt)

[Back to Top](#automap-in-5-minutes-java-tutorial)

## SDK-only notes

The generated Java client currently does not expose the service health endpoint. It does expose FHIR mapping, but the generated return type is a `String` while the live endpoint returns a FHIR JSON resource or bundle. The Java demo tests use raw Java HTTP helpers for these response-shape cases and generated SDK methods for the rest.
