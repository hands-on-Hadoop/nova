package com.onescorpin.jira.domain;

/*-
 * #%L
 * onescorpin-jira-rest-client
 * %%
 * Copyright (C) 2017 Onescorpin
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Generated;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
                       "self",
                       "watchCount",
                       "isWatching"
                   })
public class Watches {

    @JsonProperty("self")
    private String self;
    @JsonProperty("watchCount")
    private Integer watchCount;
    @JsonProperty("isWatching")
    private Boolean isWatching;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * @return The self
     */
    @JsonProperty("self")
    public String getSelf() {
        return self;
    }

    /**
     * @param self The self
     */
    @JsonProperty("self")
    public void setSelf(String self) {
        this.self = self;
    }

    /**
     * @return The watchCount
     */
    @JsonProperty("watchCount")
    public Integer getWatchCount() {
        return watchCount;
    }

    /**
     * @param watchCount The watchCount
     */
    @JsonProperty("watchCount")
    public void setWatchCount(Integer watchCount) {
        this.watchCount = watchCount;
    }

    /**
     * @return The isWatching
     */
    @JsonProperty("isWatching")
    public Boolean getIsWatching() {
        return isWatching;
    }

    /**
     * @param isWatching The isWatching
     */
    @JsonProperty("isWatching")
    public void setIsWatching(Boolean isWatching) {
        this.isWatching = isWatching;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
