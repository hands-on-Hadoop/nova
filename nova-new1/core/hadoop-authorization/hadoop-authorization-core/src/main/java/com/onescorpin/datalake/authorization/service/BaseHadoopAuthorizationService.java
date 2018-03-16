package com.onescorpin.datalake.authorization.service;

/*-
 * #%L
 * onescorpin-hadoop-authorization-core
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

import com.onescorpin.metadata.api.event.MetadataEventListener;
import com.onescorpin.metadata.api.event.MetadataEventService;
import com.onescorpin.metadata.api.event.nflow.NflowPropertyChangeEvent;
import com.onescorpin.metadata.api.event.nflow.PropertyChange;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;

/**
 */
public abstract class BaseHadoopAuthorizationService implements HadoopAuthorizationService {

    public static final String REGISTRATION_HDFS_FOLDERS = "nifi:registration:hdfsFolders";
    public static final String REGISTRATION_HIVE_SCHEMA = "nifi:registration:hiveSchema";
    public static final String REGISTRATION_HIVE_TABLES = "nifi:registration:hiveTableNames";
    private static final Logger log = LoggerFactory.getLogger(BaseHadoopAuthorizationService.class);
    /**
     * Event listener for precondition events
     */
    private final MetadataEventListener<NflowPropertyChangeEvent> nflowPropertyChangeListener = new NflowPropertyChangeDispatcher();

    @Inject
    private MetadataEventService metadataEventService;

    /**
     * Adds listeners for transferring events.
     */
    @PostConstruct
    public void addEventListener() {
        metadataEventService.addListener(nflowPropertyChangeListener);
    }

    /**
     * Removes listeners and stops transferring events.
     */
    @PreDestroy
    public void removeEventListener() {
        metadataEventService.removeListener(nflowPropertyChangeListener);
    }

    private class NflowPropertyChangeDispatcher implements MetadataEventListener<NflowPropertyChangeEvent> {

        @Override
        public void notify(final NflowPropertyChangeEvent metadataEvent) {
            PropertyChange change = metadataEvent.getData();

            if (change.getHadoopSecurityGroupNames() != null && hadoopAuthorizationChangesRequired(metadataEvent)) {
                try {
                    String hdfsFolders = change.getNewProperties().getProperty(REGISTRATION_HDFS_FOLDERS);

                    if (!StringUtils.isEmpty(hdfsFolders)) {
                        String hdfsFoldersWithCommas = hdfsFolders.replace("\n", ",");
                        List<String> hdfsFoldersConverted = Arrays.asList(hdfsFoldersWithCommas.split(",")).stream().collect(Collectors.toList());

                        createOrUpdateReadOnlyHdfsPolicy(change.getNflowCategorySystemName(), change.getNflowSystemName()
                            , change.getHadoopSecurityGroupNames()
                            , hdfsFoldersConverted);
                    }

                    String hiveTables = change.getNewProperties().getProperty(REGISTRATION_HIVE_TABLES);
                    String hiveSchema = change.getNewProperties().getProperty(REGISTRATION_HIVE_SCHEMA);
                    if (!StringUtils.isEmpty(hiveTables) && !StringUtils.isEmpty(hiveSchema)) {
                        String hiveTablesWithCommas = hiveTables.replace("\n", ",");
                        List<String> hiveTablesConverted = Arrays.asList(hiveTablesWithCommas.split(",")).stream().collect(Collectors.toList());

                        createOrUpdateReadOnlyHivePolicy(change.getNflowCategorySystemName(), change.getNflowSystemName()
                            , change.getHadoopSecurityGroupNames()
                            , hiveSchema
                            , hiveTablesConverted);
                    }
                } catch (Exception e) {
                    log.error("Error creating Nova Authorization policy after metadata property change event", e);
                    throw new RuntimeException("Error creating Nova Authorization policy after metadata property change event");
                }
            }
        }

        private boolean hadoopAuthorizationChangesRequired(final NflowPropertyChangeEvent metadataEvent) {
            PropertyChange change = metadataEvent.getData();
            String hdfsFoldersWithCommasNew = change.getNewProperties().getProperty(REGISTRATION_HDFS_FOLDERS);
            String hiveTablesWithCommasNew = change.getNewProperties().getProperty(REGISTRATION_HIVE_TABLES);
            String hiveSchemaNew = change.getNewProperties().getProperty(REGISTRATION_HIVE_SCHEMA);

            if (hdfsFoldersWithCommasNew != null || (hiveSchemaNew != null && hiveTablesWithCommasNew != null)) {
                return true;
            }
            return false;
        }
    }
}
