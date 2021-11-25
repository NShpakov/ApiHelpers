
package ru.nshpakov.model.json;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "additionalProp1",
    "additionalProp2",
    "additionalProp3"
})
public class GetStoreRs {

    @JsonProperty("additionalProp1")
    private Integer additionalProp1;
    @JsonProperty("additionalProp2")
    private Integer additionalProp2;
    @JsonProperty("additionalProp3")
    private Integer additionalProp3;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("additionalProp1")
    public Integer getAdditionalProp1() {
        return additionalProp1;
    }

    @JsonProperty("additionalProp1")
    public void setAdditionalProp1(Integer additionalProp1) {
        this.additionalProp1 = additionalProp1;
    }

    @JsonProperty("additionalProp2")
    public Integer getAdditionalProp2() {
        return additionalProp2;
    }

    @JsonProperty("additionalProp2")
    public void setAdditionalProp2(Integer additionalProp2) {
        this.additionalProp2 = additionalProp2;
    }

    @JsonProperty("additionalProp3")
    public Integer getAdditionalProp3() {
        return additionalProp3;
    }

    @JsonProperty("additionalProp3")
    public void setAdditionalProp3(Integer additionalProp3) {
        this.additionalProp3 = additionalProp3;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("additionalProp1", additionalProp1).append("additionalProp2", additionalProp2).append("additionalProp3", additionalProp3).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(additionalProp3).append(additionalProp2).append(additionalProperties).append(additionalProp1).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof GetStoreRs) == false) {
            return false;
        }
        GetStoreRs rhs = ((GetStoreRs) other);
        return new EqualsBuilder().append(additionalProp3, rhs.additionalProp3).append(additionalProp2, rhs.additionalProp2).append(additionalProperties, rhs.additionalProperties).append(additionalProp1, rhs.additionalProp1).isEquals();
    }

}
