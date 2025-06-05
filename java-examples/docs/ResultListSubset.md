

# ResultListSubset

Represents a list of subsets returned from a find call

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**total** | **Integer** | the total number of potential results |  |
|**limit** | **Integer** | the max number results requested |  |
|**offset** | **Integer** | the starting index requested |  |
|**confidence** | **Double** | the score of the search result, when used |  [optional] |
|**filtered** | **Integer** | the max number results requested |  |
|**items** | [**List&lt;Subset&gt;**](Subset.md) | the items themselves (the format will vary depending on the type of list) |  |



