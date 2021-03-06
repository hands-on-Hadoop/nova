package com.onescorpin.nflowmgr.service.category;

/*-
 * #%L
 * onescorpin-nflow-manager-core
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

import com.onescorpin.nflowmgr.rest.model.NflowCategory;
import com.onescorpin.nflowmgr.service.UserPropertyTransform;
import com.onescorpin.metadata.api.category.Category;
import com.onescorpin.metadata.api.category.CategoryProvider;
import com.onescorpin.metadata.api.security.HadoopSecurityGroup;
import com.onescorpin.metadata.api.security.HadoopSecurityGroupProvider;

import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.inject.Inject;

/**
 * Transforms categories between Nflow Manager and Metadata formats.
 */
public class SimpleCategoryModelTransform {

    /**
     * Provider for categories
     */
    @Inject
    protected CategoryProvider categoryProvider;

    @Inject
    protected HadoopSecurityGroupProvider hadoopSecurityGroupProvider;


    /**
     * Transforms the specified Metadata category to a simple Nflow Manager category.
     *
     * @param domainCategory the Metadata category
     * @return the Nflow Manager category
     */
    @Nullable
    public NflowCategory domainToNflowCategorySimple(@Nullable final Category domainCategory, boolean includeProperties, boolean includeSecurityGroups) {
        if (domainCategory != null) {
            NflowCategory category = new NflowCategory();
            category.setId(domainCategory.getId().toString());
            category.setIconColor(domainCategory.getIconColor());
            category.setIcon(domainCategory.getIcon());
            category.setName(domainCategory.getDisplayName());
            category.setSystemName(domainCategory.getSystemName() == null ? domainCategory.getDisplayName() : domainCategory.getSystemName()); //in pre-0.8.4 version of Nova there was no system name stored for domain categories
            category.setDescription(domainCategory.getDescription());
            category.setCreateDate(domainCategory.getCreatedTime() != null ? domainCategory.getCreatedTime().toDate() : null);
            category.setUpdateDate(domainCategory.getModifiedTime() != null ? domainCategory.getModifiedTime().toDate() : null);

            if(includeProperties){
                // Transform user-defined fields and properties
                category.setUserFields(UserPropertyTransform.toUserFields(categoryProvider.getNflowUserFields(domainCategory.getId()).orElse(Collections.emptySet())));
                category.setUserProperties(UserPropertyTransform.toUserProperties(domainCategory.getUserProperties(),  categoryProvider.getUserFields()));

            }

            if(includeSecurityGroups){
                // Convert JCR securitygroup to DTO
                List<com.onescorpin.nflowmgr.rest.model.HadoopSecurityGroup> restSecurityGroups = new ArrayList<>();
                if (domainCategory.getSecurityGroups() != null && domainCategory.getSecurityGroups().size() > 0) {
                    for (Object group : domainCategory.getSecurityGroups()) {
                        HadoopSecurityGroup hadoopSecurityGroup = (HadoopSecurityGroup) group;
                        com.onescorpin.nflowmgr.rest.model.HadoopSecurityGroup restSecurityGroup = new com.onescorpin.nflowmgr.rest.model.HadoopSecurityGroup();
                        restSecurityGroup.setDescription(hadoopSecurityGroup.getDescription());
                        restSecurityGroup.setId(hadoopSecurityGroup.getGroupId());
                        restSecurityGroup.setName(hadoopSecurityGroup.getName());
                        restSecurityGroups.add(restSecurityGroup);
                    }
                }
                category.setSecurityGroups(restSecurityGroups);
            }
            return category;
        } else {
            return null;
        }
    }

    /**
     * Transforms the specified Metadata categories to simple Nflow Manager categories.
     *
     * @param domain the Metadata categories
     * @return the Nflow Manager categories
     */
    @Nonnull
    public List<NflowCategory> domainToNflowCategorySimple(@Nonnull final Collection<Category> domain, boolean includeProperties, boolean includeSecurityGroups) {
        return domain.stream().map(c -> domainToNflowCategorySimple(c,includeProperties,includeSecurityGroups)).collect(Collectors.toList());
    }

}
