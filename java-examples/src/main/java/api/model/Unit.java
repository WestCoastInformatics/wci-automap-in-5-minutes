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
 * Measurement unit specification
 */
@JsonPropertyOrder({
  Unit.JSON_PROPERTY_NAME,
  Unit.JSON_PROPERTY_CODE,
  Unit.JSON_PROPERTY_SYSTEM,
  Unit.JSON_PROPERTY_DEFAULT
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-07-16T18:58:01.210254-07:00[America/Los_Angeles]", comments = "Generator version: 7.5.0")
public class Unit {
  public static final String JSON_PROPERTY_NAME = "name";
  private String name;

  public static final String JSON_PROPERTY_CODE = "code";
  private String code;

  public static final String JSON_PROPERTY_SYSTEM = "system";
  private String system;

  public static final String JSON_PROPERTY_DEFAULT = "default";
  private Boolean _default;

  public Unit() { 
  }

  public Unit name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Display name of the unit
   * @return name
  **/
  @jakarta.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getName() {
    return name;
  }


  @JsonProperty(JSON_PROPERTY_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setName(String name) {
    this.name = name;
  }


  public Unit code(String code) {
    this.code = code;
    return this;
  }

   /**
   * Unit code identifier
   * @return code
  **/
  @jakarta.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_CODE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getCode() {
    return code;
  }


  @JsonProperty(JSON_PROPERTY_CODE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setCode(String code) {
    this.code = code;
  }


  public Unit system(String system) {
    this.system = system;
    return this;
  }

   /**
   * Unit system (e.g., &#39;http://unitsofmeasure.org&#39;)
   * @return system
  **/
  @jakarta.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_SYSTEM)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getSystem() {
    return system;
  }


  @JsonProperty(JSON_PROPERTY_SYSTEM)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setSystem(String system) {
    this.system = system;
  }


  public Unit _default(Boolean _default) {
    this._default = _default;
    return this;
  }

   /**
   * Get _default
   * @return _default
  **/
  @jakarta.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_DEFAULT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Boolean getDefault() {
    return _default;
  }


  @JsonProperty(JSON_PROPERTY_DEFAULT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setDefault(Boolean _default) {
    this._default = _default;
  }


  /**
   * Return true if this Unit object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Unit unit = (Unit) o;
    return Objects.equals(this.name, unit.name) &&
        Objects.equals(this.code, unit.code) &&
        Objects.equals(this.system, unit.system) &&
        Objects.equals(this._default, unit._default);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, code, system, _default);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Unit {\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    system: ").append(toIndentedString(system)).append("\n");
    sb.append("    _default: ").append(toIndentedString(_default)).append("\n");
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

