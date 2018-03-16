package com.onescorpin.scheduler;

/*-
 * #%L
 * onescorpin-scheduler-quartz
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

/**
 * The type of Cluster message to send to the other nova nodes
 */
public class QuartzClusterMessage {
    public enum QUARTZ_CLUSTER_MESSAGE_TYPE {
       QTZ_SCHEDULER_PAUSED,QTZ_SCHEDULER_RESUMED,QTZ_JOB_PAUSED,QTZ_JOB_RESUMED;
    }
}