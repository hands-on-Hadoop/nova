package com.onescorpin.metadata.core.category;

/*-
 * #%L
 * onescorpin-metadata-core
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

import com.onescorpin.metadata.api.category.Category;
import com.onescorpin.metadata.api.extension.UserFieldDescriptor;
import com.onescorpin.metadata.api.nflow.Nflow;
import com.onescorpin.metadata.api.security.HadoopSecurityGroup;
import com.onescorpin.metadata.api.security.RoleMembership;
import com.onescorpin.security.action.AllowedActions;

import org.joda.time.DateTime;

import java.io.Serializable;
import java.security.Principal;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

import javax.annotation.Nonnull;

/**
 * A POJO implementation of {@link Category}.
 */
public class BaseCategory implements Category {

    private CategoryId id;

    private List<Nflow> nflows;

    private String displayName;

    private String systemName;

    private String description;

    private Integer version;

    private DateTime createdTime;

    private DateTime modifiedTime;

    private Principal owner;

    private List<? extends HadoopSecurityGroup> hadoopSecurityGroups;

    /**
     * User-defined properties
     */
    private Map<String, String> userProperties;

    @Override
    public CategoryId getId() {
        return id;
    }

    public void setId(CategoryId id) {
        this.id = id;
    }

    @Override
    public List<Nflow> getNflows() {
        return nflows;
    }

    public void setNflows(List<Nflow> nflows) {
        this.nflows = nflows;
    }

    @Override
    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String getSystemName() {
        return systemName;
    }

    @Override
    public void setSystemName(String systemName) {
        this.systemName = systemName;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    @Override
    public List<? extends HadoopSecurityGroup> getSecurityGroups() {
        return this.hadoopSecurityGroups;
    }

    @Override
    public void setSecurityGroups(List<? extends HadoopSecurityGroup> securityGroups) {
        hadoopSecurityGroups = securityGroups;
    }

    @Override
    public DateTime getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(DateTime createdTime) {
        this.createdTime = createdTime;
    }

    @Override
    public DateTime getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(DateTime modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    @Nonnull
    @Override
    public Map<String, String> getUserProperties() {
        return userProperties;
    }

    @Override
    public void setUserProperties(@Nonnull Map<String, String> userProperties, @Nonnull Set<UserFieldDescriptor> userFields) {
        this.userProperties = userProperties;
    }

    @Override
    public AllowedActions getAllowedActions() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Set<RoleMembership> getRoleMemberships() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Optional<RoleMembership> getRoleMembership(String roleName) {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see com.onescorpin.metadata.api.security.AccessControlled#getInheritedRoleMemberships()
     */
    @Override
    public Set<RoleMembership> getInheritedRoleMemberships() {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see com.onescorpin.metadata.api.security.AccessControlled#getInheritedRoleMembership(java.lang.String)
     */
    @Override
    public Optional<RoleMembership> getInheritedRoleMembership(String roleName) {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see com.onescorpin.metadata.api.category.Category#getNflowRoleMemberships()
     */
    @Override
    public Set<RoleMembership> getNflowRoleMemberships() {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see com.onescorpin.metadata.api.category.Category#getNflowRoleMembership(java.lang.String)
     */
    @Override
    public Optional<RoleMembership> getNflowRoleMembership(String roleName) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getIcon() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setIcon(String icon) {
        // TODO Auto-generated method stub

    }

    @Override
    public String getIconColor() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setIconColor(String iconColor) {
        // TODO Auto-generated method stub

    }

    @Override
    public Principal getOwner() {
        return owner;
    }

    public void setOwner(Principal owner) {
        this.owner = owner;
    }

    private static class BaseId {

        private final UUID uuid;

        public BaseId() {
            this.uuid = UUID.randomUUID();
        }

        public BaseId(Serializable ser) {
            if (ser instanceof String) {
                this.uuid = UUID.fromString((String) ser);
            } else if (ser instanceof UUID) {
                this.uuid = (UUID) ser;
            } else {
                throw new IllegalArgumentException("Unknown ID value: " + ser);
            }
        }

        @Override
        public boolean equals(Object obj) {
            if (getClass().isAssignableFrom(obj.getClass())) {
                BaseId that = (BaseId) obj;
                return Objects.equals(this.uuid, that.uuid);
            } else {
                return false;
            }
        }

        @Override
        public int hashCode() {
            return Objects.hash(getClass(), this.uuid);
        }

        @Override
        public String toString() {
            return this.uuid.toString();
        }
    }

    protected static class CategoryId extends BaseId implements Category.ID {

        public CategoryId() {
            super();
        }

        public CategoryId(Serializable ser) {
            super(ser);
        }
    }
}
