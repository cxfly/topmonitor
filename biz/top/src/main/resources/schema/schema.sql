-- Create table
create table WL_TOP_INVOKE_ERROR_LOG
(
  id                NUMBER(18) not null,
  before_check_flag VARCHAR2(64),
  check_result      VARCHAR2(64),
  invoke_start_date DATE,
  invoke_end_date   DATE,
  top_url           VARCHAR2(128),
  app_key           VARCHAR2(64),
  secret            VARCHAR2(256),
  invoke_api        VARCHAR2(128),
  success_flag      VARCHAR2(32),
  error_code        VARCHAR2(128),
  error_msg         VARCHAR2(128),
  sub_error_code    VARCHAR2(128),
  sub_error_msg     VARCHAR2(128),
  param_in          VARCHAR2(128),
  paramquery        VARCHAR2(256),
  output_result     VARCHAR2(256),
  memo              VARCHAR2(128)
);
-- Create/Recreate primary, unique and foreign key constraints 
alter table WL_TOP_INVOKE_ERROR_LOG
  add constraint PK_WL_TOP_INVOKE_ERROR_LOG primary key (ID)
  using index ;

  
  -- Create table
create table WL_TOP_INVOKE_SUCCESS_LOG
(
  id               NUMBER(18) not null,
  api_name         VARCHAR2(128),
  times            NUMBER(18),
  last_modify_date DATE,
  create_date      DATE
);
-- Create/Recreate primary, unique and foreign key constraints 
alter table WL_TOP_INVOKE_SUCCESS_LOG
  add constraint PK_WL_TOP_INVOKE_SUCCESS_LOG primary key (ID)
  using index ;

-- Create sequence  
create sequence WL_TOP_INVOKE_ERROR_LOG_SEQ;
create sequence WL_TOP_INVOKE_SUCCESS_LOG_SEQ;