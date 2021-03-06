package com.onescorpin.policy.rest.model;

/*-
 * #%L
 * onescorpin-field-policy-rest-model
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
 * Builder for creating new {@link FieldStandardizationRule} objects
 */
public class FieldStandardizationRuleBuilder extends BasePolicyRuleBuilder<FieldStandardizationRule, FieldStandardizationRuleBuilder> {

    public FieldStandardizationRuleBuilder(String name) {
        super(name);
    }


    public FieldStandardizationRule build() {
        FieldStandardizationRule rule = new FieldStandardizationRule();
        rule.setName(this.name);
        rule.setDescription(this.description);
        rule.setDisplayName(this.displayName);
        rule.setProperties(this.properties);
        rule.setObjectClassType(this.objectClassType);
        rule.setSequence(this.sequence);
        return rule;
    }

}
