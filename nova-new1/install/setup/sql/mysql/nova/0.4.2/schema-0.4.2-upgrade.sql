SET SQL_MODE='ALLOW_INVALID_DATES';
use nova;
ALTER DATABASE nova CHARACTER SET utf8 COLLATE utf8_general_ci;
ALTER TABLE BATCH_JOB_EXECUTION_CONTEXT MODIFY SERIALIZED_CONTEXT LONGTEXT;
ALTER TABLE BATCH_STEP_EXECUTION_CONTEXT MODIFY SERIALIZED_CONTEXT LONGTEXT;
ALTER TABLE BATCH_JOB_INSTANCE CHANGE COLUMN `JOB_NAME` `JOB_NAME` VARCHAR(255) NOT NULL;
ALTER TABLE NIFI_NFLOW_PROCESSOR_STATS CHANGE COLUMN `FM_NFLOW_NAME` `FM_NFLOW_NAME` VARCHAR(255) NOT NULL;