

# Terminology

Represents a terminology abbreviation and associated metadata

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**version** | **String** | the terminology version |  |
|**systemUri** | **String** | the FHIR system URI for the terminology |  [optional] |
|**abbreviation** | **String** | the terminology abbreviation |  |
|**systemOid** | **String** | the OID for the terminology |  [optional] |
|**expressionEnabled** | **Boolean** | indicates whether ECL-style expressions can be used when searching the terminology |  |
|**name** | **String** | the name |  |
|**local** | **Boolean** | indicates whether this data element was created by local editing |  |
|**modifiedBy** | **String** | the identifier of the user who made the last modification |  |
|**created** | **Date** | the created date |  |
|**modified** | **Date** | the last modified date |  |
|**id** | **UUID** | the unique identifier |  |
|**active** | **Boolean** | indicates whether or not this data element is active |  |
|**attributes** | **Map&lt;String, String&gt;** | key/value pairs associated with this object. Entries in this map are terminology-specific |  [optional] |



