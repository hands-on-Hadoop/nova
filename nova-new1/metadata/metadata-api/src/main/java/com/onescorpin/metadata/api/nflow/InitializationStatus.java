/**
 *
 */
package com.onescorpin.metadata.api.nflow;

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

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

/**
 *
 */
public class InitializationStatus {

    private final State state;
    private final DateTime timestamp;

    public InitializationStatus(State state) {
        this(state, DateTime.now(DateTimeZone.UTC));
    }

    public InitializationStatus(State state, DateTime timestamp) {
        super();
        this.state = state;
        this.timestamp = timestamp;
    }

    public State getState() {
        return state;
    }

    public DateTime getTimestamp() {
        return timestamp;
    }

    public enum State {
        PENDING, IN_PROGRESS, SUCCESS, FAILED
    }


}
