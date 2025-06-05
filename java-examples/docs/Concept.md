

# Concept

Represents a concept with a code in a terminology

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**code** | **String** | the code in the specified terminology |  |
|**sufficientlyDefined** | **Boolean** | indicates whether the concept is specified with logical necessary and sufficient conditions.  Generally not important except for description-logic based terminologies where this is important. |  |
|**atoms** | [**List&lt;Atom&gt;**](Atom.md) | the names associated with this concept |  |
|**definitions** | [**List&lt;Definition&gt;**](Definition.md) | the definitions associated with this concept |  [optional] |
|**axioms** | [**List&lt;Axiom&gt;**](Axiom.md) | the axioms associated with this concept |  [optional] |
|**semanticTypes** | **Set&lt;String&gt;** | high-level semantic categories associated with this concept - values depend on the terminologies loaded |  [optional] |
|**local** | **Boolean** | indicates whether this data element was created by local editing |  |
|**modifiedBy** | **String** | the identifier of the user who made the last modification |  |
|**created** | **Date** | the created date |  |
|**modified** | **Date** | the last modified date |  |
|**id** | **UUID** | the unique identifier |  |
|**active** | **Boolean** | indicates whether or not this data element is active |  |
|**terminology** | **String** | the terminology abbreviation |  |
|**name** | **String** | the name |  |
|**attributes** | **Map&lt;String, String&gt;** | key/value pairs associated with this object. Entries in this map are terminology-specific |  [optional] |



