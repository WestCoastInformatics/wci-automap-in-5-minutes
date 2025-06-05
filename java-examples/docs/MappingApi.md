# MappingApi

All URIs are relative to *https://automap.terminology.tools*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**addTask**](MappingApi.md#addTask) | **POST** /api/v1/mapping/task | Add an task to request mapping of included terms |
| [**findTasks**](MappingApi.md#findTasks) | **GET** /api/v1/mapping/task | Find tasks matching specified parameters |
| [**findTerms**](MappingApi.md#findTerms) | **GET** /api/v1/mapping/term | Find tasks matching specified parameters |
| [**getEntityConfig**](MappingApi.md#getEntityConfig) | **GET** /api/v1/mapping/config | Get entity configuration |
| [**getMetadata**](MappingApi.md#getMetadata) | **GET** /api/v1/mapping/metadata | Get application metadata |
| [**getTask**](MappingApi.md#getTask) | **GET** /api/v1/mapping/task/{taskId} | Get task object for the specified task id |
| [**getTaskTerm**](MappingApi.md#getTaskTerm) | **GET** /api/v1/mapping/task/{taskId}/term/{termId} | Get term for the specified taskId and termId |
| [**getTaskTermAuditTrail**](MappingApi.md#getTaskTermAuditTrail) | **GET** /api/v1/mapping/task/{taskId}/term/{termId}/audit | Get audit trail for the specified taskId and termId |
| [**getVersions**](MappingApi.md#getVersions) | **GET** /api/v1/mapping/version | Get version information for components of the application |



## addTask

> OutputTask addTask(inputTask)

Add an task to request mapping of included terms

<a href="/examples/index.html">Click here</a> for samples of request and response body.

### Example

```java
// Import classes:
import api.invoker.ApiClient;
import api.invoker.ApiException;
import api.invoker.Configuration;
import api.invoker.auth.*;
import api.invoker.model.*;
import api.MappingApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://automap.terminology.tools");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        MappingApi apiInstance = new MappingApi(defaultClient);
        InputTask inputTask = new InputTask(); // InputTask | Batch of terms to map
        try {
            OutputTask result = apiInstance.addTask(inputTask);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling MappingApi#addTask");
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
| **inputTask** | [**InputTask**](InputTask.md)| Batch of terms to map | |

### Return type

[**OutputTask**](OutputTask.md)

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | Return the task with mappings for requested terms |  -  |
| **400** | Bad request |  -  |
| **401** | Unauthorized |  -  |
| **403** | Forbidden |  -  |
| **500** | Internal server error |  -  |


## findTasks

> OutputTaskList findTasks(query, offset, limit, sort, ascending)

Find tasks matching specified parameters

### Example

```java
// Import classes:
import api.invoker.ApiClient;
import api.invoker.ApiException;
import api.invoker.Configuration;
import api.invoker.auth.*;
import api.invoker.model.*;
import api.MappingApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://automap.terminology.tools");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        MappingApi apiInstance = new MappingApi(defaultClient);
        String query = "query_example"; // String | search query, e.g. heart attack
        Integer offset = 56; // Integer | start index for search results
        Integer limit = 100; // Integer | limit of results to return
        String sort = "sort_example"; // String | comma-separated list of fields to sort on
        Boolean ascending = true; // Boolean | <code>true</code> for ascending, <code>false</code> for descending, <code>null</code> for unspecified
        try {
            OutputTaskList result = apiInstance.findTasks(query, offset, limit, sort, ascending);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling MappingApi#findTasks");
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
| **sort** | **String**| comma-separated list of fields to sort on | [optional] |
| **ascending** | **Boolean**| &lt;code&gt;true&lt;/code&gt; for ascending, &lt;code&gt;false&lt;/code&gt; for descending, &lt;code&gt;null&lt;/code&gt; for unspecified | [optional] |

### Return type

[**OutputTaskList**](OutputTaskList.md)

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Return list of matching tasks |  -  |
| **400** | Bad request |  -  |
| **401** | Unauthorized |  -  |
| **403** | Forbidden |  -  |
| **500** | Internal server error |  -  |


## findTerms

> OutputTaskList findTerms(query, offset, limit, sort, ascending)

Find tasks matching specified parameters

### Example

```java
// Import classes:
import api.invoker.ApiClient;
import api.invoker.ApiException;
import api.invoker.Configuration;
import api.invoker.auth.*;
import api.invoker.model.*;
import api.MappingApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://automap.terminology.tools");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        MappingApi apiInstance = new MappingApi(defaultClient);
        String query = "query_example"; // String | search query, e.g. heart attack
        Integer offset = 56; // Integer | start index for search results
        Integer limit = 100; // Integer | limit of results to return
        String sort = "sort_example"; // String | comma-separated list of fields to sort on
        Boolean ascending = true; // Boolean | <code>true</code> for ascending, <code>false</code> for descending, <code>null</code> for unspecified
        try {
            OutputTaskList result = apiInstance.findTerms(query, offset, limit, sort, ascending);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling MappingApi#findTerms");
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
| **sort** | **String**| comma-separated list of fields to sort on | [optional] |
| **ascending** | **Boolean**| &lt;code&gt;true&lt;/code&gt; for ascending, &lt;code&gt;false&lt;/code&gt; for descending, &lt;code&gt;null&lt;/code&gt; for unspecified | [optional] |

### Return type

[**OutputTaskList**](OutputTaskList.md)

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Return list of matching tasks |  -  |
| **400** | Bad request |  -  |
| **401** | Unauthorized |  -  |
| **403** | Forbidden |  -  |
| **500** | Internal server error |  -  |


## getEntityConfig

> ApplicationMetadataMap getEntityConfig()

Get entity configuration

### Example

```java
// Import classes:
import api.invoker.ApiClient;
import api.invoker.ApiException;
import api.invoker.Configuration;
import api.invoker.auth.*;
import api.invoker.model.*;
import api.MappingApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://automap.terminology.tools");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        MappingApi apiInstance = new MappingApi(defaultClient);
        try {
            ApplicationMetadataMap result = apiInstance.getEntityConfig();
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling MappingApi#getEntityConfig");
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

[**ApplicationMetadataMap**](ApplicationMetadataMap.md)

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Return application metadata |  -  |
| **400** | Bad request |  -  |
| **401** | Unauthorized |  -  |
| **403** | Forbidden |  -  |
| **500** | Internal server error |  -  |


## getMetadata

> ApplicationMetadataMap getMetadata()

Get application metadata

### Example

```java
// Import classes:
import api.invoker.ApiClient;
import api.invoker.ApiException;
import api.invoker.Configuration;
import api.invoker.auth.*;
import api.invoker.model.*;
import api.MappingApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://automap.terminology.tools");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        MappingApi apiInstance = new MappingApi(defaultClient);
        try {
            ApplicationMetadataMap result = apiInstance.getMetadata();
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling MappingApi#getMetadata");
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

[**ApplicationMetadataMap**](ApplicationMetadataMap.md)

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Return application metadata |  -  |
| **400** | Bad request |  -  |
| **401** | Unauthorized |  -  |
| **403** | Forbidden |  -  |
| **500** | Internal server error |  -  |


## getTask

> OutputTask getTask(taskId)

Get task object for the specified task id

### Example

```java
// Import classes:
import api.invoker.ApiClient;
import api.invoker.ApiException;
import api.invoker.Configuration;
import api.invoker.auth.*;
import api.invoker.model.*;
import api.MappingApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://automap.terminology.tools");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        MappingApi apiInstance = new MappingApi(defaultClient);
        String taskId = "taskId_example"; // String | 
        try {
            OutputTask result = apiInstance.getTask(taskId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling MappingApi#getTask");
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
| **taskId** | **String**|  | |

### Return type

[**OutputTask**](OutputTask.md)

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Return task |  -  |
| **400** | Bad request |  -  |
| **401** | Unauthorized |  -  |
| **403** | Forbidden |  -  |
| **404** | Not found |  -  |
| **500** | Internal server error |  -  |


## getTaskTerm

> OutputTask getTaskTerm(taskId, termId)

Get term for the specified taskId and termId

### Example

```java
// Import classes:
import api.invoker.ApiClient;
import api.invoker.ApiException;
import api.invoker.Configuration;
import api.invoker.auth.*;
import api.invoker.model.*;
import api.MappingApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://automap.terminology.tools");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        MappingApi apiInstance = new MappingApi(defaultClient);
        String taskId = "taskId_example"; // String | task.id returned by /task/add, e.g. 642c0e8a-8bdc-4ae6-8773-9f6cd8bc2fd3
        String termId = "termId_example"; // String | term.id, e.g. 8271f5b9-ee2a-4614-87a1-2c071c9d6076
        try {
            OutputTask result = apiInstance.getTaskTerm(taskId, termId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling MappingApi#getTaskTerm");
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
| **taskId** | **String**| task.id returned by /task/add, e.g. 642c0e8a-8bdc-4ae6-8773-9f6cd8bc2fd3 | |
| **termId** | **String**| term.id, e.g. 8271f5b9-ee2a-4614-87a1-2c071c9d6076 | |

### Return type

[**OutputTask**](OutputTask.md)

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Return term |  -  |
| **400** | Bad request |  -  |
| **401** | Unauthorized |  -  |
| **403** | Forbidden |  -  |
| **404** | Not found |  -  |
| **500** | Internal server error |  -  |


## getTaskTermAuditTrail

> List&lt;AuditEntry&gt; getTaskTermAuditTrail(taskId, termId)

Get audit trail for the specified taskId and termId

### Example

```java
// Import classes:
import api.invoker.ApiClient;
import api.invoker.ApiException;
import api.invoker.Configuration;
import api.invoker.auth.*;
import api.invoker.model.*;
import api.MappingApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://automap.terminology.tools");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        MappingApi apiInstance = new MappingApi(defaultClient);
        String taskId = "taskId_example"; // String | task.id returned by /task/add, e.g. 642c0e8a-8bdc-4ae6-8773-9f6cd8bc2fd3
        String termId = "termId_example"; // String | term.id, e.g. 8271f5b9-ee2a-4614-87a1-2c071c9d6076
        try {
            List<AuditEntry> result = apiInstance.getTaskTermAuditTrail(taskId, termId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling MappingApi#getTaskTermAuditTrail");
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
| **taskId** | **String**| task.id returned by /task/add, e.g. 642c0e8a-8bdc-4ae6-8773-9f6cd8bc2fd3 | |
| **termId** | **String**| term.id, e.g. 8271f5b9-ee2a-4614-87a1-2c071c9d6076 | |

### Return type

[**List&lt;AuditEntry&gt;**](AuditEntry.md)

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Return audit trail |  -  |
| **400** | Bad request |  -  |
| **401** | Unauthorized |  -  |
| **403** | Forbidden |  -  |
| **500** | Internal server error |  -  |


## getVersions

> List&lt;Tag&gt; getVersions()

Get version information for components of the application

### Example

```java
// Import classes:
import api.invoker.ApiClient;
import api.invoker.ApiException;
import api.invoker.Configuration;
import api.invoker.auth.*;
import api.invoker.model.*;
import api.MappingApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://automap.terminology.tools");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        MappingApi apiInstance = new MappingApi(defaultClient);
        try {
            List<Tag> result = apiInstance.getVersions();
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling MappingApi#getVersions");
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

[**List&lt;Tag&gt;**](Tag.md)

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Return component versions |  -  |
| **400** | Bad request |  -  |
| **401** | Unauthorized |  -  |
| **403** | Forbidden |  -  |
| **500** | Internal server error |  -  |

