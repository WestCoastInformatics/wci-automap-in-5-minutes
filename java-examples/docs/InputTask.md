

# InputTask

Represents a task to submit for processing, with included terms

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**terms** | [**List&lt;InputTerm&gt;**](InputTerm.md) | Collection of terms to be mapped |  |
|**context** | **String** | Additional textual context for disambiguation, including other text around the text of the terms passed in |  [optional] |
|**topAnswer** | **Boolean** | Indicator of whether to return the top mapped answer regardless of whether the minimum confidence threshold has been met |  [optional] |
|**minConfidence** | **Double** | Minimum confidence threshold for mapped results |  [optional] |
|**audit** | **Boolean** | Indicator of whether to use auditing (automatically false if configuration does not persist outputs) |  [optional] |
|**tags** | [**List&lt;Tag&gt;**](Tag.md) | List of key/value tags |  [optional] |



