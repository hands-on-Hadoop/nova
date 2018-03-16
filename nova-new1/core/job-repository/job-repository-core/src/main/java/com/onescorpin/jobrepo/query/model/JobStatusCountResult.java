package com.onescorpin.jobrepo.query.model;

/*-
 * #%L
 * onescorpin-job-repository-core
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

import java.util.Date;

/**
 * Job status counts object
 *
 * @see com.onescorpin.jobrepo.query.model.transform.JobStatusTransform
 */
public class JobStatusCountResult implements JobStatusCount {

    private String nflowId;
    private String nflowName;
    private String jobName;
    private String status;
    private Date date;
    private Long count;

    public JobStatusCountResult() {

    }

    public JobStatusCountResult(JobStatusCount jobStatusCount) {
        this.nflowId = jobStatusCount.getNflowId();
        this.nflowName = jobStatusCount.getNflowName();
        this.jobName = jobStatusCount.getJobName();
        this.status = jobStatusCount.getStatus();
        this.date = jobStatusCount.getDate();
        this.count = jobStatusCount.getCount();
    }

    @Override
    public Long getCount() {
        return count;
    }

    @Override
    public void setCount(Long count) {
        this.count = count;
    }

    @Override
    public String getNflowName() {
        return nflowName;
    }

    @Override
    public void setNflowName(String nflowName) {
        this.nflowName = nflowName;
    }

    @Override
    public String getJobName() {
        return jobName;
    }

    @Override
    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    @Override
    public String getStatus() {
        return status;
    }

    @Override
    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public Date getDate() {
        return date;
    }

    @Override
    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String getNflowId() {
        return nflowId;
    }

    @Override
    public void setNflowId(String nflowId) {
        this.nflowId = nflowId;
    }
}
