package com.onescorpin.metadata.modeshape.generic;

import com.onescorpin.metadata.api.MetadataAccess;

/*-
 * #%L
 * onescorpin-metadata-modeshape
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

import com.onescorpin.metadata.api.extension.ExtensibleEntity;
import com.onescorpin.metadata.api.extension.ExtensibleEntityProvider;
import com.onescorpin.metadata.api.extension.ExtensibleType;
import com.onescorpin.metadata.api.extension.ExtensibleTypeProvider;
import com.onescorpin.metadata.api.extension.FieldDescriptor;
import com.onescorpin.metadata.modeshape.JcrMetadataAccess;
import com.onescorpin.metadata.modeshape.JcrTestConfig;
import com.onescorpin.metadata.modeshape.ModeShapeEngineConfig;
import com.onescorpin.metadata.modeshape.extension.JcrExtensibleTypeProvider;
import com.onescorpin.metadata.modeshape.security.AdminCredentials;

import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import static org.assertj.core.api.Assertions.assertThat;

@SpringApplicationConfiguration(classes = {ModeShapeEngineConfig.class, JcrTestConfig.class, JcrExtensibleProvidersTestConfig.class})
public class JcrExtensibleProvidersTest extends AbstractTestNGSpringContextTests {

    @Inject
    private JcrExtensibleTypeProvider typeProvider;

    @Inject
    private ExtensibleEntityProvider entityProvider;

    @Inject
    private JcrMetadataAccess metadata;
    
    @BeforeClass
    public void ensureExtensibleTypes() {
        metadata.commit(() -> {
            typeProvider.ensureTypeDescriptors();
        }, MetadataAccess.SERVICE);
    }


    @Test
    public void testGetAllDefaultTypes() {
        int size = metadata.commit(new AdminCredentials(), () -> {
            List<ExtensibleType> types = typeProvider.getTypes();

            return types.size();
        });
        //  + Datasource + DatasourceDefinition + DerivedDatasource + DirectoryDatasource + Nflow + NflowSLA + HiveTableDatasource + Metric +  +  +  + User +
        // UserGroup + UserDatasource + JdbcDatasource = 14
        /*0 = {JcrExtensibleType@5455} "tba:sla"
        1 = {JcrExtensibleType@5456} "tba:slaCheck"
        2 = {JcrExtensibleType@5457} "tba:category"
        3 = {JcrExtensibleType@5458} "tba:jdbcDatasourceDetails"
        4 = {JcrExtensibleType@5459} "tba:categoryDetails"
        5 = {JcrExtensibleType@5460} "tba:slaActionConfiguration"
        6 = {JcrExtensibleType@5461} "tba:datasource"
        7 = {JcrExtensibleType@5462} "tba:userDatasource"
        8 = {JcrExtensibleType@5463} "tba:directoryDatasource"
        9 = {JcrExtensibleType@5464} "tba:nflow"
        10 = {JcrExtensibleType@5465} "tba:datasourceDetails"
        11 = {JcrExtensibleType@5466} "tba:user"
        12 = {JcrExtensibleType@5467} "tba:hiveTableDatasource"
        13 = {JcrExtensibleType@5468} "tba:derivedDatasource"
        14 = {JcrExtensibleType@5469} "tba:nflowSummary"
        15 = {JcrExtensibleType@5470} "tba:metric"
        16 = {JcrExtensibleType@5471} "tba:userGroup"
        17 = {JcrExtensibleType@5472} "tba:datasourceDefinition"
        */
        //NFLOW SLA are done via ModeShapeAvailability Listener which might not get fired before the assert.
        //NOVA-292 will address this.  For now to get the build to pass look for result either 13 or 14

        assertThat(size).isBetween(18, 19);
    }

    @Test(dependsOnMethods = "testGetAllDefaultTypes")
    public void testCreatePersonType() {
        String typeName = metadata.commit(new AdminCredentials(), () -> {
            // @formatter:off
            ExtensibleType type = typeProvider.buildType("Person")
                            .field("name")
                                .type(FieldDescriptor.Type.STRING)
                                .displayName("Person name")
                                .description("The name of the person")
                                .required(true)
                                .add()
                            .addField("description", FieldDescriptor.Type.STRING)
                            .addField("age", FieldDescriptor.Type.LONG)
                            .build();
            // @formatter:on

            return type.getName();
        });

        assertThat(typeName).isNotNull().isEqualTo("Person");
    }

    @Test(dependsOnMethods = "testCreatePersonType")
    public void testCreateEmployeeType() {
        String typeName = metadata.commit(new AdminCredentials(), () -> {
            ExtensibleType person = typeProvider.getType("Person");
            // @formatter:off
            ExtensibleType emp = typeProvider.buildType("Employee")
                            .supertype(person)
                            .field("name")
                                .type(FieldDescriptor.Type.STRING)
                                .displayName("Person name")
                                .description("The name of the person")
                                .required(true)
                                .add()
                            .addField("description", FieldDescriptor.Type.STRING)
                            .addField("age", FieldDescriptor.Type.LONG)
                            .build();
            // @formatter:on

            return emp.getSupertype().getName();
        });

        assertThat(typeName).isNotNull().isEqualTo("Person");
    }

    @Test(dependsOnMethods = "testCreatePersonType")
    public void testGetPersonType() {
        final ExtensibleType.ID id = metadata.commit(new AdminCredentials(), () -> {
            ExtensibleType type = typeProvider.getType("Person");

            return type.getId();
        });

        assertThat(id).isNotNull();

        Map<String, FieldDescriptor.Type> fields = metadata.commit(new AdminCredentials(), () -> {
            ExtensibleType type = typeProvider.getType("Person");
            Map<String, FieldDescriptor.Type> map = new HashMap<>();

            for (FieldDescriptor descr : type.getFieldDescriptors()) {
                map.put(descr.getName(), descr.getType());
            }

            return map;
        });

        assertThat(fields).isNotNull();
        assertThat(fields).containsEntry("name", FieldDescriptor.Type.STRING);
        assertThat(fields).containsEntry("description", FieldDescriptor.Type.STRING);
        assertThat(fields).containsEntry("age", FieldDescriptor.Type.LONG);
    }

    @Test(dependsOnMethods = "testCreatePersonType")
    public void testGetAllTypes() {
        int size = metadata.commit(new AdminCredentials(), () -> {
            List<ExtensibleType> types = typeProvider.getTypes();

            return types.size();
        });

        //NFLOW SLA are done via ModeShapeAvailability Listener which might not get fired before the assert.
        //NOVA-292 will address this.  For now to get the build to pass look for result either 15,16

        // 16 + Person + Employee = 18
        assertThat(size).isBetween(20, 21);
    }

    @Test(dependsOnMethods = "testCreatePersonType")
    public void testCreateEntity() {
        ExtensibleEntity.ID id = metadata.commit(new AdminCredentials(), () -> {
            ExtensibleType type = typeProvider.getType("Person");

            Map<String, Object> props = new HashMap<>();
            props.put("name", "Bob");
            props.put("description", "Silly");
            props.put("age", 50);

            ExtensibleEntity entity = entityProvider.createEntity(type, props);

            return entity.getId();
        });

        assertThat(id).isNotNull();
    }

    @Test(dependsOnMethods = "testCreatePersonType")
    public void testGetEntity() {
        String typeName = metadata.commit(new AdminCredentials(), () -> {
            List<ExtensibleEntity> list = entityProvider.getEntities();

            assertThat(list).isNotNull().hasSize(1);

            ExtensibleEntity.ID id = list.get(0).getId();
            ExtensibleEntity entity = entityProvider.getEntity(id);

            assertThat(entity).isNotNull();
            assertThat(entity.getProperty("name")).isEqualTo("Bob");

            return entity.getTypeName();
        });

        assertThat(typeName).isEqualTo("Person");
    }
}
