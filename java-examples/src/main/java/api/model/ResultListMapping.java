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
import api.model.Mapping;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import api.invoker.JSON;


/**
 * Represents a list of mappings returned from a find call
 */
@JsonPropertyOrder({
  ResultListMapping.JSON_PROPERTY_TOTAL,
  ResultListMapping.JSON_PROPERTY_LIMIT,
  ResultListMapping.JSON_PROPERTY_OFFSET,
  ResultListMapping.JSON_PROPERTY_CONFIDENCE,
  ResultListMapping.JSON_PROPERTY_FILTERED,
  ResultListMapping.JSON_PROPERTY_ITEMS
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-07-16T18:58:01.210254-07:00[America/Los_Angeles]", comments = "Generator version: 7.5.0")
public class ResultListMapping {
  public static final String JSON_PROPERTY_TOTAL = "total";
  private Integer total;

  public static final String JSON_PROPERTY_LIMIT = "limit";
  private Integer limit;

  public static final String JSON_PROPERTY_OFFSET = "offset";
  private Integer offset;

  public static final String JSON_PROPERTY_CONFIDENCE = "confidence";
  private Double confidence;

  public static final String JSON_PROPERTY_FILTERED = "filtered";
  private Integer filtered;

  public static final String JSON_PROPERTY_ITEMS = "items";
  private List<Mapping> items = new ArrayList<>();

  public ResultListMapping() { 
  }

  public ResultListMapping total(Integer total) {
    this.total = total;
    return this;
  }

   /**
   * the total number of potential results
   * @return total
  **/
  @jakarta.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_TOTAL)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Integer getTotal() {
    return total;
  }


  @JsonProperty(JSON_PROPERTY_TOTAL)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setTotal(Integer total) {
    this.total = total;
  }


  public ResultListMapping limit(Integer limit) {
    this.limit = limit;
    return this;
  }

   /**
   * the max number results requested
   * @return limit
  **/
  @jakarta.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_LIMIT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Integer getLimit() {
    return limit;
  }


  @JsonProperty(JSON_PROPERTY_LIMIT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setLimit(Integer limit) {
    this.limit = limit;
  }


  public ResultListMapping offset(Integer offset) {
    this.offset = offset;
    return this;
  }

   /**
   * the starting index requested
   * @return offset
  **/
  @jakarta.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_OFFSET)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Integer getOffset() {
    return offset;
  }


  @JsonProperty(JSON_PROPERTY_OFFSET)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setOffset(Integer offset) {
    this.offset = offset;
  }


  public ResultListMapping confidence(Double confidence) {
    this.confidence = confidence;
    return this;
  }

   /**
   * the score of the search result, when used
   * @return confidence
  **/
  @jakarta.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_CONFIDENCE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Double getConfidence() {
    return confidence;
  }


  @JsonProperty(JSON_PROPERTY_CONFIDENCE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setConfidence(Double confidence) {
    this.confidence = confidence;
  }


  public ResultListMapping filtered(Integer filtered) {
    this.filtered = filtered;
    return this;
  }

   /**
   * the max number results requested
   * @return filtered
  **/
  @jakarta.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_FILTERED)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Integer getFiltered() {
    return filtered;
  }


  @JsonProperty(JSON_PROPERTY_FILTERED)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setFiltered(Integer filtered) {
    this.filtered = filtered;
  }


  public ResultListMapping items(List<Mapping> items) {
    this.items = items;
    return this;
  }

  public ResultListMapping addItemsItem(Mapping itemsItem) {
    if (this.items == null) {
      this.items = new ArrayList<>();
    }
    this.items.add(itemsItem);
    return this;
  }

   /**
   * the items themselves (the format will vary depending on the type of list)
   * @return items
  **/
  @jakarta.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_ITEMS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public List<Mapping> getItems() {
    return items;
  }


  @JsonProperty(JSON_PROPERTY_ITEMS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setItems(List<Mapping> items) {
    this.items = items;
  }


  /**
   * Return true if this ResultListMapping object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ResultListMapping resultListMapping = (ResultListMapping) o;
    return Objects.equals(this.total, resultListMapping.total) &&
        Objects.equals(this.limit, resultListMapping.limit) &&
        Objects.equals(this.offset, resultListMapping.offset) &&
        Objects.equals(this.confidence, resultListMapping.confidence) &&
        Objects.equals(this.filtered, resultListMapping.filtered) &&
        Objects.equals(this.items, resultListMapping.items);
  }

  @Override
  public int hashCode() {
    return Objects.hash(total, limit, offset, confidence, filtered, items);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ResultListMapping {\n");
    sb.append("    total: ").append(toIndentedString(total)).append("\n");
    sb.append("    limit: ").append(toIndentedString(limit)).append("\n");
    sb.append("    offset: ").append(toIndentedString(offset)).append("\n");
    sb.append("    confidence: ").append(toIndentedString(confidence)).append("\n");
    sb.append("    filtered: ").append(toIndentedString(filtered)).append("\n");
    sb.append("    items: ").append(toIndentedString(items)).append("\n");
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

