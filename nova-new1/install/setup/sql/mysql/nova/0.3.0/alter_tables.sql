ALTER TABLE `nova`.`BATCH_EXECUTION_CONTEXT_VALUES`
CHANGE COLUMN `STRING_VAL` `STRING_VAL` LONGTEXT NULL DEFAULT NULL COMMENT '' ;


ALTER TABLE nova.BATCH_JOB_EXECUTION_PARAMS CHANGE COLUMN STRING_VAL STRING_VAL VARCHAR(250) NULL DEFAULT NULL ;
