package com.onescorpin.nifi.v1.rest.client;

/*-
 * #%L
 * onescorpin-nifi-rest-client-v1.1
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


import com.onescorpin.nifi.rest.client.NiFiProcessorsRestClient;
import com.onescorpin.nifi.rest.client.NifiRestClientConfig;

/**
 * Created by sr186054 on 6/29/17.
 */
public class NiFiRestClientV1_1 extends NiFiRestClientV1 {

    public NiFiRestClientV1_1(NifiRestClientConfig config) {
        super(config);
    }

    @Override
    public NiFiProcessorsRestClient processors() {
        if (processors == null) {
            processors = new NiFiProcessorsRestClientV1_1(this);
        }
        return processors;
    }

}
