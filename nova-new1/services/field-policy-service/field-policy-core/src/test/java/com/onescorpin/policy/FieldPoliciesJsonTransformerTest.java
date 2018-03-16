package com.onescorpin.policy;

/*-
 * #%L
 * nova-field-policy-core
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

import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.*;

public class FieldPoliciesJsonTransformerTest {

    @Test
    public void testPolicyMap() {
        String fieldPolicyJson = "[{\"profile\":true,\"index\":false,\"fieldName\":\"fieldA\",\"nflowFieldName\":\"fieldA\",\"standardization\":null,\"validation\":[{\"name\":\"Not Null\","
                                 + "\"displayName\":null,\"description\":null,\"shortDescription\":null,\"properties\":[{\"name\":\"EMPTY_STRING\",\"displayName\":null,\"value\":\"false\",\"values\":null,\"placeholder\":null,\"type\":null,\"hint\":null,\"objectProperty\":\"allowEmptyString\",\"selectableValues\":[],\"required\":false,\"group\":null,\"groupOrder\":null,\"layout\":null,\"hidden\":false,\"pattern\":null,\"patternInvalidMessage\":null},{\"name\":\"TRIM_STRING\",\"displayName\":null,\"value\":\"true\",\"values\":null,\"placeholder\":null,\"type\":null,\"hint\":null,\"objectProperty\":\"trimString\",\"selectableValues\":[],\"required\":false,\"group\":null,\"groupOrder\":null,\"layout\":null,\"hidden\":false,\"pattern\":null,\"patternInvalidMessage\":null}],\"objectClassType\":\"com.onescorpin.policy.validation.NotNullValidator\",\"objectShortClassType\":\"NotNullValidator\",\"propertyValuesDisplayString\":null,\"regex\":null,\"type\":null}]},{\"profile\":true,\"index\":false,\"fieldName\":\"id\",\"nflowFieldName\":\"id\",\"standardization\":null,\"validation\":null},{\"profile\":true,\"index\":false,\"fieldName\":\"email\",\"nflowFieldName\":\"email\",\"standardization\":null,\"validation\":null},{\"profile\":true,\"index\":false,\"fieldName\":\"gender\",\"nflowFieldName\":\"gender\",\"standardization\":null,\"validation\":null},{\"profile\":true,\"index\":false,\"fieldName\":\"ip_address\",\"nflowFieldName\":\"ip_address\",\"standardization\":null,\"validation\":null},{\"profile\":true,\"index\":false,\"fieldName\":\"credit_card\",\"nflowFieldName\":\"credit_card\",\"standardization\":null,\"validation\":null},{\"profile\":true,\"index\":false,\"fieldName\":\"country\",\"nflowFieldName\":\"country\",\"standardization\":null,\"validation\":null},{\"profile\":true,\"index\":false,\"fieldName\":\"birthdate\",\"nflowFieldName\":\"birthdate\",\"standardization\":null,\"validation\":null},{\"profile\":true,\"index\":false,\"fieldName\":\"salary\",\"nflowFieldName\":\"salary\",\"standardization\":null,\"validation\":null},{\"profile\":true,\"index\":false,\"fieldName\":\"fieldB\",\"nflowFieldName\":\"fieldB\",\"standardization\":null,\"validation\":null}]";
        Map<String, FieldPolicy> policyMap = new FieldPoliciesJsonTransformer(fieldPolicyJson).buildPolicies();
        assertEquals(policyMap.size(), 10);

    }
}
