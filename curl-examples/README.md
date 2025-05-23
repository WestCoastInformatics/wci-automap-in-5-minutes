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
cat > /tmp/auth.txt << EOF
{ "grant_type": "username_password", "username": "<username>", "password": "<password>"}
EOF
token=`curl -X POST "$API_URL/auth/token" -d "@/tmp/auth.txt" -H "Content-type: application/json" | jq -r '.access_token'`
/bin/rm -f /tmp/auth.txt
```

See sample payload data from this call in [`samples/login.txt`](samples/login.txt)

### Get entity configuration

Return entity configuration info, including terminology bindings.

```
curl -H "Authorization: Bearer $token" "$API_URL/api/v1/mapping/config" | jq
```

See sample payload data from this call in [`samples/get-entity-configuration.txt`](samples/get-entity-configuration.txt)

[Back to Top](#automap-in-5-minutes-curl-tutorial)

# Get application metadata

Return application metadata, including values that can be passed as various parameters in mapping tasks.

```
curl -H "Authorization: Bearer $token" "$API_URL/api/v1/mapping/metadata" | jq
```

See sample payload data from this call in [`samples/get-application-metadata.txt`](samples/get-application-metadata.txt)

[Back to Top](#automap-in-5-minutes-curl-tutorial)

# Get version information for components of the application

Return application version information and versions for various of the included components.

```
curl -H "Authorization: Bearer $token" "$API_URL/api/v1/mapping/version" | jq
```

See sample payload data from this call in [`samples/get-version-information.txt`](samples/get-version-information.txt)

[Back to Top](#automap-in-5-minutes-curl-tutorial)

# Map from a starting terminology and code

Perform mapping to verify that a terminology and code are valid for a known entity type.

```
curl -H "Authorization: Bearer $token" -H "Content-type: application/json" \
 "$API_URL/api/v1/mapping/task" -d '
{
  "terms": [
    {
      "entityType": "condition",
	  "term": "",
      "terminology": "http://snomed.info/sct",
      "code": "22298006",
      "inputType": "string"
    }
  ]
}' | jq
```

See sample payload data from this call in [`samples/get-version-information.txt`](samples/get-version-information.txt)

[Back to Top](#automap-in-5-minutes-curl-tutorial)


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