

# FormItem

A form item representing a question or section in the vital signs form

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**questionCode** | **String** | The question code identifier |  [optional] |
|**localQuestionCode** | **String** | Local question code if applicable |  [optional] |
|**dataType** | [**DataTypeEnum**](#DataTypeEnum) | Data type of the question (e.g., &#39;SECTION&#39;, &#39;REAL&#39;, &#39;CNE&#39;, &#39;ST&#39;) |  [optional] |
|**header** | **Boolean** | Indicates if this item is a header/section |  [optional] |
|**units** | [**List&lt;Unit&gt;**](Unit.md) | List of measurement units applicable to this item |  [optional] |
|**codingInstructions** | **String** | Instructions for coding this item |  [optional] |
|**copyrightNotice** | **String** | Copyright notice for this item |  [optional] |
|**question** | **String** | The question text |  [optional] |
|**answers** | [**List&lt;Answer&gt;**](Answer.md) | List of possible answers for CNE type questions |  [optional] |
|**skipLogic** | **Object** | Skip logic for conditional questions |  [optional] |
|**restrictions** | **Object** | Restrictions on valid answers |  [optional] |
|**defaultAnswer** | **Object** | Default answer value |  [optional] |
|**formatting** | **Object** | Formatting specifications |  [optional] |
|**calculationMethod** | **Object** | Method for calculating derived values |  [optional] |
|**items** | [**List&lt;FormItem&gt;**](FormItem.md) | Nested form items for sections |  [optional] |
|**linkId** | **String** | Hierarchical link identifier |  [optional] |
|**questionCodeSystem** | **String** | Question code system (e.g., &#39;http://loinc.org&#39;) |  [optional] |



## Enum: DataTypeEnum

| Name | Value |
|---- | -----|
| SECTION | &quot;SECTION&quot; |
| REAL | &quot;REAL&quot; |
| CNE | &quot;CNE&quot; |
| ST | &quot;ST&quot; |



