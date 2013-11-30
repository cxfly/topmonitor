package com.ali.lp.top.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="WL_TOP_INVOKE_ERROR_LOG")
public class TopInvokeErrorLog implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="WL_TOP_INVOKE_ERROR_LOG_ID_GENERATOR", sequenceName="WL_TOP_INVOKE_ERROR_LOG_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="WL_TOP_INVOKE_ERROR_LOG_ID_GENERATOR")
	private long id;

	@Column(name="APP_KEY")
	private String appKey;

	@Column(name="BEFORE_CHECK_FLAG")
	private String beforeCheckFlag;

	@Column(name="CHECK_RESULT")
	private String checkResult;

	@Column(name="ERROR_CODE")
	private String errorCode;

	@Column(name="ERROR_MSG")
	private String errorMsg;

	@Column(name="INVOKE_API")
	private String invokeApi;

    @Temporal( TemporalType.TIMESTAMP)
	@Column(name="INVOKE_END_DATE")
	private Date invokeEndDate;

    @Temporal( TemporalType.TIMESTAMP)
	@Column(name="INVOKE_START_DATE")
	private Date invokeStartDate;

	private String memo;

	@Column(name="OUTPUT_RESULT")
	private String outputResult;

	@Column(name="PARAM_IN")
	private String paramIn;

	private String paramquery;

	private String secret;

	@Column(name="SUB_ERROR_CODE")
	private String subErrorCode;

	@Column(name="SUB_ERROR_MSG")
	private String subErrorMsg;

	@Column(name="SUCCESS_FLAG")
	private String successFlag;

	@Column(name="TOP_URL",columnDefinition="VARCHAR2(32) default 'OK' not null", nullable=true)
	private String topUrl;
	

    public TopInvokeErrorLog() {
    }

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAppKey() {
		return this.appKey;
	}

	public void setAppKey(String appKey) {
		this.appKey = appKey;
	}

	public String getBeforeCheckFlag() {
		return this.beforeCheckFlag;
	}

	public void setBeforeCheckFlag(String beforeCheckFlag) {
		this.beforeCheckFlag = beforeCheckFlag;
	}

	public String getCheckResult() {
		return this.checkResult;
	}

	public void setCheckResult(String checkResult) {
		this.checkResult = checkResult;
	}

	public String getErrorCode() {
		return this.errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMsg() {
		return this.errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public String getInvokeApi() {
		return this.invokeApi;
	}

	public void setInvokeApi(String invokeApi) {
		this.invokeApi = invokeApi;
	}

	public Date getInvokeEndDate() {
		return this.invokeEndDate;
	}

	public void setInvokeEndDate(Date invokeEndDate) {
		this.invokeEndDate = invokeEndDate;
	}

	public Date getInvokeStartDate() {
		return this.invokeStartDate;
	}

	public void setInvokeStartDate(Date invokeStartDate) {
		this.invokeStartDate = invokeStartDate;
	}

	public String getMemo() {
		return this.memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getOutputResult() {
		return this.outputResult;
	}

	public void setOutputResult(String outputResult) {
		this.outputResult = outputResult;
	}

	public String getParamIn() {
		return this.paramIn;
	}

	public void setParamIn(String paramIn) {
		this.paramIn = paramIn;
	}

	public String getParamquery() {
		return this.paramquery;
	}

	public void setParamquery(String paramquery) {
		this.paramquery = paramquery;
	}

	public String getSecret() {
		return this.secret;
	}

	public void setSecret(String secret) {
		this.secret = secret;
	}

	public String getSubErrorCode() {
		return this.subErrorCode;
	}

	public void setSubErrorCode(String subErrorCode) {
		this.subErrorCode = subErrorCode;
	}

	public String getSubErrorMsg() {
		return this.subErrorMsg;
	}

	public void setSubErrorMsg(String subErrorMsg) {
		this.subErrorMsg = subErrorMsg;
	}

	public String getSuccessFlag() {
		return this.successFlag;
	}

	public void setSuccessFlag(String successFlag) {
		this.successFlag = successFlag;
	}

	public String getTopUrl() {
		return this.topUrl;
	}

	public void setTopUrl(String topUrl) {
		this.topUrl = topUrl;
	}


}