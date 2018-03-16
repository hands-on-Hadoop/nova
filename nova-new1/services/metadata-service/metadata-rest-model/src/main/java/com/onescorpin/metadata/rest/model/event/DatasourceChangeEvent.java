/**
 *
 */
package com.onescorpin.metadata.rest.model.event;

/*-
 * #%L
 * onescorpin-metadata-rest-model
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
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.onescorpin.metadata.rest.model.nflow.Nflow;
import com.onescorpin.metadata.rest.model.op.Dataset;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 */
@SuppressWarnings("serial")
@JsonInclude(Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class DatasourceChangeEvent implements Serializable {

    private Nflow nflow;
    private List<Dataset> datasets = new ArrayList<>();

    public DatasourceChangeEvent() {
        super();
    }

    public DatasourceChangeEvent(Nflow nflow) {
        super();
        this.nflow = nflow;
    }

    public Nflow getNflow() {
        return nflow;
    }

    public void setNflow(Nflow nflow) {
        this.nflow = nflow;
    }

    public List<Dataset> getDatasets() {
        return datasets;
    }

    public void setDatasets(List<Dataset> datasets) {
        this.datasets = datasets;
    }

    public void addDataset(Dataset ds) {
        this.datasets.add(ds);
    }
}
