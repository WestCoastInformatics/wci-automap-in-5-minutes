

# Mapping

Represents a mapping from a concept in one terminology to a concept in another

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**category** | **String** | the map category (for RF2-based maps) |  [optional] |
|**group** | **String** | the value for the group this map participates in (for complex maps that use groups) |  [optional] |
|**rule** | **String** | the machine-readable map rule for this mapping (for complex maps that use rules) |  [optional] |
|**advice** | **String** | the map advice |  [optional] |
|**entityType** | **String** | The cinical class type of information related to this map, e.g. &#39;condition&#39;, &#39;procedure&#39;, &#39;medication&#39;, etc. |  [optional] |
|**fromTerminology** | **String** | the terminology of the &#39;from&#39; code |  |
|**fromCode** | **String** | the &#39;from&#39; code (the left-hand side) |  |
|**toCode** | **String** | the &#39;to&#39; code (the left-hand side) |  |
|**toName** | **String** | the name of the &#39;to&#39; code |  |
|**toTerminology** | **String** | the terminology of the &#39;to&#39; code |  |
|**fromName** | **String** | the name of the &#39;from&#39; code |  |
|**mapsetCode** | **String** | the code of the mapset containing this mapping |  |
|**priority** | **String** | the value for the priority of this map within its group (for complex maps that use groups) |  [optional] |
|**local** | **Boolean** | indicates whether this data element was created by local editing |  |
|**modifiedBy** | **String** | the identifier of the user who made the last modification |  |
|**created** | **Date** | the created date |  |
|**modified** | **Date** | the last modified date |  |
|**id** | **UUID** | the unique identifier |  |
|**active** | **Boolean** | indicates whether or not this data element is active |  |
|**attributes** | **Map&lt;String, String&gt;** | key/value pairs associated with this object. Entries in this map are terminology-specific |  [optional] |



