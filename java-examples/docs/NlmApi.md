# NlmApi

All URIs are relative to *https://automap.terminology.tools*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**getQuestionform**](NlmApi.md#getQuestionform) | **GET** /nlm/questionform/{terminology}/{code} | Get concept |



## getQuestionform

> Concept getQuestionform(terminology, code)

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
import api.NlmApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://automap.terminology.tools");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        NlmApi apiInstance = new NlmApi(defaultClient);
        String terminology = "terminology_example"; // String | terminology, e.g. SNOMEDCT_US
        String code = "code_example"; // String | concept code, e.g. 71388002
        try {
            Concept result = apiInstance.getQuestionform(terminology, code);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling NlmApi#getQuestionform");
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

