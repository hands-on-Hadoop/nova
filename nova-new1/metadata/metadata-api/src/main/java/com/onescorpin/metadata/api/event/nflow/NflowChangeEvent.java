/**
 *
 */
package com.onescorpin.metadata.api.event.nflow;

/*-
 * #%L
 * onescorpin-metadata-api
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

import com.onescorpin.metadata.api.event.AbstractMetadataEvent;

import org.joda.time.DateTime;

import java.security.Principal;

/**
 *
 */
public class NflowChangeEvent extends AbstractMetadataEvent<NflowChange> {

    private static final long serialVersionUID = 1L;

    public NflowChangeEvent(NflowChange data) {
        super(data);
    }

    public NflowChangeEvent(NflowChange data, Principal user) {
        super(data, user);
    }

    public NflowChangeEvent(NflowChange data, DateTime time, Principal user) {
        super(data, time, user);
    }

}
