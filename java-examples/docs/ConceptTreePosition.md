

# ConceptTreePosition

Represents a concept position in a hierarchical tree with a path to the root

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**children** | [**List&lt;ConceptTreePosition&gt;**](ConceptTreePosition.md) | the child tree positions of this node |  [optional] |
|**ancestorPath** | **String** | the path from the root code expressed as a sequence of dot (.) separated code values starting with the root and ending with the parent code |  [optional] |
|**childCt** | **Integer** | the child count of this node |  [optional] |
|**concept** | [**Concept**](Concept.md) |  |  [optional] |
|**level** | **Integer** | the level of depth in the hierarchy of this node |  [optional] |
|**code** | **String** | the code in the specified terminology |  |
|**additionalType** | **String** | the more specific type of relationship (more information about this label is provided in the terminology metadata) |  [optional] |
|**local** | **Boolean** | indicates whether this data element was created by local editing |  |
|**modifiedBy** | **String** | the identifier of the user who made the last modification |  |
|**created** | **Date** | the created date |  |
|**modified** | **Date** | the last modified date |  |
|**id** | **UUID** | the unique identifier |  |
|**active** | **Boolean** | indicates whether or not this data element is active |  |
|**name** | **String** | the name |  |
|**terminology** | **String** | the terminology abbreviation |  |



