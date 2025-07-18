/*
 * WCI Automap API
 * <p>API documentation for the West Coast Informatics Automated Term Mapping Service.</p><p>For developer documentation and examples, see on GitHub <a href=\"https://github.com/westCoastInformatics/wci-automap-in-5-minutes\">WCI Automap in 5 Minutes</a></p>
 *
 * The version of the OpenAPI document: 1.0.0
 * Contact: info@westcoastinformatics.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package api.model;

import java.util.Objects;
import java.util.Map;
import java.util.HashMap;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import api.invoker.JSON;


/**
 * Response to successful authentication
 */
@JsonPropertyOrder({
  AuthResponse.JSON_PROPERTY_ACCESS_TOKEN,
  AuthResponse.JSON_PROPERTY_REFRESH_TOKEN,
  AuthResponse.JSON_PROPERTY_EXPIRES_IN,
  AuthResponse.JSON_PROPERTY_EXPIRES_ON,
  AuthResponse.JSON_PROPERTY_TOKEN_TYPE
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-07-16T18:58:01.210254-07:00[America/Los_Angeles]", comments = "Generator version: 7.5.0")
public class AuthResponse {
  public static final String JSON_PROPERTY_ACCESS_TOKEN = "access_token";
  private String accessToken;

  public static final String JSON_PROPERTY_REFRESH_TOKEN = "refresh_token";
  private String refreshToken;

  public static final String JSON_PROPERTY_EXPIRES_IN = "expires_in";
  private Long expiresIn;

  public static final String JSON_PROPERTY_EXPIRES_ON = "expires_on";
  private Long expiresOn;

  public static final String JSON_PROPERTY_TOKEN_TYPE = "token_type";
  private String tokenType;

  public AuthResponse() { 
  }

  public AuthResponse accessToken(String accessToken) {
    this.accessToken = accessToken;
    return this;
  }

   /**
   * the access token
   * @return accessToken
  **/
  @jakarta.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_ACCESS_TOKEN)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getAccessToken() {
    return accessToken;
  }


  @JsonProperty(JSON_PROPERTY_ACCESS_TOKEN)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setAccessToken(String accessToken) {
    this.accessToken = accessToken;
  }


  public AuthResponse refreshToken(String refreshToken) {
    this.refreshToken = refreshToken;
    return this;
  }

   /**
   * the refresh token
   * @return refreshToken
  **/
  @jakarta.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_REFRESH_TOKEN)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getRefreshToken() {
    return refreshToken;
  }


  @JsonProperty(JSON_PROPERTY_REFRESH_TOKEN)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setRefreshToken(String refreshToken) {
    this.refreshToken = refreshToken;
  }


  public AuthResponse expiresIn(Long expiresIn) {
    this.expiresIn = expiresIn;
    return this;
  }

   /**
   * milliseconds until the access token expires
   * @return expiresIn
  **/
  @jakarta.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_EXPIRES_IN)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Long getExpiresIn() {
    return expiresIn;
  }


  @JsonProperty(JSON_PROPERTY_EXPIRES_IN)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setExpiresIn(Long expiresIn) {
    this.expiresIn = expiresIn;
  }


  public AuthResponse expiresOn(Long expiresOn) {
    this.expiresOn = expiresOn;
    return this;
  }

   /**
   * epoch time of access token expiration
   * @return expiresOn
  **/
  @jakarta.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_EXPIRES_ON)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Long getExpiresOn() {
    return expiresOn;
  }


  @JsonProperty(JSON_PROPERTY_EXPIRES_ON)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setExpiresOn(Long expiresOn) {
    this.expiresOn = expiresOn;
  }


  public AuthResponse tokenType(String tokenType) {
    this.tokenType = tokenType;
    return this;
  }

   /**
   * the token type
   * @return tokenType
  **/
  @jakarta.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_TOKEN_TYPE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getTokenType() {
    return tokenType;
  }


  @JsonProperty(JSON_PROPERTY_TOKEN_TYPE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setTokenType(String tokenType) {
    this.tokenType = tokenType;
  }


  /**
   * Return true if this AuthResponse object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AuthResponse authResponse = (AuthResponse) o;
    return Objects.equals(this.accessToken, authResponse.accessToken) &&
        Objects.equals(this.refreshToken, authResponse.refreshToken) &&
        Objects.equals(this.expiresIn, authResponse.expiresIn) &&
        Objects.equals(this.expiresOn, authResponse.expiresOn) &&
        Objects.equals(this.tokenType, authResponse.tokenType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accessToken, refreshToken, expiresIn, expiresOn, tokenType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AuthResponse {\n");
    sb.append("    accessToken: ").append(toIndentedString(accessToken)).append("\n");
    sb.append("    refreshToken: ").append(toIndentedString(refreshToken)).append("\n");
    sb.append("    expiresIn: ").append(toIndentedString(expiresIn)).append("\n");
    sb.append("    expiresOn: ").append(toIndentedString(expiresOn)).append("\n");
    sb.append("    tokenType: ").append(toIndentedString(tokenType)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

