# AutoMap in 5 Minutes: Java Tutorial

This tutorial shows how to use a locally defined Java client to interact with the AutoMap API, mirroring the cURL examples provided in the project. Each cURL example has a corresponding Java/Gradle test command.

## Prerequisites

- JDK 17+ must be installed
- Gradle (7.2+)

The API URL for AutoMap is:

`export API_URL=https://automap.terminology.tools`

Run this command before the sample calls below as they expect $API_URL to be set.

## Building the Code

It is possible that your file permissions may not be set up correctly to run the ./gradlew commands. If you run into any errors regarding permissions, run the following command from the `java-examples` directory:

```
chmod 755 ./gradlew
```

This should explicitly set read, write, and execute permissions for running the ./gradlew commands.

Once permissions are set, building the java-examples should be as simple as running the following command from this directory.

```
./gradlew clean build
```

This will invoke Gradle to build the model objects and the clients themselves and then will also run the unit tests which demonstrate use of the client to make actual API calls against AutoMap.

If you only want to build (for example to run the tests separately) then run:

```
./gradlew clean build -x test
```

This will build the model objects and clients, while not running the tests.

## Authentication

AutoMap API requires Bearer Token authentication. You can set up authentication in two ways:

1. At the end of each `./gradlew test` run, add these two parameters: `-Pusername=<username> -Ppassword=<password>`.
2. In `java-examples/build.gradle`, set your username and password in the test section:

```
test {
    useJUnitPlatform()
    testLogging {
        events "passed", "skipped", "failed"
        showStandardStreams = true
    }
    systemProperty 'username', project.findProperty('username') ?: 'defaultUsername'
    systemProperty 'password', project.findProperty('password') ?: 'defaultPassword'
}
```
Replace 'defaultUsername` with your username, and 'defaultPassword' with your password.


Note that failure to properly set up this authentication <b>will result in all calls to the Termhub API failing with a 403 error.</b>

### Sample Java tests
-----------------

The following examples can be typed into the command line of any terminal that has cURL and jq installed. It will assume that you have set your default username and password in the build.gradle (except for the login endpoint where those are explicit parameters).

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


