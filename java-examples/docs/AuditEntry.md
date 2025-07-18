

# AuditEntry

Represents an entry in the audit trail for a task or term

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**details** | **Map&lt;String, String&gt;** | Map of string key -&gt; string value detailing this entry |  [optional] |
|**error** | **Boolean** | Indicator of whether this entry represents an error |  [optional] |
|**message** | **String** | Message describing this entry |  |
|**taskId** | **UUID** | Task id |  |
|**termId** | **UUID** | Term id |  |
|**modifiedBy** | **String** | the identifier of the user who made the last modification |  |
|**created** | **Date** | the created date |  |
|**modified** | **Date** | the last modified date |  |
|**id** | **UUID** | the unique identifier |  |



