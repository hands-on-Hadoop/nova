package com.onescorpin.app;

/*-
 * #%L
 * onescorpin-service-app-api
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

/**
 * Listener that will get notified with the services-app starts up
 */
public interface ServicesApplicationStartupListener {


    enum ListenerType {
        UPGRADE_ONLY, NOVA_ONLY,UPGRADE_AND_NOVA
    }

    /**
     * notified when services-app starts up
     *
     * @param startTime the time the application started
     */
    void onStartup(DateTime startTime);

}
