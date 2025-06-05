package api;

import api.invoker.ApiException;
import api.invoker.ApiClient;
import api.invoker.ApiResponse;
import api.invoker.Configuration;
import api.invoker.Pair;

import jakarta.ws.rs.core.GenericType;

import api.model.ApplicationMetadataMap;
import api.model.AuditEntry;
import api.model.InputTask;
import api.model.OutputTask;
import api.model.OutputTaskList;
import api.model.OutputTerm;
import api.model.Tag;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-05-29T16:47:36.399771100-07:00[America/Los_Angeles]", comments = "Generator version: 7.5.0")
public class MappingApi {
  private ApiClient apiClient;

  public MappingApi() {
    this(Configuration.getDefaultApiClient());
  }

  public MappingApi(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  /**
   * Get the API client
   *
   * @return API client
   */
  public ApiClient getApiClient() {
    return apiClient;
  }

  /**
   * Set the API client
   *
   * @param apiClient an instance of API client
   */
  public void setApiClient(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  /**
   * Add an task to request mapping of included terms
   * &lt;a href&#x3D;\&quot;/examples/index.html\&quot;&gt;Click here&lt;/a&gt; for samples of request and response body.
   * @param inputTask Batch of terms to map (required)
   * @return OutputTask
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 201 </td><td> Return the task with mappings for requested terms </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad request </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal server error </td><td>  -  </td></tr>
     </table>
   * Additional sample request and response bodies
   * @see <a href="http://localhost:8082/examples/index.html">Add an task to request mapping of included terms Documentation</a>
   */
  public OutputTask addTask(InputTask inputTask) throws ApiException {
    return addTaskWithHttpInfo(inputTask).getData();
  }

  /**
   * Add an task to request mapping of included terms
   * &lt;a href&#x3D;\&quot;/examples/index.html\&quot;&gt;Click here&lt;/a&gt; for samples of request and response body.
   * @param inputTask Batch of terms to map (required)
   * @return ApiResponse&lt;OutputTask&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 201 </td><td> Return the task with mappings for requested terms </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad request </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal server error </td><td>  -  </td></tr>
     </table>
   * Additional sample request and response bodies
   * @see <a href="http://localhost:8082/examples/index.html">Add an task to request mapping of included terms Documentation</a>
   */
  public ApiResponse<OutputTask> addTaskWithHttpInfo(InputTask inputTask) throws ApiException {
    // Check required parameters
    if (inputTask == null) {
      throw new ApiException(400, "Missing the required parameter 'inputTask' when calling addTask");
    }

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType("application/json");
    String[] localVarAuthNames = new String[] {"bearerAuth"};
    GenericType<OutputTask> localVarReturnType = new GenericType<OutputTask>() {};
    return apiClient.invokeAPI("MappingApi.addTask", "/api/v1/mapping/task", "POST", new ArrayList<>(), inputTask,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Find tasks matching specified parameters
   * 
   * @param query search query, e.g. heart attack (optional)
   * @param offset start index for search results (optional)
   * @param limit limit of results to return (optional)
   * @param sort comma-separated list of fields to sort on (optional)
   * @param ascending &lt;code&gt;true&lt;/code&gt; for ascending, &lt;code&gt;false&lt;/code&gt; for descending, &lt;code&gt;null&lt;/code&gt; for unspecified (optional)
   * @return OutputTaskList
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Return list of matching tasks </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad request </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal server error </td><td>  -  </td></tr>
     </table>
   */
  public OutputTaskList findTasks(String query, Integer offset, Integer limit, String sort, Boolean ascending) throws ApiException {
    return findTasksWithHttpInfo(query, offset, limit, sort, ascending).getData();
  }

  /**
   * Find tasks matching specified parameters
   * 
   * @param query search query, e.g. heart attack (optional)
   * @param offset start index for search results (optional)
   * @param limit limit of results to return (optional)
   * @param sort comma-separated list of fields to sort on (optional)
   * @param ascending &lt;code&gt;true&lt;/code&gt; for ascending, &lt;code&gt;false&lt;/code&gt; for descending, &lt;code&gt;null&lt;/code&gt; for unspecified (optional)
   * @return ApiResponse&lt;OutputTaskList&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Return list of matching tasks </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad request </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal server error </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<OutputTaskList> findTasksWithHttpInfo(String query, Integer offset, Integer limit, String sort, Boolean ascending) throws ApiException {
    // Query parameters
    List<Pair> localVarQueryParams = new ArrayList<>(
            apiClient.parameterToPairs("", "query", query)
    );
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "offset", offset));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "limit", limit));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "sort", sort));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "ascending", ascending));

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"bearerAuth"};
    GenericType<OutputTaskList> localVarReturnType = new GenericType<OutputTaskList>() {};
    return apiClient.invokeAPI("MappingApi.findTasks", "/api/v1/mapping/task", "GET", localVarQueryParams, null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Find tasks matching specified parameters
   * 
   * @param query search query, e.g. heart attack (optional)
   * @param offset start index for search results (optional)
   * @param limit limit of results to return (optional)
   * @param sort comma-separated list of fields to sort on (optional)
   * @param ascending &lt;code&gt;true&lt;/code&gt; for ascending, &lt;code&gt;false&lt;/code&gt; for descending, &lt;code&gt;null&lt;/code&gt; for unspecified (optional)
   * @return OutputTaskList
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Return list of matching tasks </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad request </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal server error </td><td>  -  </td></tr>
     </table>
   */
  public OutputTaskList findTerms(String query, Integer offset, Integer limit, String sort, Boolean ascending) throws ApiException {
    return findTermsWithHttpInfo(query, offset, limit, sort, ascending).getData();
  }

  /**
   * Find tasks matching specified parameters
   * 
   * @param query search query, e.g. heart attack (optional)
   * @param offset start index for search results (optional)
   * @param limit limit of results to return (optional)
   * @param sort comma-separated list of fields to sort on (optional)
   * @param ascending &lt;code&gt;true&lt;/code&gt; for ascending, &lt;code&gt;false&lt;/code&gt; for descending, &lt;code&gt;null&lt;/code&gt; for unspecified (optional)
   * @return ApiResponse&lt;OutputTaskList&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Return list of matching tasks </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad request </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal server error </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<OutputTaskList> findTermsWithHttpInfo(String query, Integer offset, Integer limit, String sort, Boolean ascending) throws ApiException {
    // Query parameters
    List<Pair> localVarQueryParams = new ArrayList<>(
            apiClient.parameterToPairs("", "query", query)
    );
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "offset", offset));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "limit", limit));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "sort", sort));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "ascending", ascending));

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"bearerAuth"};
    GenericType<OutputTaskList> localVarReturnType = new GenericType<OutputTaskList>() {};
    return apiClient.invokeAPI("MappingApi.findTerms", "/api/v1/mapping/term", "GET", localVarQueryParams, null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Get entity configuration
   * 
   * @return ApplicationMetadataMap
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Return application metadata </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad request </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal server error </td><td>  -  </td></tr>
     </table>
   */
  public ApplicationMetadataMap getEntityConfig() throws ApiException {
    return getEntityConfigWithHttpInfo().getData();
  }

  /**
   * Get entity configuration
   * 
   * @return ApiResponse&lt;ApplicationMetadataMap&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Return application metadata </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad request </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal server error </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<ApplicationMetadataMap> getEntityConfigWithHttpInfo() throws ApiException {
    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"bearerAuth"};
    GenericType<ApplicationMetadataMap> localVarReturnType = new GenericType<ApplicationMetadataMap>() {};
    return apiClient.invokeAPI("MappingApi.getEntityConfig", "/api/v1/mapping/config", "GET", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Get application metadata
   * 
   * @return ApplicationMetadataMap
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Return application metadata </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad request </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal server error </td><td>  -  </td></tr>
     </table>
   */
  public ApplicationMetadataMap getMetadata() throws ApiException {
    return getMetadataWithHttpInfo().getData();
  }

  /**
   * Get application metadata
   * 
   * @return ApiResponse&lt;ApplicationMetadataMap&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Return application metadata </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad request </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal server error </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<ApplicationMetadataMap> getMetadataWithHttpInfo() throws ApiException {
    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"bearerAuth"};
    GenericType<ApplicationMetadataMap> localVarReturnType = new GenericType<ApplicationMetadataMap>() {};
    return apiClient.invokeAPI("MappingApi.getMetadata", "/api/v1/mapping/metadata", "GET", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Get task object for the specified task id
   * 
   * @param taskId  (required)
   * @return OutputTask
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Return task </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad request </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not found </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal server error </td><td>  -  </td></tr>
     </table>
   */
  public OutputTask getTask(String taskId) throws ApiException {
    return getTaskWithHttpInfo(taskId).getData();
  }

  /**
   * Get task object for the specified task id
   * 
   * @param taskId  (required)
   * @return ApiResponse&lt;OutputTask&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Return task </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad request </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not found </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal server error </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<OutputTask> getTaskWithHttpInfo(String taskId) throws ApiException {
    // Check required parameters
    if (taskId == null) {
      throw new ApiException(400, "Missing the required parameter 'taskId' when calling getTask");
    }

    // Path parameters
    String localVarPath = "/api/v1/mapping/task/{taskId}"
            .replaceAll("\\{taskId}", apiClient.escapeString(taskId));

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"bearerAuth"};
    GenericType<OutputTask> localVarReturnType = new GenericType<OutputTask>() {};
    return apiClient.invokeAPI("MappingApi.getTask", localVarPath, "GET", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Get term for the specified taskId and termId
   * 
   * @param taskId task.id returned by /task/add, e.g. 642c0e8a-8bdc-4ae6-8773-9f6cd8bc2fd3 (required)
   * @param termId term.id, e.g. 8271f5b9-ee2a-4614-87a1-2c071c9d6076 (required)
   * @return OutputTask
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Return term </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad request </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not found </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal server error </td><td>  -  </td></tr>
     </table>
   */
  public OutputTask getTaskTerm(String taskId, String termId) throws ApiException {
    return getTaskTermWithHttpInfo(taskId, termId).getData();
  }

  /**
   * Get term for the specified taskId and termId
   * 
   * @param taskId task.id returned by /task/add, e.g. 642c0e8a-8bdc-4ae6-8773-9f6cd8bc2fd3 (required)
   * @param termId term.id, e.g. 8271f5b9-ee2a-4614-87a1-2c071c9d6076 (required)
   * @return ApiResponse&lt;OutputTask&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Return term </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad request </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not found </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal server error </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<OutputTask> getTaskTermWithHttpInfo(String taskId, String termId) throws ApiException {
    // Check required parameters
    if (taskId == null) {
      throw new ApiException(400, "Missing the required parameter 'taskId' when calling getTaskTerm");
    }
    if (termId == null) {
      throw new ApiException(400, "Missing the required parameter 'termId' when calling getTaskTerm");
    }

    // Path parameters
    String localVarPath = "/api/v1/mapping/task/{taskId}/term/{termId}"
            .replaceAll("\\{taskId}", apiClient.escapeString(taskId))
            .replaceAll("\\{termId}", apiClient.escapeString(termId));

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"bearerAuth"};
    GenericType<OutputTask> localVarReturnType = new GenericType<OutputTask>() {};
    return apiClient.invokeAPI("MappingApi.getTaskTerm", localVarPath, "GET", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Get audit trail for the specified taskId and termId
   * 
   * @param taskId task.id returned by /task/add, e.g. 642c0e8a-8bdc-4ae6-8773-9f6cd8bc2fd3 (required)
   * @param termId term.id, e.g. 8271f5b9-ee2a-4614-87a1-2c071c9d6076 (required)
   * @return List&lt;AuditEntry&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Return audit trail </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad request </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal server error </td><td>  -  </td></tr>
     </table>
   */
  public List<AuditEntry> getTaskTermAuditTrail(String taskId, String termId) throws ApiException {
    return getTaskTermAuditTrailWithHttpInfo(taskId, termId).getData();
  }

  /**
   * Get audit trail for the specified taskId and termId
   * 
   * @param taskId task.id returned by /task/add, e.g. 642c0e8a-8bdc-4ae6-8773-9f6cd8bc2fd3 (required)
   * @param termId term.id, e.g. 8271f5b9-ee2a-4614-87a1-2c071c9d6076 (required)
   * @return ApiResponse&lt;List&lt;AuditEntry&gt;&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Return audit trail </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad request </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal server error </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<List<AuditEntry>> getTaskTermAuditTrailWithHttpInfo(String taskId, String termId) throws ApiException {
    // Check required parameters
    if (taskId == null) {
      throw new ApiException(400, "Missing the required parameter 'taskId' when calling getTaskTermAuditTrail");
    }
    if (termId == null) {
      throw new ApiException(400, "Missing the required parameter 'termId' when calling getTaskTermAuditTrail");
    }

    // Path parameters
    String localVarPath = "/api/v1/mapping/task/{taskId}/term/{termId}/audit"
            .replaceAll("\\{taskId}", apiClient.escapeString(taskId))
            .replaceAll("\\{termId}", apiClient.escapeString(termId));

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"bearerAuth"};
    GenericType<List<AuditEntry>> localVarReturnType = new GenericType<List<AuditEntry>>() {};
    return apiClient.invokeAPI("MappingApi.getTaskTermAuditTrail", localVarPath, "GET", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Get version information for components of the application
   * 
   * @return List&lt;Tag&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Return component versions </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad request </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal server error </td><td>  -  </td></tr>
     </table>
   */
  public List<Tag> getVersions() throws ApiException {
    return getVersionsWithHttpInfo().getData();
  }

  /**
   * Get version information for components of the application
   * 
   * @return ApiResponse&lt;List&lt;Tag&gt;&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Return component versions </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad request </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal server error </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<List<Tag>> getVersionsWithHttpInfo() throws ApiException {
    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"bearerAuth"};
    GenericType<List<Tag>> localVarReturnType = new GenericType<List<Tag>>() {};
    return apiClient.invokeAPI("MappingApi.getVersions", "/api/v1/mapping/version", "GET", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
}
