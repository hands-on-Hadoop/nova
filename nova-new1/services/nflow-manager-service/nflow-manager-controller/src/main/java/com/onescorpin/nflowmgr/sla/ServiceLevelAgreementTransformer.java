package com.onescorpin.nflowmgr.sla;

/*-
 * #%L
 * onescorpin-nflow-manager-controller
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

import com.onescorpin.metadata.sla.api.Metric;
import com.onescorpin.policy.PolicyTransformException;

/**
 * Transform user interface SLA metrics {@link ServiceLevelAgreementRule} to/from domain {@link Metric} objects
 */
public interface ServiceLevelAgreementTransformer {

    ServiceLevelAgreementRule toUIModel(Metric rule);

    Metric fromUiModel(ServiceLevelAgreementRule rule)
        throws PolicyTransformException;


}
