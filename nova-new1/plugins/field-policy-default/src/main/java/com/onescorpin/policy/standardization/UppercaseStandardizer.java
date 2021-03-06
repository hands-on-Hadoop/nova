package com.onescorpin.policy.standardization;

/*-
 * #%L
 * onescorpin-field-policy-default
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
 * Converts a value to upper case
 */
@Standardizer(name = "Uppercase", description = "Convert string to uppercase")
public class UppercaseStandardizer implements StandardizationPolicy {

    private static final UppercaseStandardizer instance = new UppercaseStandardizer();

    private UppercaseStandardizer() {
        super();
    }

    public static UppercaseStandardizer instance() {
        return instance;
    }

    @Override
    public String convertValue(String value) {
        return value.toUpperCase();
    }

    public Boolean accepts (Object value) {
        return (value instanceof String);
    }

    public Object convertRawValue(Object value) {
        if (accepts(value)) {
            return String.valueOf(convertValue(value.toString()));
        }

        return value;
    }
}
