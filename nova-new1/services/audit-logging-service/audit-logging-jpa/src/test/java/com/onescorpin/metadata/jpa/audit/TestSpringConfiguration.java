package com.onescorpin.metadata.jpa.audit;

/*-
 * #%L
 * onescorpin-audit-logging-jpa
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

import com.onescorpin.alerts.api.AlertProvider;
import com.onescorpin.alerts.spi.AlertManager;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class TestSpringConfiguration {

    @Bean
    AlertProvider alertProvider(){
        return Mockito.mock(AlertProvider.class);
    }

    @Bean(name = "novaAlertManager")
    AlertManager alertManager(){
        return Mockito.mock(AlertManager.class);
    }
}
