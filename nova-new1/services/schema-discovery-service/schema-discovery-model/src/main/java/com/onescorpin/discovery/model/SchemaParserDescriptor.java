package com.onescorpin.discovery.model;

/*-
 * #%L
 * onescorpin-schema-discovery-model2
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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.onescorpin.policy.rest.model.BaseUiPolicyRule;

@JsonIgnoreProperties(ignoreUnknown = true)

/**
 * Model used to pass the parser properties
 */
public class SchemaParserDescriptor extends BaseUiPolicyRule {

    private boolean supportsBinary;
    private boolean generatesHiveSerde;
    private String[] tags;
    private String clientHelper;
    private boolean allowSkipHeader;

    public boolean isSupportsBinary() {
        return supportsBinary;
    }

    public void setSupportsBinary(boolean supportsBinary) {
        this.supportsBinary = supportsBinary;
    }

    public boolean isGeneratesHiveSerde() {
        return generatesHiveSerde;
    }

    public void setGeneratesHiveSerde(boolean generatesHiveSerde) {
        this.generatesHiveSerde = generatesHiveSerde;
    }

    public String[] getTags() {
        return tags;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }

    public String getClientHelper() {
        return clientHelper;
    }

    public void setClientHelper(String clientHelper) {
        this.clientHelper = clientHelper;
    }

    public boolean isAllowSkipHeader() {
        return allowSkipHeader;
    }

    public void setAllowSkipHeader(boolean allowSkipHeader) {
        this.allowSkipHeader = allowSkipHeader;
    }
}
