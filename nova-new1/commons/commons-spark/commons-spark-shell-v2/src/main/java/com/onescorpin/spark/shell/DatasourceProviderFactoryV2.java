package com.onescorpin.spark.shell;

/*-
 * #%L
 * Nova Commons Spark Shell for Spark 2
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

import com.onescorpin.spark.rest.model.Datasource;

import org.springframework.stereotype.Component;

import java.util.Collection;

import javax.annotation.Nonnull;

/**
 * A data source provider factory for Spark 2.
 */
@Component
@SuppressWarnings("unused")
public class DatasourceProviderFactoryV2 implements DatasourceProviderFactory {

    @Override
    public DatasourceProvider getDatasourceProvider(@Nonnull final Collection<Datasource> datasources) {
        return new DatasourceProviderV2(datasources);
    }
}
