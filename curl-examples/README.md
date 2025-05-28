# WCI Automap in 5 Minutes: Curl Tutorial

This tutorial shows how to use raw cURL commands to interact with the WCI Automap API.

Prerequisites
-------------
* curl must be installled ([Download cURL](https://curl.haxx.se/dlwiz/))
* jq must be installed ([Download jq](https://stedolan.github.io/jq/download/))

The API URL for the WCI Automap is:

`export API_URL=https://automap.terminology.tools`

Run this command before the sample curl calls below as they expect $API_URL to be set.

When using an API_URL that points to an instance (such as https://automap.terminology.tools) that
requires authentication, the login call must first be used to obtain an access token.   


Sample cURL Calls
-----------------

The following examples can be typed into the command line of any terminal that has cURL and jq installed.

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

### Login

Login and acquire an access token for a username and password.  
Replace <username> with your username and <password> with your password.  
The commands below will set a `token` variable equal to the access token.

```
username=<username>
password="<password>"
cat > /tmp/auth.txt << EOF
{ "grant_type": "username_password", "username": "$username", "password": "$password"}
EOF
token=`curl -s -X POST "$API_URL/auth/token" -d "@/tmp/auth.txt" -H "Content-type: application/json" | jq -r '.access_token'`
/bin/rm -f /tmp/auth.txt
```

See sample payload data from this call in [`samples/login.txt`](samples/login.txt)

### Get entity configuration

Return entity configuration info, including terminology bindings.

```
curl -s -H "Authorization: Bearer $token" "$API_URL/api/v1/mapping/config" | jq
```

See sample payload data from this call in [`samples/get-entity-configuration.txt`](samples/get-entity-configuration.txt)

[Back to Top](#wci-automap-in-5-minutes-curl-tutorial)


# Get application metadata

Return application metadata, including values that can be passed as various parameters in mapping tasks.

```
curl -s -H "Authorization: Bearer $token" "$API_URL/api/v1/mapping/metadata" | jq
```

See sample payload data from this call in [`samples/get-application-metadata.txt`](samples/get-application-metadata.txt)

[Back to Top](#wci-automap-in-5-minutes-curl-tutorial)


# Get version information for components of the application

Return application version information and versions for various of the included components.

```
curl -s -H "Authorization: Bearer $token" "$API_URL/api/v1/mapping/version" | jq
```

See sample payload data from this call in [`samples/get-version-information.txt`](samples/get-version-information.txt)

[Back to Top](#wci-automap-in-5-minutes-curl-tutorial)


# Health check

Performs a health check on the service.  It reports a health check object that indicates "true" or "false" 
whether the service is healthy.

```
curl -s -H "Authorization: Bearer $token" "$API_URL/api/v1/mapping/health" | jq
```

See sample payload data from this call in [`samples/health-check.txt`](samples/health-check.txt)

[Back to Top](#wci-automap-in-5-minutes-curl-tutorial)


# Map from a starting terminology and code

Perform mapping to verify that a terminology and code are valid for a known entity type.
In this example 22298006 is the code for "myocardial infarction" in SNOMEDCT.

```
curl -s -H "Authorization: Bearer $token" -H "Content-type: application/json" \
 "$API_URL/api/v1/mapping/task" -d '
{
  "terms": [
    {
      "entityType": "condition",
      "terminology": "http://snomed.info/sct",
      "code": "22298006",
      "inputType": "string"
    }
  ]
}' | jq
```

See sample payload data from this call in [`samples/map-simple-terminology-code.txt`](samples/map-simple-terminology-code.txt)

[Back to Top](#wci-automap-in-5-minutes-curl-tutorial)


# Map from a starting terminology and inactive code

Perform mapping on an inactive code in a terminology for a known entity type.
In this example 194801005 is a retired code that resolves in SNOMEDCT to the active
code for "myocardial infarction".

```
curl -s -H "Authorization: Bearer $token" -H "Content-type: application/json" \
 "$API_URL/api/v1/mapping/task" -d '
{
  "terms": [
    {
      "entityType": "condition",
      "terminology": "http://snomed.info/sct",
      "code": "194801005",
      "inputType": "string"
    }
  ]
}' | jq
```

See sample payload data from this call in [`samples/map-simple-terminology-inactive-code.txt`](samples/map-simple-terminology-inactive-code.txt)

[Back to Top](#wci-automap-in-5-minutes-curl-tutorial)


# Map from a starting terminology and invalid code

Perform mapping on an invalid code in a terminology for a known entity type.
In this example, "abcdef" is an obviously bad code. The result is a map to no target.

```
curl -s -H "Authorization: Bearer $token" -H "Content-type: application/json" \
 "$API_URL/api/v1/mapping/task" -d '
{
  "terms": [
    {
      "entityType": "condition",
      "terminology": "http://snomed.info/sct",
      "code": "abcdef",
      "inputType": "string"
    }
  ]
}' | jq
```

See sample payload data from this call in [`samples/map-simple-terminology-invalid-code.txt`](samples/map-simple-terminology-invalid-code.txt)

[Back to Top](#wci-automap-in-5-minutes-curl-tutorial)


# Map from a simple bodyPart text string

Perform mapping on a text string for a body part entity type.

```
curl -s -H "Authorization: Bearer $token" -H "Content-type: application/json" \
 "$API_URL/api/v1/mapping/task" -d '
{
  "terms": [
    {
      "entityType": "bodyPart",
      "term": "left ear",
      "inputType": "string"
    }
  ],
  "minConfidence": 0.7
}' | jq
```

See sample payload data from this call in [`samples/map-bodyPart-text.txt`](samples/map-bodyPart-text.txt)

[Back to Top](#wci-automap-in-5-minutes-curl-tutorial)


# Map from a simple condition text string

Perform mapping on a text string for a condition entity type.

```
curl -s -H "Authorization: Bearer $token" -H "Content-type: application/json" \
 "$API_URL/api/v1/mapping/task" -d '
{
  "terms": [
    {
      "entityType": "condition",
      "term": "heart attack",
      "inputType": "string"
    }
  ],
  "minConfidence": 0.7
}' | jq
```

See sample payload data from this call in [`samples/map-condition-text.txt`](samples/map-condition-text.txt)

[Back to Top](#wci-automap-in-5-minutes-curl-tutorial)


# Map from a simple labResult text string

Perform mapping on a text string for a lab result entity type.

```
curl -s -H "Authorization: Bearer $token" -H "Content-type: application/json" \
 "$API_URL/api/v1/mapping/task" -d '
{
  "terms": [
    {
      "entityType": "labResult",
      "term": "sodium",
      "inputType": "string"
    }
  ],
  "minConfidence": 0.7
}' | jq
```

See sample payload data from this call in [`samples/map-labResult-text.txt`](samples/map-labResult-text.txt)

[Back to Top](#wci-automap-in-5-minutes-curl-tutorial)


# Map from a simple medication text string

Perform mapping on a text string for a medication entity type.

```
curl -s -H "Authorization: Bearer $token" -H "Content-type: application/json" \
 "$API_URL/api/v1/mapping/task" -d '
{
  "terms": [
    {
      "entityType": "medication",
      "term": "aspirin 81mg po",
      "inputType": "string"
    }
  ],
  "minConfidence": 0.7
}' | jq
```

See sample payload data from this call in [`samples/map-medication-text.txt`](samples/map-medication-text.txt)

[Back to Top](#wci-automap-in-5-minutes-curl-tutorial)

# Map from a simple procedure text string

Perform mapping on a text string for a procedure entity type.

```
curl -s -H "Authorization: Bearer $token" -H "Content-type: application/json" \
 "$API_URL/api/v1/mapping/task" -d '
{
  "terms": [
    {
      "entityType": "procedure",
      "term": "chest mri",
      "inputType": "string"
    }
  ],
  "minConfidence": 0.7
}' | jq
```

See sample payload data from this call in [`samples/map-procedure-text.txt`](samples/map-procedure-text.txt)

[Back to Top](#wci-automap-in-5-minutes-curl-tutorial)


# Map from a complex text string

Perform mapping on a text string with multiple values for the condition entity type.

```
curl -s -H "Authorization: Bearer $token" -H "Content-type: application/json" \
 "$API_URL/api/v1/mapping/task" -d '
{
  "terms": [
    {
      "entityType": "condition",
      "term": "fever, cough, and headache",
      "inputType": "string"
    }
  ],
  "minConfidence": 0.7
}' | jq
```

See sample payload data from this call in [`samples/map-conditionComplex-text.txt`](samples/map-conditionComplex-text.txt)

[Back to Top](#wci-automap-in-5-minutes-curl-tutorial)


# Map from a simple text string without specifying entity type

Perform mapping on a text string without specifying entity type.  This type of input
attempts to resolve against each top level entity type and produce a range of answers.
This can be used to some extent to "figure out" what kind of things something is. In this 
case, the highest confidence answer is a "procedure".

```
curl -s -H "Authorization: Bearer $token" -H "Content-type: application/json" \
 "$API_URL/api/v1/mapping/task" -d '
{
  "terms": [
    {
      "term": "chest mri",
      "inputType": "string"
    }
  ],
  "minConfidence": 0.7
}' | jq
```

See sample payload data from this call in [`samples/map-noEntityType-text.txt`](samples/map-noEntityType-text.txt)

[Back to Top](#wci-automap-in-5-minutes-curl-tutorial)


# Map from a simple text string with extra tagging information

Perform mapping on a text string with tagging information in order to show how the output task
and terms mirror "tags" passed in on the input side.  Clients can use this to mark tasks and terms
with their own metadata and tie it back to responses. Note that the output response has task level
tags as well as term level tags. 

Use cases for these tags include: (a) attaching a client id to a request, (b) attaching a client 
"source of information" to the request, or (c) attaching a client "request time" to the request.

```
curl -s -H "Authorization: Bearer $token" -H "Content-type: application/json" \
 "$API_URL/api/v1/mapping/task" -d '
{
  "terms": [
    {
      "entityType": "condition",
      "term": "heart attack",
      "inputType": "string",
      "tags": [ { "key": "termTagKey1", "value": "termTagValue1" },
                { "key": "termTagKey2", "value": "termTagValue2" }  ]
    }
  ],
  "minConfidence": 0.7,
  "tags": [ { "key": "taskTagKey1", "value": "taskTagValue1" },
            { "key": "taskTagKey2", "value": "taskTagValue2" }  ]
}' | jq
```

See sample payload data from this call in [`samples/map-withTags-text.txt`](samples/map-withTags-text.txt)

[Back to Top](#wci-automap-in-5-minutes-curl-tutorial)


# Map from a simple text string with auditing

Perform mapping on a text string for a condition entity type and enable auditing.  
The default value of the audit flag is "false".  When using auditing, you can call 
back to the API to retrieve the audit trail for a term.

```
curl -s -H "Authorization: Bearer $token" -H "Content-type: application/json" \
 "$API_URL/api/v1/mapping/task" -d '
{
  "terms": [
    {
      "entityType": "condition",
      "term": "heart attack",
      "inputType": "string"
    }
  ],
  "minConfidence": 0.7,
  "audit": true
}' | jq
```

See sample payload data from this call in [`samples/map-withAudit-text.txt`](samples/map-withAudit-text.txt)

To retrieve the audit trail, you need to get the task "id" and the term "id" fields from the response
to the prior call.  The following example has taskId and termId derived during testing but need
to be replaced with your own values for this to work:

```
taskId=`cat samples/map-withAudit-text.txt | jq -r '.id'`
termId=`cat samples/map-withAudit-text.txt | jq -r '.terms[0].id'`
curl -s -H "Authorization: Bearer $token" "$API_URL/api/v1/mapping/task/$taskId/term/$termId/audit" | jq
```

See sample payload data from this call in [`samples/map-audit-trail.txt`](samples/map-audit-trail.txt)

[Back to Top](#wci-automap-in-5-minutes-curl-tutorial)


# Find tasks

Tasks created by making request of the service to perform mapping operations can be retrieved 
from the backend. Through parameters, you can control filtering, paging, and sorting.
* query - allows lucene query syntax-style searching within the task model
  * e.g. "query=heart" will find all tasks that have indexed fields matching the word "heart"
  * e.g. "query=tags:taskTagKey1=taskTagValue1" will find all tasks that have a tag with the key "taskTagKey1" and the value "taskTagValue1"
  * More documentation will be provided for this field in the future
* offset/limit - start record and page size (default is offset 0 with limit 10)
* sort/ascending - sort field and "true" for ascending and "false" for descending (default is "true")  

```
curl -s -H "Authorization: Bearer $token" "$API_URL/api/v1/mapping/task?limit=10&query=terms.term:heart" | jq
```

See sample payload data from this call in [`samples/find-tasks.txt`](samples/find-tasks.txt)

[Back to Top](#wci-automap-in-5-minutes-curl-tutorial)


# Find terms

Terms created by making request of the service to perform mapping operations can be retrieved 
from the backend. Through parameters, you can control filtering, paging, and sorting.
* query - allows lucene query syntax-style searching within the task model
  * e.g. "query=heart" will find all tasks that have indexed fields matching the word "heart"
  * e.g. "query=tags:taskTagKey1=taskTagValue1" will find all tasks that have a tag with the key "taskTagKey1" and the value "taskTagValue1"
  * More documentation will be provided for this field in the future
* offset/limit - start record and page size (default is offset 0 with limit 10)
* sort/ascending - sort field and "true" for ascending and "false" for descending (default is "true")  

```
curl -s -H "Authorization: Bearer $token" "$API_URL/api/v1/mapping/term?limit=10&query=term:heart" | jq
```

See sample payload data from this call in [`samples/find-terms.txt`](samples/find-terms.txt)

[Back to Top](#wci-automap-in-5-minutes-curl-tutorial)
