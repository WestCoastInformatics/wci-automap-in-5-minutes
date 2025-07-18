

# Subset

Represents a subset of concepts in a terminology grouped for a particular reason or use case

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**version** | **String** |  |  [optional] |
|**description** | **String** |  |  [optional] |
|**category** | **String** |  |  [optional] |
|**code** | **String** | the subset code |  |
|**scope** | **String** |  |  [optional] |
|**generator** | **String** |  |  [optional] |
|**memberIds** | **Set&lt;String&gt;** | the codes for members of the subset |  [optional] |
|**editorialPolicy** | [**EditorialPolicyEnum**](#EditorialPolicyEnum) |  |  [optional] |
|**universeSubset** | **String** |  |  [optional] |
|**upgradeGenerator** | **String** |  |  [optional] |
|**derivedFromSubset** | **String** |  |  [optional] |
|**disjointSubsets** | **Set&lt;String&gt;** |  |  [optional] |
|**workflowStatus** | [**WorkflowStatusEnum**](#WorkflowStatusEnum) |  |  [optional] |
|**publishable** | **Boolean** |  |  [optional] |
|**descendantsGenerator** | **String** |  |  [optional] |
|**referencedSubsetCodes** | **Set&lt;String&gt;** |  |  [optional] |
|**referencedTerminologyCodes** | **Set&lt;String&gt;** |  |  [optional] |
|**style** | [**StyleEnum**](#StyleEnum) |  |  [optional] |
|**entityType** | **String** |  |  [optional] |
|**query** | **String** |  |  [optional] |
|**local** | **Boolean** | indicates whether this data element was created by local editing |  |
|**modifiedBy** | **String** | the identifier of the user who made the last modification |  |
|**created** | **Date** | the created date |  |
|**modified** | **Date** | the last modified date |  |
|**id** | **UUID** | the unique identifier |  |
|**active** | **Boolean** | indicates whether or not this data element is active |  |
|**name** | **String** | the name |  |
|**terminology** | **String** | the terminology abbreviation |  |
|**attributes** | **Map&lt;String, String&gt;** | key/value pairs associated with this object. Entries in this map are terminology-specific |  [optional] |



## Enum: EditorialPolicyEnum

| Name | Value |
|---- | -----|
| SNOMEDCT | &quot;SNOMEDCT&quot; |
| DEFAULT | &quot;DEFAULT&quot; |
| NONE | &quot;NONE&quot; |



## Enum: WorkflowStatusEnum

| Name | Value |
|---- | -----|
| NEW | &quot;NEW&quot; |
| WORK | &quot;WORK&quot; |
| FUTURE | &quot;FUTURE&quot; |
| NEEDS_REVIEW | &quot;NEEDS_REVIEW&quot; |
| QA_ISSUE | &quot;QA_ISSUE&quot; |
| UPGRADE_REVIEW | &quot;UPGRADE_REVIEW&quot; |
| UPGRADE_INACTIVATE | &quot;UPGRADE_INACTIVATE&quot; |
| UPGRADE_REPLACED | &quot;UPGRADE_REPLACED&quot; |
| UPGRADE_NEW | &quot;UPGRADE_NEW&quot; |
| READY_FOR_PUBLICATION | &quot;READY_FOR_PUBLICATION&quot; |
| REMOVED | &quot;REMOVED&quot; |
| PUBLISHED | &quot;PUBLISHED&quot; |



## Enum: StyleEnum

| Name | Value |
|---- | -----|
| MANUAL | &quot;MANUAL&quot; |
| UUID | &quot;UUID&quot; |
| TERMLIST | &quot;TERMLIST&quot; |
| GENERATED | &quot;GENERATED&quot; |