[Back to Top](#wci-automap-in-5-minutes-java-tutorial)


### Login

Login and acquire an access token for a username and password.

```
./gradlew test --tests api.AuthApiTest.authTest
```

[Back to Top](#wci-automap-in-5-minutes-java-tutorial)


### Get entity configuration

Return entity configuration info, including terminology bindings.

```
./gradlew test --tests api.MappingApiTest.getEntityConfigTest
```

See sample payload data from this call in [`samples/get-entity-configuration.txt`](samples/get-entity-configuration.txt)

[Back to Top](#wci-automap-in-5-minutes-java-tutorial)


### Get application metadata

Return application metadata, including values that can be passed as various parameters in mapping tasks.

```
./gradlew test --tests api.MappingApiTest.getApplicationMetadataTest
```

See sample payload data from this call in [`samples/get-application-metadata.txt`](samples/get-application-metadata.txt)

[Back to Top](#wci-automap-in-5-minutes-java-tutorial)


### Get version information for components of the application

Return application version information and versions for various of the included components.

```
./gradlew test --tests api.MappingApiTest.getVersionInfoTest
```

See sample payload data from this call in [`samples/get-version-information.txt`](samples/get-version-information.txt)

[Back to Top](#wci-automap-in-5-minutes-java-tutorial)


### Health check

Performs a health check on the service.  It reports a health check object that indicates "true" or "false"
whether the service is healthy.

```
./gradlew test --tests api.MappingApiTest.healthCheckTest
```

See sample payload data from this call in [`samples/health-check.txt`](samples/health-check.txt)

[Back to Top](#wci-automap-in-5-minutes-java-tutorial)


### Map from a starting terminology and code

Perform mapping to verify that a terminology and code are valid for a known entity type.
In this example 22298006 is the code for "myocardial infarction" in SNOMEDCT.

```
./gradlew test --tests api.MappingApiTest.mapSimpleTerminologyCodeTest
```

See sample payload data from this call in [`samples/map-simple-terminology-code.txt`](samples/map-simple-terminology-code.txt)

[Back to Top](#wci-automap-in-5-minutes-java-tutorial)


### Map from a starting terminology and inactive code

Perform mapping on an inactive code in a terminology for a known entity type.
In this example 194801005 is a retired code that resolves in SNOMEDCT to the active
code for "myocardial infarction".

```
./gradlew test --tests api.MappingApiTest.mapSimpleTerminologyInactiveCodeTest
```

See sample payload data from this call in [`samples/map-simple-terminology-inactive-code.txt`](samples/map-simple-terminology-inactive-code.txt)

[Back to Top](#wci-automap-in-5-minutes-java-tutorial)


### Map from a starting terminology and invalid code

Perform mapping on an invalid code in a terminology for a known entity type.
In this example, "abcdef" is an obviously bad code. The result is a map to no target.

```
./gradlew test --tests api.MappingApiTest.mapSimpleTerminologyInvalidCodeTest
```

[Back to Top](#wci-automap-in-5-minutes-java-tutorial)

See sample payload data from this call in [`samples/map-simple-terminology-invalid-code.txt`](samples/map-simple-terminology-invalid-code.txt)

### Map from a simple bodyPart text string

Perform mapping on a text string for a body part entity type.

```
./gradlew test --tests api.MappingApiTest.mapBodyPartTextTest
```

See sample payload data from this call in [`samples/map-bodyPart-text.txt`](samples/map-bodyPart-text.txt)

[Back to Top](#wci-automap-in-5-minutes-java-tutorial)


### Map from a simple condition text string

Perform mapping on a text string for a condition entity type.

```
./gradlew test --tests api.MappingApiTest.mapConditionTextTest
```

See sample payload data from this call in [`samples/map-condition-text.txt`](samples/map-condition-text.txt)

[Back to Top](#wci-automap-in-5-minutes-java-tutorial)


### Map from a simple labResult text string

Perform mapping on a text string for a lab result entity type.

```
./gradlew test --tests api.MappingApiTest.mapLabResultTextTest
```

See sample payload data from this call in [`samples/map-labResult-text.txt`](samples/map-labResult-text.txt)

[Back to Top](#wci-automap-in-5-minutes-java-tutorial)


### Map from a simple medication text string

Perform mapping on a text string for a medication entity type.

```
./gradlew test --tests api.MappingApiTest.mapMedicationTextTest
```

[Back to Top](#wci-automap-in-5-minutes-java-tutorial)


See sample payload data from this call in [`samples/map-medication-text.txt`](samples/map-medication-text.txt)

### Map from a simple procedure text string

Perform mapping on a text string for a procedure entity type.

```
./gradlew test --tests api.MappingApiTest.mapProcedureTextTest
```

See sample payload data from this call in [`samples/map-procedure-text.txt`](samples/map-procedure-text.txt)

[Back to Top](#wci-automap-in-5-minutes-java-tutorial)


### Map from a complex text string

Perform mapping on a text string with multiple values for the condition entity type.

```
./gradlew test --tests api.MappingApiTest.mapConditionComplexTextTest
```

See sample payload data from this call in [`samples/map-conditionComplex-text.txt`](samples/map-conditionComplex-text.txt)

[Back to Top](#wci-automap-in-5-minutes-java-tutorial)


### Map from a simple text string without specifying entity type

Perform mapping on a text string without specifying entity type.  This type of input
attempts to resolve against each top level entity type and produce a range of answers.
This can be used to some extent to "figure out" what kind of things something is. In this
case, the highest confidence answer is a "procedure".

```
./gradlew test --tests api.MappingApiTest.mapNoEntityTypeTextTest
```

See sample payload data from this call in [`samples/map-noEntityType-text.txt`](samples/map-noEntityType-text.txt)

[Back to Top](#wci-automap-in-5-minutes-java-tutorial)


### Map from a simple text string with extra tagging information

Perform mapping on a text string with tagging information in order to show how the output task
and terms mirror "tags" passed in on the input side.  Clients can use this to mark tasks and terms
with their own metadata and tie it back to responses. Note that the output response has task level
tags as well as term level tags.

Use cases for these tags include: (a) attaching a client id to a request, (b) attaching a client
"source of information" to the request, or (c) attaching a client "request time" to the request.

```
./gradlew test --tests api.MappingApiTest.mapWithTagsTextTest
```

See sample payload data from this call in [`samples/map-withTags-text.txt`](samples/map-withTags-text.txt)

[Back to Top](#wci-automap-in-5-minutes-java-tutorial)


### Map from a simple text string with auditing

Perform mapping on a text string for a condition entity type and enable auditing.
The default value of the audit flag is "false".  When using auditing, you can call
back to the API to retrieve the audit trail for a term.

```
./gradlew test --tests api.MappingApiTest.mapWithAuditTextTest
```

See sample payload data from this call in [`samples/map-withAudit-text.txt`](samples/map-withAudit-text.txt)

To retrieve the audit trail, you need to get the task "id" and the term "id" fields from the response
to the prior call.  The following example has taskId and termId derived during testing but need
to be replaced with your own values for this to work:

```
./gradlew test --tests api.MappingApiTest.getAuditTrailTest
```

See sample payload data from this call in [`samples/map-audit-trail.txt`](samples/map-audit-trail.txt)

[Back to Top](#wci-automap-in-5-minutes-java-tutorial)


### Find tasks

Tasks created by making request of the service to perform mapping operations can be retrieved
from the backend. Through parameters, you can control filtering, paging, and sorting.
* query - allows lucene query syntax-style searching within the task model
  * e.g. "query=heart" will find all tasks that have indexed fields matching the word "heart"
  * e.g. "query=tags:taskTagKey1=taskTagValue1" will find all tasks that have a tag with the key "taskTagKey1" and the value "taskTagValue1"
  * More documentation will be provided for this field in the future
* offset/limit - start record and page size (default is offset 0 with limit 10)
* sort/ascending - sort field and "true" for ascending and "false" for descending (default is "true")

```
./gradlew test --tests api.MappingApiTest.findTasksTest
```

See sample payload data from this call in [`samples/find-tasks.txt`](samples/find-tasks.txt)

[Back to Top](#wci-automap-in-5-minutes-java-tutorial)


### Find terms

Terms created by making request of the service to perform mapping operations can be retrieved
from the backend. Through parameters, you can control filtering, paging, and sorting.
* query - allows lucene query syntax-style searching within the task model
  * e.g. "query=heart" will find all tasks that have indexed fields matching the word "heart"
  * e.g. "query=tags:taskTagKey1=taskTagValue1" will find all tasks that have a tag with the key "taskTagKey1" and the value "taskTagValue1"
  * More documentation will be provided for this field in the future
* offset/limit - start record and page size (default is offset 0 with limit 10)
* sort/ascending - sort field and "true" for ascending and "false" for descending (default is "true")

```
./gradlew test --tests api.MappingApiTest.findTermsTest
```

See sample payload data from this call in [`samples/find-terms.txt`](samples/find-terms.txt)

## Notes
- The test class and method names are inferred from the cURL example descriptions and should match the actual Java test implementation.
- If you add new endpoints or cURL examples, add corresponding Java/Gradle test commands here.
- For more details on request/response payloads, see the `samples/` directory or the API documentation.

[Back to Top](#wci-automap-in-5-minutes-java-tutorial)