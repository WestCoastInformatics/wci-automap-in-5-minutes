package api;

import com.wci.automap.client.invoker.ApiException;
import com.wci.automap.client.invoker.ApiClient;
import com.wci.automap.client.invoker.ApiResponse;
import com.wci.automap.client.invoker.Configuration;
import com.wci.automap.client.invoker.Pair;

import jakarta.ws.rs.core.GenericType;

import com.wci.automap.client.model.AuthRequest;
import com.wci.automap.client.model.AuthResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-11-03T12:31:07.733622100-08:00[America/Los_Angeles]", comments = "Generator version: 7.5.0")
public class LoginApi {
  private ApiClient apiClient;

  public LoginApi() {
    this(Configuration.getDefaultApiClient());
  }

  public LoginApi(ApiClient apiClient) {
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
   * Login
   * 
   * @param authRequest Authorization information (required)
   * @return AuthResponse
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Acquire access token for subsequent calls </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal server error </td><td>  -  </td></tr>
     </table>
   */
  public AuthResponse auth(AuthRequest authRequest) throws ApiException {
    return authWithHttpInfo(authRequest).getData();
  }

  /**
   * Login
   * 
   * @param authRequest Authorization information (required)
   * @return ApiResponse&lt;AuthResponse&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Acquire access token for subsequent calls </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Internal server error </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<AuthResponse> authWithHttpInfo(AuthRequest authRequest) throws ApiException {
    // Check required parameters
    if (authRequest == null) {
      throw new ApiException(400, "Missing the required parameter 'authRequest' when calling auth");
    }

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType("application/json");
    String[] localVarAuthNames = new String[] {"bearerAuth"};
    GenericType<AuthResponse> localVarReturnType = new GenericType<AuthResponse>() {};
    return apiClient.invokeAPI("LoginApi.auth", "/auth/token", "POST", new ArrayList<>(), authRequest,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
}
