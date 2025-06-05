

# OutputTask

Represents a response from task processing request, including mapped terms

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**status** | [**StatusEnum**](#StatusEnum) | Overall status of the mapping of terms in this task.  Allowable values are detailed by the application metadata endpoint |  |
|**terms** | [**List&lt;OutputTerm&gt;**](OutputTerm.md) | Collection of terms to be mapped |  |
|**asyncComplete** | **Boolean** | Flag indicating that async operations on &#39;final&#39; status are complete |  [optional] |
|**context** | **String** | Additional textual context for disambiguation, including other text around the text of the terms passed in |  [optional] |
|**topAnswer** | **Boolean** | Indicator of whether to return the top mapped answer regardless of whether the minimum confidence threshold has been met |  [optional] |
|**minConfidence** | **Double** | Minimum confidence threshold for mapped results |  [optional] |
|**audit** | **Boolean** | Indicator of whether to use auditing (automatically false if configuration does not persist outputs) |  [optional] |
|**modifiedBy** | **String** | the identifier of the user who made the last modification |  |
|**created** | **Date** | the created date |  |
|**modified** | **Date** | the last modified date |  |
|**id** | **UUID** | the unique identifier |  |
|**tags** | [**List&lt;Tag&gt;**](Tag.md) | List of key/value tags |  [optional] |



## Enum: StatusEnum

| Name | Value |
|---- | -----|
| FINAL | &quot;final&quot; |
| PROVISIONAL | &quot;provisional&quot; |
| OUT_OF_SCOPE | &quot;out_of_scope&quot; |
| CONFLICT | &quot;conflict&quot; |
| ERROR | &quot;error&quot; |



