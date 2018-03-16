-- -
-- #%L
-- nova-service-app
-- %%
-- Copyright (C) 2017 Onescorpin
-- %%
-- Licensed under the Apache License, Version 2.0 (the "License");
-- you may not use this file except in compliance with the License.
-- You may obtain a copy of the License at
--
--     http://www.apache.org/licenses/LICENSE-2.0
--
-- Unless required by applicable law or agreed to in writing, software
-- distributed under the License is distributed on an "AS IS" BASIS,
-- WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
-- See the License for the specific language governing permissions and
-- limitations under the License.
-- #L%
-- -

CREATE PROCEDURE [dbo].[delete_nflow_jobs](@category varchar(255), @nflow varchar(255), @result integer)
AS

DECLARE @jobName VARCHAR(255) = CONCAT(@category,'.',@nflow);

DELETE BATCH_NIFI_STEP
FROM BATCH_NIFI_STEP
 INNER JOIN BATCH_STEP_EXECUTION ON BATCH_NIFI_STEP.STEP_EXECUTION_ID = BATCH_STEP_EXECUTION.STEP_EXECUTION_ID
 INNER JOIN BATCH_JOB_EXECUTION ON BATCH_STEP_EXECUTION.JOB_EXECUTION_ID = BATCH_JOB_EXECUTION.JOB_EXECUTION_ID
 INNER JOIN BATCH_JOB_INSTANCE ON BATCH_JOB_INSTANCE.JOB_INSTANCE_ID = BATCH_JOB_EXECUTION.JOB_INSTANCE_ID
WHERE BATCH_JOB_INSTANCE.JOB_NAME = @jobName;

DELETE BATCH_NIFI_JOB
FROM BATCH_NIFI_JOB
 INNER JOIN BATCH_JOB_EXECUTION ON BATCH_NIFI_JOB.JOB_EXECUTION_ID = BATCH_JOB_EXECUTION.JOB_EXECUTION_ID
 INNER JOIN BATCH_JOB_INSTANCE ON BATCH_JOB_EXECUTION.JOB_INSTANCE_ID = BATCH_JOB_INSTANCE.JOB_INSTANCE_ID
WHERE BATCH_JOB_INSTANCE.JOB_NAME = @jobName;

DELETE BATCH_EXECUTION_CONTEXT_VALUES
FROM BATCH_EXECUTION_CONTEXT_VALUES
 INNER JOIN BATCH_STEP_EXECUTION ON BATCH_EXECUTION_CONTEXT_VALUES.STEP_EXECUTION_ID = BATCH_STEP_EXECUTION.STEP_EXECUTION_ID
 INNER JOIN BATCH_JOB_EXECUTION ON BATCH_STEP_EXECUTION.JOB_EXECUTION_ID = BATCH_JOB_EXECUTION.JOB_EXECUTION_ID
 INNER JOIN BATCH_JOB_INSTANCE ON BATCH_JOB_EXECUTION.JOB_INSTANCE_ID = BATCH_JOB_INSTANCE.JOB_INSTANCE_ID
WHERE BATCH_JOB_INSTANCE.JOB_NAME = @jobName;

DELETE BATCH_STEP_EXECUTION_CTX_VALS
FROM BATCH_STEP_EXECUTION_CTX_VALS
 INNER JOIN BATCH_STEP_EXECUTION ON BATCH_STEP_EXECUTION_CTX_VALS.STEP_EXECUTION_ID = BATCH_STEP_EXECUTION.STEP_EXECUTION_ID
 INNER JOIN BATCH_JOB_EXECUTION ON BATCH_STEP_EXECUTION.JOB_EXECUTION_ID = BATCH_JOB_EXECUTION.JOB_EXECUTION_ID
 INNER JOIN BATCH_JOB_INSTANCE ON BATCH_JOB_EXECUTION.JOB_INSTANCE_ID = BATCH_JOB_INSTANCE.JOB_INSTANCE_ID
WHERE BATCH_JOB_INSTANCE.JOB_NAME = @jobName;


 DELETE BATCH_STEP_EXECUTION
FROM BATCH_STEP_EXECUTION
 INNER JOIN BATCH_JOB_EXECUTION ON BATCH_STEP_EXECUTION.JOB_EXECUTION_ID = BATCH_JOB_EXECUTION.JOB_EXECUTION_ID
 INNER JOIN BATCH_JOB_INSTANCE ON BATCH_JOB_EXECUTION.JOB_INSTANCE_ID = BATCH_JOB_INSTANCE.JOB_INSTANCE_ID
WHERE BATCH_JOB_INSTANCE.JOB_NAME = @jobName;

DELETE BATCH_JOB_EXECUTION_CTX_VALS
FROM BATCH_JOB_EXECUTION_CTX_VALS
 INNER JOIN BATCH_JOB_EXECUTION ON BATCH_JOB_EXECUTION_CTX_VALS.JOB_EXECUTION_ID = BATCH_JOB_EXECUTION.JOB_EXECUTION_ID
 INNER JOIN BATCH_JOB_INSTANCE ON BATCH_JOB_EXECUTION.JOB_INSTANCE_ID = BATCH_JOB_INSTANCE.JOB_INSTANCE_ID
WHERE BATCH_JOB_INSTANCE.JOB_NAME = @jobName;


DELETE BATCH_JOB_EXECUTION_PARAMS
FROM BATCH_JOB_EXECUTION_PARAMS
 INNER JOIN BATCH_JOB_EXECUTION ON BATCH_JOB_EXECUTION_PARAMS.JOB_EXECUTION_ID = BATCH_JOB_EXECUTION.JOB_EXECUTION_ID
 INNER JOIN BATCH_JOB_INSTANCE ON BATCH_JOB_EXECUTION.JOB_INSTANCE_ID = BATCH_JOB_INSTANCE.JOB_INSTANCE_ID
WHERE BATCH_JOB_INSTANCE.JOB_NAME = @jobName;

DELETE BATCH_JOB_EXECUTION
FROM BATCH_JOB_EXECUTION
INNER JOIN BATCH_JOB_INSTANCE ON BATCH_JOB_EXECUTION.JOB_INSTANCE_ID = BATCH_JOB_INSTANCE.JOB_INSTANCE_ID
WHERE BATCH_JOB_INSTANCE.JOB_NAME = @jobName;

DELETE FROM BATCH_JOB_INSTANCE
WHERE BATCH_JOB_INSTANCE.JOB_NAME = @jobName;

DELETE x FROM NIFI_RELATED_ROOT_FLOW_FILES x
WHERE x.FLOW_FILE_ID in (SELECT NIFI_EVENT.FLOW_FILE_ID
FROM NIFI_EVENT
WHERE NIFI_EVENT.FM_NFLOW_NAME = @jobName);

DELETE x FROM NIFI_RELATED_ROOT_FLOW_FILES x
WHERE x.EVENT_FLOW_FILE_ID in (SELECT NIFI_EVENT.FLOW_FILE_ID
FROM NIFI_EVENT
WHERE NIFI_EVENT.FM_NFLOW_NAME = @jobName);

DELETE FROM NIFI_EVENT
WHERE FM_NFLOW_NAME = @jobName;

DELETE FROM NIFI_NFLOW_PROCESSOR_STATS
WHERE FM_NFLOW_NAME = @jobName;
