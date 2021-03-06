/**
 *
 */
package com.onescorpin.metadata.sla.api;

/*-
 * #%L
 * onescorpin-sla-api
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
 *
 */
public class ServiceLevelAgreementException extends RuntimeException {

    private static final long serialVersionUID = -6350855489286578608L;

    public ServiceLevelAgreementException(String message) {
        super(message);
    }

    public ServiceLevelAgreementException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceLevelAgreementException(String message, Throwable cause, boolean enableSuppression,
                                          boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
