# TerminologyApi

All URIs are relative to *https://automap.terminology.tools*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**autocompleteConcepts**](TerminologyApi.md#autocompleteConcepts) | **GET** /terminology/concept/{terminology}/autocomplete | Autocomplete |
| [**findConcepts**](TerminologyApi.md#findConcepts) | **GET** /terminology/concept | Find concepts (across all terminologies) |
| [**findConcepts1**](TerminologyApi.md#findConcepts1) | **GET** /terminology/concept/{terminology} | Find concepts |
| [**findMappings**](TerminologyApi.md#findMappings) | **GET** /terminology/mapset/{terminology}/{code}/mapping | Find mappings |
| [**findSubsetMemberships**](TerminologyApi.md#findSubsetMemberships) | **GET** /terminology/concept/{terminology}/{code}/subsets | Get concept subset memberships |
| [**findTreePositionChildren**](TerminologyApi.md#findTreePositionChildren) | **GET** /terminology/concept/{terminology}/{code}/trees/children | Find tree position children |
| [**findTreePositionDescendants**](TerminologyApi.md#findTreePositionDescendants) | **GET** /terminology/concept/{terminology}/{code}/trees/descendants | Find tree position descendants |
| [**findTreePositions**](TerminologyApi.md#findTreePositions) | **GET** /terminology/concept/{terminology}/{code}/trees | Find tree positions |
| [**getConcept**](TerminologyApi.md#getConcept) | **GET** /terminology/concept/{terminology}/{code} | Get concept |
| [**getConceptMappings**](TerminologyApi.md#getConceptMappings) | **GET** /terminology/concept/{terminology}/{code}/mapping | Get concept mappings |
| [**getConcepts**](TerminologyApi.md#getConcepts) | **GET** /terminology/concepts/{terminology} | Get concepts |
| [**getConfigProperties**](TerminologyApi.md#getConfigProperties) | **GET** /terminology/properties | Get properties |
| [**getMapset**](TerminologyApi.md#getMapset) | **GET** /terminology/mapset/{terminology}/{code} | Get mapset |
| [**getMapsets**](TerminologyApi.md#getMapsets) | **GET** /terminology/mapset/{terminology} | Get mapsets |
| [**getRelationships**](TerminologyApi.md#getRelationships) | **GET** /terminology/concept/{terminology}/{code}/relationships | Get concept relationships |
| [**getSubset**](TerminologyApi.md#getSubset) | **GET** /terminology/subset/{terminology}/{code} | Get subset |
| [**getSubsets**](TerminologyApi.md#getSubsets) | **GET** /terminology/subset/{terminology} | Get subsets |
| [**getSubtree**](TerminologyApi.md#getSubtree) | **GET** /terminology/concept/{terminology}/{code}/subtree | Get subtree |
| [**getTerminologies**](TerminologyApi.md#getTerminologies) | **GET** /terminology | Get terminologies |
| [**getTerminology**](TerminologyApi.md#getTerminology) | **GET** /terminology/{terminology} | Get terminology |
| [**getTerminologyMetadata**](TerminologyApi.md#getTerminologyMetadata) | **GET** /terminology/metadata/{terminology} | Get terminology metadata |
| [**resolveExpression**](TerminologyApi.md#resolveExpression) | **GET** /terminology/expr/{terminology} | Resolve expression |



## autocompleteConcepts

> ResultListConcept autocompleteConcepts(terminology, query, expression, clause, limit)

Autocomplete

Find concepts for a type-ahead search field

### Example

```java
// Import classes:
import api.invoker.ApiClient;
import api.invoker.ApiException;
import api.invoker.Configuration;
import api.invoker.auth.*;
import api.invoker.model.*;
import api.TerminologyApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://automap.terminology.tools");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        TerminologyApi apiInstance = new TerminologyApi(defaultClient);
        String terminology = "terminology_example"; // String | terminology, e.g. SNOMEDCT_US
        String query = "query_example"; // String | search query, e.g. heart attack
        String expression = "expression_example"; // String | ECL Expression, e.g. <404684003
        String clause = "clause_example"; // String | 
        Integer limit = 100; // Integer | limit of results to return
        try {
            ResultListConcept result = apiInstance.autocompleteConcepts(terminology, query, expression, clause, limit);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling TerminologyApi#autocompleteConcepts");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **terminology** | **String**| terminology, e.g. SNOMEDCT_US | |
| **query** | **String**| search query, e.g. heart attack | [optional] |
| **expression** | **String**| ECL Expression, e.g. &lt;404684003 | [optional] |
| **clause** | **String**|  | [optional] |
| **limit** | **Integer**| limit of results to return | [optional] |

### Return type

[**ResultListConcept**](ResultListConcept.md)

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **401** | Unauthorized |  -  |
| **403** | Forbidden |  -  |
| **500** | Internal server error |  -  |


## findConcepts

> ResultListConcept findConcepts(query, offset, limit, ascending, sort, handler, resolver, active, leaf)

Find concepts (across all terminologies)

Find concepts matching the specified search criteria

### Example

```java
// Import classes:
import api.invoker.ApiClient;
import api.invoker.ApiException;
import api.invoker.Configuration;
import api.invoker.auth.*;
import api.invoker.model.*;
import api.TerminologyApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://automap.terminology.tools");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        TerminologyApi apiInstance = new TerminologyApi(defaultClient);
        String query = "query_example"; // String | search query, e.g. heart attack
        Integer offset = 56; // Integer | start index for search results
        Integer limit = 100; // Integer | limit of results to return
        Boolean ascending = true; // Boolean | <code>true</code> for ascending, <code>false</code> for descending, <code>null</code> for unspecified
        String sort = "sort_example"; // String | comma-separated list of fields to sort on
        String handler = "handler_example"; // String | search handler, e.g. STANDARD, EXACT, NGRAM. If 'SNOMED' handler is used, a small delay may be added to prevent being blocked by 3rd party integration.
        String resolver = "resolver_example"; // String | graph resolver, e.g. DEFAULT
        Boolean active = true; // Boolean | active only, e.g. true
        Boolean leaf = true; // Boolean | active only, e.g. true
        try {
            ResultListConcept result = apiInstance.findConcepts(query, offset, limit, ascending, sort, handler, resolver, active, leaf);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling TerminologyApi#findConcepts");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **query** | **String**| search query, e.g. heart attack | [optional] |
| **offset** | **Integer**| start index for search results | [optional] |
| **limit** | **Integer**| limit of results to return | [optional] |
| **ascending** | **Boolean**| &lt;code&gt;true&lt;/code&gt; for ascending, &lt;code&gt;false&lt;/code&gt; for descending, &lt;code&gt;null&lt;/code&gt; for unspecified | [optional] |
| **sort** | **String**| comma-separated list of fields to sort on | [optional] |
| **handler** | **String**| search handler, e.g. STANDARD, EXACT, NGRAM. If &#39;SNOMED&#39; handler is used, a small delay may be added to prevent being blocked by 3rd party integration. | [optional] |
| **resolver** | **String**| graph resolver, e.g. DEFAULT | [optional] |
| **active** | **Boolean**| active only, e.g. true | [optional] |
| **leaf** | **Boolean**| active only, e.g. true | [optional] |

### Return type

[**ResultListConcept**](ResultListConcept.md)

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **401** | Unauthorized |  -  |
| **403** | Forbidden |  -  |
| **500** | Internal server error |  -  |


## findConcepts1

> ResultListConcept findConcepts1(terminology, query, expression, offset, limit, ascending, sort, handler, resolver, active, leaf)

Find concepts

Find concepts matching the specified search criteria

### Example

```java
// Import classes:
import api.invoker.ApiClient;
import api.invoker.ApiException;
import api.invoker.Configuration;
import api.invoker.auth.*;
import api.invoker.model.*;
import api.TerminologyApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://automap.terminology.tools");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        TerminologyApi apiInstance = new TerminologyApi(defaultClient);
        String terminology = "terminology_example"; // String | terminology, e.g. SNOMEDCT_US
        String query = "query_example"; // String | search query, e.g. heart attack
        String expression = "expression_example"; // String | ECL Expression, e.g. <404684003
        Integer offset = 56; // Integer | start index for search results
        Integer limit = 100; // Integer | limit of results to return
        Boolean ascending = true; // Boolean | <code>true</code> for ascending, <code>false</code> for descending, <code>null</code> for unspecified
        String sort = "sort_example"; // String | comma-separated list of fields to sort on
        String handler = "handler_example"; // String | search handler, e.g. STANDARD, EXACT, NGRAM. If 'SNOMED' handler is used, a small delay may be added to prevent being blocked by 3rd party integration.
        String resolver = "resolver_example"; // String | graph resolver, e.g. DEFAULT
        Boolean active = true; // Boolean | active only, e.g. true
        Boolean leaf = true; // Boolean | active only, e.g. true
        try {
            ResultListConcept result = apiInstance.findConcepts1(terminology, query, expression, offset, limit, ascending, sort, handler, resolver, active, leaf);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling TerminologyApi#findConcepts1");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **terminology** | **String**| terminology, e.g. SNOMEDCT_US | |
| **query** | **String**| search query, e.g. heart attack | [optional] |
| **expression** | **String**| ECL Expression, e.g. &lt;404684003 | [optional] |
| **offset** | **Integer**| start index for search results | [optional] |
| **limit** | **Integer**| limit of results to return | [optional] |
| **ascending** | **Boolean**| &lt;code&gt;true&lt;/code&gt; for ascending, &lt;code&gt;false&lt;/code&gt; for descending, &lt;code&gt;null&lt;/code&gt; for unspecified | [optional] |
| **sort** | **String**| comma-separated list of fields to sort on | [optional] |
| **handler** | **String**| search handler, e.g. STANDARD, EXACT, NGRAM. If &#39;SNOMED&#39; handler is used, a small delay may be added to prevent being blocked by 3rd party integration. | [optional] |
| **resolver** | **String**| graph resolver, e.g. DEFAULT | [optional] |
| **active** | **Boolean**| active only, e.g. true | [optional] |
| **leaf** | **Boolean**| active only, e.g. true | [optional] |

### Return type

[**ResultListConcept**](ResultListConcept.md)

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **401** | Unauthorized |  -  |
| **403** | Forbidden |  -  |
| **500** | Internal server error |  -  |


## findMappings

> ResultListMapping findMappings(terminology, code, query, offset, limit, ascending, sort)

Find mappings

Find mappings for the specified terminology and code

### Example

```java
// Import classes:
import api.invoker.ApiClient;
import api.invoker.ApiException;
import api.invoker.Configuration;
import api.invoker.auth.*;
import api.invoker.model.*;
import api.TerminologyApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://automap.terminology.tools");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        TerminologyApi apiInstance = new TerminologyApi(defaultClient);
        String terminology = "terminology_example"; // String | terminology, e.g. SNOMEDCT_US
        String code = "code_example"; // String | concept code, e.g. 6011000124106
        String query = "query_example"; // String | search query, e.g. heart attack
        Integer offset = 56; // Integer | start index for search results
        Integer limit = 100; // Integer | limit of results to return
        Boolean ascending = true; // Boolean | <code>true</code> for ascending, <code>false</code> for descending, <code>null</code> for unspecified
        String sort = "sort_example"; // String | comma-separated list of fields to sort on
        try {
            ResultListMapping result = apiInstance.findMappings(terminology, code, query, offset, limit, ascending, sort);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling TerminologyApi#findMappings");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **terminology** | **String**| terminology, e.g. SNOMEDCT_US | |
| **code** | **String**| concept code, e.g. 6011000124106 | |
| **query** | **String**| search query, e.g. heart attack | [optional] |
| **offset** | **Integer**| start index for search results | [optional] |
| **limit** | **Integer**| limit of results to return | [optional] |
| **ascending** | **Boolean**| &lt;code&gt;true&lt;/code&gt; for ascending, &lt;code&gt;false&lt;/code&gt; for descending, &lt;code&gt;null&lt;/code&gt; for unspecified | [optional] |
| **sort** | **String**| comma-separated list of fields to sort on | [optional] |

### Return type

[**ResultListMapping**](ResultListMapping.md)

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **401** | Unauthorized |  -  |
| **403** | Forbidden |  -  |
| **500** | Internal server error |  -  |


## findSubsetMemberships

> ResultListSubset findSubsetMemberships(terminology, code)

Get concept subset memberships

Get subsets that the specified terminology and code are a member of

### Example

```java
// Import classes:
import api.invoker.ApiClient;
import api.invoker.ApiException;
import api.invoker.Configuration;
import api.invoker.auth.*;
import api.invoker.model.*;
import api.TerminologyApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://automap.terminology.tools");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        TerminologyApi apiInstance = new TerminologyApi(defaultClient);
        String terminology = "terminology_example"; // String | terminology, e.g. SNOMEDCT_US
        String code = "code_example"; // String | concept code, e.g. 71388002
        try {
            ResultListSubset result = apiInstance.findSubsetMemberships(terminology, code);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling TerminologyApi#findSubsetMemberships");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **terminology** | **String**| terminology, e.g. SNOMEDCT_US | |
| **code** | **String**| concept code, e.g. 71388002 | |

### Return type

[**ResultListSubset**](ResultListSubset.md)

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **401** | Unauthorized |  -  |
| **403** | Forbidden |  -  |
| **500** | Internal server error |  -  |


## findTreePositionChildren

> ResultListConceptTreePosition findTreePositionChildren(terminology, code, offset, limit, ascending, sort, conceptFlag)

Find tree position children

Find the child tree position nodes for the specified terminology and code

### Example

```java
// Import classes:
import api.invoker.ApiClient;
import api.invoker.ApiException;
import api.invoker.Configuration;
import api.invoker.auth.*;
import api.invoker.model.*;
import api.TerminologyApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://automap.terminology.tools");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        TerminologyApi apiInstance = new TerminologyApi(defaultClient);
        String terminology = "terminology_example"; // String | terminology, e.g. SNOMEDCT_US
        String code = "code_example"; // String | concept code, e.g. 71388002
        Integer offset = 56; // Integer | 
        Integer limit = 100; // Integer | limit of results to return
        Boolean ascending = true; // Boolean | <code>true</code> for ascending, <code>false</code> for descending, <code>null</code> for unspecified
        String sort = "sort_example"; // String | comma-separated list of fields to sort on
        Boolean conceptFlag = true; // Boolean | read concept information, e.g. true
        try {
            ResultListConceptTreePosition result = apiInstance.findTreePositionChildren(terminology, code, offset, limit, ascending, sort, conceptFlag);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling TerminologyApi#findTreePositionChildren");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **terminology** | **String**| terminology, e.g. SNOMEDCT_US | |
| **code** | **String**| concept code, e.g. 71388002 | |
| **offset** | **Integer**|  | [optional] |
| **limit** | **Integer**| limit of results to return | [optional] |
| **ascending** | **Boolean**| &lt;code&gt;true&lt;/code&gt; for ascending, &lt;code&gt;false&lt;/code&gt; for descending, &lt;code&gt;null&lt;/code&gt; for unspecified | [optional] |
| **sort** | **String**| comma-separated list of fields to sort on | [optional] |
| **conceptFlag** | **Boolean**| read concept information, e.g. true | [optional] |

### Return type

[**ResultListConceptTreePosition**](ResultListConceptTreePosition.md)

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **401** | Unauthorized |  -  |
| **403** | Forbidden |  -  |
| **500** | Internal server error |  -  |


## findTreePositionDescendants

> ResultListConceptTreePosition findTreePositionDescendants(terminology, code, offset, limit, ascending, sort, conceptFlag)

Find tree position descendants

Find the descendant tree position nodes for the specified terminology and code

### Example

```java
// Import classes:
import api.invoker.ApiClient;
import api.invoker.ApiException;
import api.invoker.Configuration;
import api.invoker.auth.*;
import api.invoker.model.*;
import api.TerminologyApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://automap.terminology.tools");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        TerminologyApi apiInstance = new TerminologyApi(defaultClient);
        String terminology = "terminology_example"; // String | terminology, e.g. SNOMEDCT_US
        String code = "code_example"; // String | concept code, e.g. 71388002
        Integer offset = 56; // Integer | 
        Integer limit = 100; // Integer | limit of results to return
        Boolean ascending = true; // Boolean | <code>true</code> for ascending, <code>false</code> for descending, <code>null</code> for unspecified
        String sort = "sort_example"; // String | comma-separated list of fields to sort on
        Boolean conceptFlag = true; // Boolean | read concept information, e.g. true
        try {
            ResultListConceptTreePosition result = apiInstance.findTreePositionDescendants(terminology, code, offset, limit, ascending, sort, conceptFlag);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling TerminologyApi#findTreePositionDescendants");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **terminology** | **String**| terminology, e.g. SNOMEDCT_US | |
| **code** | **String**| concept code, e.g. 71388002 | |
| **offset** | **Integer**|  | [optional] |
| **limit** | **Integer**| limit of results to return | [optional] |
| **ascending** | **Boolean**| &lt;code&gt;true&lt;/code&gt; for ascending, &lt;code&gt;false&lt;/code&gt; for descending, &lt;code&gt;null&lt;/code&gt; for unspecified | [optional] |
| **sort** | **String**| comma-separated list of fields to sort on | [optional] |
| **conceptFlag** | **Boolean**| read concept information, e.g. true | [optional] |

### Return type

[**ResultListConceptTreePosition**](ResultListConceptTreePosition.md)

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **401** | Unauthorized |  -  |
| **403** | Forbidden |  -  |
| **500** | Internal server error |  -  |


## findTreePositions

> ResultListConceptTreePosition findTreePositions(terminology, code, offset, limit, ascending, sort, conceptFlag)

Find tree positions

Find tree positions for the specified terminology and code

### Example

```java
// Import classes:
import api.invoker.ApiClient;
import api.invoker.ApiException;
import api.invoker.Configuration;
import api.invoker.auth.*;
import api.invoker.model.*;
import api.TerminologyApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://automap.terminology.tools");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        TerminologyApi apiInstance = new TerminologyApi(defaultClient);
        String terminology = "terminology_example"; // String | terminology, e.g. SNOMEDCT_US
        String code = "code_example"; // String | concept code, e.g. 71388002
        Integer offset = 56; // Integer | start index for search results
        Integer limit = 100; // Integer | limit of results to return
        Boolean ascending = true; // Boolean | <code>true</code> for ascending, <code>false</code> for descending, <code>null</code> for unspecified
        String sort = "sort_example"; // String | comma-separated list of fields to sort on
        Boolean conceptFlag = true; // Boolean | read concept information, e.g. true
        try {
            ResultListConceptTreePosition result = apiInstance.findTreePositions(terminology, code, offset, limit, ascending, sort, conceptFlag);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling TerminologyApi#findTreePositions");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **terminology** | **String**| terminology, e.g. SNOMEDCT_US | |
| **code** | **String**| concept code, e.g. 71388002 | |
| **offset** | **Integer**| start index for search results | [optional] |
| **limit** | **Integer**| limit of results to return | [optional] |
| **ascending** | **Boolean**| &lt;code&gt;true&lt;/code&gt; for ascending, &lt;code&gt;false&lt;/code&gt; for descending, &lt;code&gt;null&lt;/code&gt; for unspecified | [optional] |
| **sort** | **String**| comma-separated list of fields to sort on | [optional] |
| **conceptFlag** | **Boolean**| read concept information, e.g. true | [optional] |

### Return type

[**ResultListConceptTreePosition**](ResultListConceptTreePosition.md)

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **401** | Unauthorized |  -  |
| **403** | Forbidden |  -  |
| **500** | Internal server error |  -  |


## getConcept

> Concept getConcept(terminology, code, resolver)

Get concept

Get concept object for the specified terminology, code, and resolver

### Example

```java
// Import classes:
import api.invoker.ApiClient;
import api.invoker.ApiException;
import api.invoker.Configuration;
import api.invoker.auth.*;
import api.invoker.model.*;
import api.TerminologyApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://automap.terminology.tools");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        TerminologyApi apiInstance = new TerminologyApi(defaultClient);
        String terminology = "terminology_example"; // String | terminology, e.g. SNOMEDCT_US
        String code = "code_example"; // String | concept code, e.g. 71388002
        String resolver = "resolver_example"; // String | graph resover, e.g. DEFAULT
        try {
            Concept result = apiInstance.getConcept(terminology, code, resolver);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling TerminologyApi#getConcept");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **terminology** | **String**| terminology, e.g. SNOMEDCT_US | |
| **code** | **String**| concept code, e.g. 71388002 | |
| **resolver** | **String**| graph resover, e.g. DEFAULT | [optional] |

### Return type

[**Concept**](Concept.md)

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **401** | Unauthorized |  -  |
| **403** | Forbidden |  -  |
| **500** | Internal server error |  -  |


## getConceptMappings

> ResultListMapping getConceptMappings(terminology, code)

Get concept mappings

Get mappings that the specified terminology and code are mapped from

### Example

```java
// Import classes:
import api.invoker.ApiClient;
import api.invoker.ApiException;
import api.invoker.Configuration;
import api.invoker.auth.*;
import api.invoker.model.*;
import api.TerminologyApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://automap.terminology.tools");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        TerminologyApi apiInstance = new TerminologyApi(defaultClient);
        String terminology = "terminology_example"; // String | terminology, e.g. SNOMEDCT_US
        String code = "code_example"; // String | concept code, e.g. 283231003
        try {
            ResultListMapping result = apiInstance.getConceptMappings(terminology, code);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling TerminologyApi#getConceptMappings");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **terminology** | **String**| terminology, e.g. SNOMEDCT_US | |
| **code** | **String**| concept code, e.g. 283231003 | |

### Return type

[**ResultListMapping**](ResultListMapping.md)

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **401** | Unauthorized |  -  |
| **403** | Forbidden |  -  |
| **500** | Internal server error |  -  |


## getConcepts

> List&lt;Concept&gt; getConcepts(terminology, codes, resolver)

Get concepts

Get concepts for the specified terminology, code list, and resolver

### Example

```java
// Import classes:
import api.invoker.ApiClient;
import api.invoker.ApiException;
import api.invoker.Configuration;
import api.invoker.auth.*;
import api.invoker.model.*;
import api.TerminologyApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://automap.terminology.tools");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        TerminologyApi apiInstance = new TerminologyApi(defaultClient);
        String terminology = "terminology_example"; // String | terminology, e.g. SNOMEDCT_US
        String codes = "codes_example"; // String | concept codes, e.g. 71388002,404684003
        String resolver = "resolver_example"; // String | graph resolver, e.g. DEFAULT
        try {
            List<Concept> result = apiInstance.getConcepts(terminology, codes, resolver);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling TerminologyApi#getConcepts");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **terminology** | **String**| terminology, e.g. SNOMEDCT_US | |
| **codes** | **String**| concept codes, e.g. 71388002,404684003 | |
| **resolver** | **String**| graph resolver, e.g. DEFAULT | [optional] |

### Return type

[**List&lt;Concept&gt;**](Concept.md)

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **401** | Unauthorized |  -  |
| **403** | Forbidden |  -  |
| **500** | Internal server error |  -  |


## getConfigProperties

> Map&lt;String, String&gt; getConfigProperties()

Get properties

Get configuration information used to drive certain UI functionality

### Example

```java
// Import classes:
import api.invoker.ApiClient;
import api.invoker.ApiException;
import api.invoker.Configuration;
import api.invoker.auth.*;
import api.invoker.model.*;
import api.TerminologyApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://automap.terminology.tools");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        TerminologyApi apiInstance = new TerminologyApi(defaultClient);
        try {
            Map<String, String> result = apiInstance.getConfigProperties();
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling TerminologyApi#getConfigProperties");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters

This endpoint does not need any parameter.

### Return type

**Map&lt;String, String&gt;**

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **500** | Internal server error |  -  |


## getMapset

> Mapset getMapset(terminology, code)

Get mapset

Get mapsets for the specified terminology and code

### Example

```java
// Import classes:
import api.invoker.ApiClient;
import api.invoker.ApiException;
import api.invoker.Configuration;
import api.invoker.auth.*;
import api.invoker.model.*;
import api.TerminologyApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://automap.terminology.tools");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        TerminologyApi apiInstance = new TerminologyApi(defaultClient);
        String terminology = "terminology_example"; // String | terminology, e.g. SNOMEDCT_US
        String code = "code_example"; // String | concept code, e.g. 6011000124106
        try {
            Mapset result = apiInstance.getMapset(terminology, code);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling TerminologyApi#getMapset");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **terminology** | **String**| terminology, e.g. SNOMEDCT_US | |
| **code** | **String**| concept code, e.g. 6011000124106 | |

### Return type

[**Mapset**](Mapset.md)

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **401** | Unauthorized |  -  |
| **403** | Forbidden |  -  |
| **500** | Internal server error |  -  |


## getMapsets

> ResultListMapset getMapsets(terminology)

Get mapsets

Get all mapsets for the specified terminology

### Example

```java
// Import classes:
import api.invoker.ApiClient;
import api.invoker.ApiException;
import api.invoker.Configuration;
import api.invoker.auth.*;
import api.invoker.model.*;
import api.TerminologyApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://automap.terminology.tools");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        TerminologyApi apiInstance = new TerminologyApi(defaultClient);
        String terminology = "terminology_example"; // String | terminology, e.g. SNOMEDCT_US
        try {
            ResultListMapset result = apiInstance.getMapsets(terminology);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling TerminologyApi#getMapsets");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **terminology** | **String**| terminology, e.g. SNOMEDCT_US | |

### Return type

[**ResultListMapset**](ResultListMapset.md)

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **401** | Unauthorized |  -  |
| **403** | Forbidden |  -  |
| **500** | Internal server error |  -  |


## getRelationships

> ResultListConceptRelationship getRelationships(terminology, code, offset, limit, ascending, sort, inverse, active, filter)

Get concept relationships

Get relationships for for specified terminology and code

### Example

```java
// Import classes:
import api.invoker.ApiClient;
import api.invoker.ApiException;
import api.invoker.Configuration;
import api.invoker.auth.*;
import api.invoker.model.*;
import api.TerminologyApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://automap.terminology.tools");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        TerminologyApi apiInstance = new TerminologyApi(defaultClient);
        String terminology = "terminology_example"; // String | terminology, e.g. SNOMEDCT_US
        String code = "code_example"; // String | concept code, e.g. 71388002
        Integer offset = 56; // Integer | start index for search results
        Integer limit = 100; // Integer | limit of results to return
        Boolean ascending = true; // Boolean | <code>true</code> for ascending, <code>false</code> for descending, <code>null</code> for unspecified
        String sort = "sort_example"; // String | comma-separated list of fields to sort on
        Boolean inverse = true; // Boolean | search inverse side of relationships, e.g. false
        Boolean active = true; // Boolean | active only, e.g. true
        String filter = "filter_example"; // String | 
        try {
            ResultListConceptRelationship result = apiInstance.getRelationships(terminology, code, offset, limit, ascending, sort, inverse, active, filter);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling TerminologyApi#getRelationships");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **terminology** | **String**| terminology, e.g. SNOMEDCT_US | |
| **code** | **String**| concept code, e.g. 71388002 | |
| **offset** | **Integer**| start index for search results | [optional] |
| **limit** | **Integer**| limit of results to return | [optional] |
| **ascending** | **Boolean**| &lt;code&gt;true&lt;/code&gt; for ascending, &lt;code&gt;false&lt;/code&gt; for descending, &lt;code&gt;null&lt;/code&gt; for unspecified | [optional] |
| **sort** | **String**| comma-separated list of fields to sort on | [optional] |
| **inverse** | **Boolean**| search inverse side of relationships, e.g. false | [optional] |
| **active** | **Boolean**| active only, e.g. true | [optional] |
| **filter** | **String**|  | [optional] |

### Return type

[**ResultListConceptRelationship**](ResultListConceptRelationship.md)

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **401** | Unauthorized |  -  |
| **403** | Forbidden |  -  |
| **500** | Internal server error |  -  |


## getSubset

> Subset getSubset(terminology, code)

Get subset

Get subsets for the specified terminology and code

### Example

```java
// Import classes:
import api.invoker.ApiClient;
import api.invoker.ApiException;
import api.invoker.Configuration;
import api.invoker.auth.*;
import api.invoker.model.*;
import api.TerminologyApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://automap.terminology.tools");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        TerminologyApi apiInstance = new TerminologyApi(defaultClient);
        String terminology = "terminology_example"; // String | terminology, e.g. SNOMEDCT_US
        String code = "code_example"; // String | concept code, e.g. 71388002
        try {
            Subset result = apiInstance.getSubset(terminology, code);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling TerminologyApi#getSubset");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **terminology** | **String**| terminology, e.g. SNOMEDCT_US | |
| **code** | **String**| concept code, e.g. 71388002 | |

### Return type

[**Subset**](Subset.md)

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **401** | Unauthorized |  -  |
| **403** | Forbidden |  -  |
| **500** | Internal server error |  -  |


## getSubsets

> ResultListSubset getSubsets(terminology)

Get subsets

Get all subsets for the specified terminology

### Example

```java
// Import classes:
import api.invoker.ApiClient;
import api.invoker.ApiException;
import api.invoker.Configuration;
import api.invoker.auth.*;
import api.invoker.model.*;
import api.TerminologyApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://automap.terminology.tools");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        TerminologyApi apiInstance = new TerminologyApi(defaultClient);
        String terminology = "terminology_example"; // String | terminology, e.g. SNOMEDCT_US
        try {
            ResultListSubset result = apiInstance.getSubsets(terminology);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling TerminologyApi#getSubsets");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **terminology** | **String**| terminology, e.g. SNOMEDCT_US | |

### Return type

[**ResultListSubset**](ResultListSubset.md)

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **401** | Unauthorized |  -  |
| **403** | Forbidden |  -  |
| **500** | Internal server error |  -  |


## getSubtree

> ConceptTreePosition getSubtree(terminology, code, maxLevel, conceptFlag)

Get subtree

Get the subtree for the specified terminology and code. Use the special value <i>local</i> for terminologies with anamespace-id attribute to compute the subtree of all local content.

### Example

```java
// Import classes:
import api.invoker.ApiClient;
import api.invoker.ApiException;
import api.invoker.Configuration;
import api.invoker.auth.*;
import api.invoker.model.*;
import api.TerminologyApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://automap.terminology.tools");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        TerminologyApi apiInstance = new TerminologyApi(defaultClient);
        String terminology = "terminology_example"; // String | terminology, e.g. SNOMEDCT_US
        String code = "code_example"; // String | concept code, e.g. 71388002 or 'local'
        Integer maxLevel = 56; // Integer | max level of depth to read, e.g. 3
        Boolean conceptFlag = true; // Boolean | read concept information, e.g. true
        try {
            ConceptTreePosition result = apiInstance.getSubtree(terminology, code, maxLevel, conceptFlag);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling TerminologyApi#getSubtree");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **terminology** | **String**| terminology, e.g. SNOMEDCT_US | |
| **code** | **String**| concept code, e.g. 71388002 or &#39;local&#39; | |
| **maxLevel** | **Integer**| max level of depth to read, e.g. 3 | [optional] |
| **conceptFlag** | **Boolean**| read concept information, e.g. true | [optional] |

### Return type

[**ConceptTreePosition**](ConceptTreePosition.md)

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **401** | Unauthorized |  -  |
| **403** | Forbidden |  -  |
| **500** | Internal server error |  -  |


## getTerminologies

> List&lt;Terminology&gt; getTerminologies()

Get terminologies

Get all terminologies

### Example

```java
// Import classes:
import api.invoker.ApiClient;
import api.invoker.ApiException;
import api.invoker.Configuration;
import api.invoker.auth.*;
import api.invoker.model.*;
import api.TerminologyApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://automap.terminology.tools");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        TerminologyApi apiInstance = new TerminologyApi(defaultClient);
        try {
            List<Terminology> result = apiInstance.getTerminologies();
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling TerminologyApi#getTerminologies");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters

This endpoint does not need any parameter.

### Return type

[**List&lt;Terminology&gt;**](Terminology.md)

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **401** | Unauthorized |  -  |
| **403** | Forbidden |  -  |
| **500** | Internal server error |  -  |


## getTerminology

> Terminology getTerminology(terminology)

Get terminology

Get terminology object for the specified terminology

### Example

```java
// Import classes:
import api.invoker.ApiClient;
import api.invoker.ApiException;
import api.invoker.Configuration;
import api.invoker.auth.*;
import api.invoker.model.*;
import api.TerminologyApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://automap.terminology.tools");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        TerminologyApi apiInstance = new TerminologyApi(defaultClient);
        String terminology = "terminology_example"; // String | terminology, e.g. SNOMEDCT_US
        try {
            Terminology result = apiInstance.getTerminology(terminology);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling TerminologyApi#getTerminology");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **terminology** | **String**| terminology, e.g. SNOMEDCT_US | |

### Return type

[**Terminology**](Terminology.md)

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **401** | Unauthorized |  -  |
| **403** | Forbidden |  -  |
| **500** | Internal server error |  -  |


## getTerminologyMetadata

> getTerminologyMetadata(terminology)

Get terminology metadata

Get map of terminology abbreviations to metadata for specified terminology

### Example

```java
// Import classes:
import api.invoker.ApiClient;
import api.invoker.ApiException;
import api.invoker.Configuration;
import api.invoker.auth.*;
import api.invoker.model.*;
import api.TerminologyApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://automap.terminology.tools");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        TerminologyApi apiInstance = new TerminologyApi(defaultClient);
        String terminology = "terminology_example"; // String | terminology, e.g. SNOMEDCT_US
        try {
            apiInstance.getTerminologyMetadata(terminology);
        } catch (ApiException e) {
            System.err.println("Exception when calling TerminologyApi#getTerminologyMetadata");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **terminology** | **String**| terminology, e.g. SNOMEDCT_US | |

### Return type

null (empty response body)

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **401** | Unauthorized |  -  |
| **403** | Forbidden |  -  |
| **500** | Internal server error |  -  |


## resolveExpression

> List&lt;String&gt; resolveExpression(terminology, expression)

Resolve expression

Get concept ids corresponding to thespecified terminology and expression. For more information on working with expressions, see <a href="https://github.com/WestCoastInformatics/wci-terminology-service-in-5-minutes/blob/master/doc/EXPRESSION.md">https://github.com/WestCoastInformatics/wci-terminology-service-in-5-minutes/blob/master/doc/EXPRESSION.md</a>.

### Example

```java
// Import classes:
import api.invoker.ApiClient;
import api.invoker.ApiException;
import api.invoker.Configuration;
import api.invoker.auth.*;
import api.invoker.model.*;
import api.TerminologyApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://automap.terminology.tools");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        TerminologyApi apiInstance = new TerminologyApi(defaultClient);
        String terminology = "terminology_example"; // String | terminology, e.g. SNOMEDCT_US
        String expression = "expression_example"; // String | ECL Expression, e.g. <404684003
        try {
            List<String> result = apiInstance.resolveExpression(terminology, expression);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling TerminologyApi#resolveExpression");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **terminology** | **String**| terminology, e.g. SNOMEDCT_US | |
| **expression** | **String**| ECL Expression, e.g. &lt;404684003 | |

### Return type

**List&lt;String&gt;**

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **401** | Unauthorized |  -  |
| **403** | Forbidden |  -  |
| **500** | Internal server error |  -  |

