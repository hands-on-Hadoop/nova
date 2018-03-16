package com.onescorpin.metadata.api.jobrepo.job;

/*-
 * #%L
 * onescorpin-operational-metadata-api
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

/**
 * Represents a key/value store for data captured during the Job execution
 */
public interface BatchJobExecutionContextValue {

    /**
     * Return a unique id for this record
     *
     * @return the unique id of this context value
     */
    String getId();

    /**
     * Return the property key name to capture
     *
     * @return The property key name to capture
     */
    String getKeyName();

    /**
     * Return the reference back to the job execution id
     *
     * @return the reference back to the job execution id
     * @see BatchJobExecution
     */
    Long getJobExecutionId();

    /**
     * Return the value of this context item
     *
     * @return the value of this  context item
     */
    String getStringVal();
}
