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
 * Represents important term and task metadata
 */
@JsonPropertyOrder({
  ApplicationMetadataMap.JSON_PROPERTY_EMPTY
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-07-16T18:58:01.210254-07:00[America/Los_Angeles]", comments = "Generator version: 7.5.0")
public class ApplicationMetadataMap {
  public static final String JSON_PROPERTY_EMPTY = "empty";
  private Boolean empty;

  public ApplicationMetadataMap() { 
  }

  public ApplicationMetadataMap empty(Boolean empty) {
    this.empty = empty;
    return this;
  }

   /**
   * Get empty
   * @return empty
  **/
  @jakarta.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_EMPTY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Boolean getEmpty() {
    return empty;
  }


  @JsonProperty(JSON_PROPERTY_EMPTY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setEmpty(Boolean empty) {
    this.empty = empty;
  }


  /**
   * Return true if this ApplicationMetadataMap object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ApplicationMetadataMap applicationMetadataMap = (ApplicationMetadataMap) o;
    return Objects.equals(this.empty, applicationMetadataMap.empty);
  }

  @Override
  public int hashCode() {
    return Objects.hash(empty);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ApplicationMetadataMap {\n");
    sb.append("    empty: ").append(toIndentedString(empty)).append("\n");
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

