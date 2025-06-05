

# ConceptRelationship

Represents a relationship between two concepts

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**hierarchical** | **Boolean** | indicates whether this relationship is part of the hierarchy |  |
|**type** | **String** | the high level type of relationship (more information about this label is provided in the terminology metadata) |  |
|**toActive** | **Boolean** | the active status of the concept this relationship is to (the right-hand side). If this is not used, the relationship will have a &#39;toValue&#39; |  [optional] |
|**toValue** | **String** | the literal value relationship is to (the right-hand side). If this is null, the relationship will have a &#39;to&#39; |  [optional] |
|**group** | **String** | used by terminologies that group relationships (e.g. SNOMEDCT) to indicate the group value |  [optional] |
|**toCode** | **String** | the code of the concept this relationship is to (the right-hand side). If this is not used, the relationship will have a &#39;toValue&#39; |  [optional] |
|**toName** | **String** | the name of the concept this relationship is to (the right-hand side). If this is not used, the relationship will have a &#39;toValue&#39; |  [optional] |
|**toTerminology** | **String** | the terminology of the concept this relationship is to (the right-hand side). If this is not used, the relationship will have a &#39;toValue&#39; |  [optional] |
|**assertedDirection** | **Boolean** | indicates whether this relationship is in the direction asserted by the terminology. This is meaninful because in some instances relationships are loaded in both directions |  |
|**additionalType** | **String** | the more specific type of relationship (more information about this label is provided in the terminology metadata) |  [optional] |
|**defining** | **Boolean** | indicates whether this is a relationship is part of the concept logical definition |  |
|**local** | **Boolean** | indicates whether this data element was created by local editing |  |
|**modifiedBy** | **String** | the identifier of the user who made the last modification |  |
|**created** | **Date** | the created date |  |
|**modified** | **Date** | the last modified date |  |
|**id** | **UUID** | the unique identifier |  |
|**active** | **Boolean** | indicates whether or not this data element is active |  |
|**terminologyId** | **String** | the identifier asserted by the terminology |  [optional] |
|**terminology** | **String** | the terminology abbreviation |  |



