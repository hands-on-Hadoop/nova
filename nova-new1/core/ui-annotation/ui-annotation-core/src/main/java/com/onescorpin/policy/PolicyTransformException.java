package com.onescorpin.policy;

/*-
 * #%L
 * onescorpin-field-policy-common
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
 * An exception that is thrown if unable to convert a annotated policy to/from the user interface class
 */
public class PolicyTransformException extends Exception {

    public PolicyTransformException() {
        super();
    }

    public PolicyTransformException(String message) {
        super(message);
    }

    public PolicyTransformException(String message, Throwable cause) {
        super(message, cause);
    }

    public PolicyTransformException(Throwable cause) {
        super(cause);
    }

    protected PolicyTransformException(String message, Throwable cause, boolean enableSuppression,
                                       boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
