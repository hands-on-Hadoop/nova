/**
 *
 */
package com.onescorpin.metadata.sla.alerts;

/*-
 * #%L
 * onescorpin-sla-core
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

import com.onescorpin.alerts.api.Alert;
import com.onescorpin.alerts.api.AlertResponder;
import com.onescorpin.alerts.api.AlertResponse;
import com.onescorpin.alerts.sla.AssessmentAlerts;

/**
 *
 */
public class AssessmentAlertResponder implements AlertResponder {

    /* (non-Javadoc)
     * @see com.onescorpin.alerts.api.AlertResponder#alertChange(com.onescorpin.alerts.api.Alert, com.onescorpin.alerts.api.AlertResponse)
     */
    @Override
    public void alertChange(Alert alert, AlertResponse response) {
        if (alert.getType().equals(AssessmentAlerts.VIOLATION_ALERT)) {
            try {
                response.inProgress("Handling volation");
                handleViolation(alert);
                response.handle("Handled violation");
            } catch (Exception e) {
                response.unhandle("Failed to handle violation");
            }
        }
    }

    private void handleViolation(Alert alert) {

    }

}
