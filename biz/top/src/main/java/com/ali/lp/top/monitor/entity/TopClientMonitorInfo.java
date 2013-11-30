package com.ali.lp.top.monitor.entity;

import java.util.Date;

public class TopClientMonitorInfo {
    private long id=24234;
    private String beforeCheckFlag="check";
    private String checkResult="调用失败";
    private Date invokeStartDate=new Date();
    private Date invokeEndDate=new Date();
    private String topUrl="http://www.alibaba-inc.com/invoke/0/";
    private String appKey="345322r534";
    private String secret="gsggfs34534dfsfgrex";
    private String invokeApi="TradesSoldIncrementGetResponse";
    private String successFlag="OK";
    private String errorCode="99999";
    private String errorMsg="接口失败";
    private String subErrorCode="2423432";
    private String subErrorMsg="接口失败";
    private String paramIn="453;jj;kljrg;lj3453;25j23jkl3245j23;234;k5j32;52;35;235";
    private String paramQuery="345rj;3jk;ldfj;lawrpuqpoituwperifsdz;kmzxcvk;jlajfssldf";
    private String outputResult="2423;jkperwuiods;fjjrqpro";
    private String memo="3234242424";
    
    public TopClientMonitorInfo() {
        super();
    }
    
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getBeforeCheckFlag() {
        return beforeCheckFlag;
    }
    public void setBeforeCheckFlag(String beforeCheckFlag) {
        this.beforeCheckFlag = beforeCheckFlag;
    }
    public String getCheckResult() {
        return checkResult;
    }
    public void setCheckResult(String checkResult) {
        this.checkResult = checkResult;
    }
    public Date getInvokeStartDate() {
        return invokeStartDate;
    }
    public void setInvokeStartDate(Date invokeStartDate) {
        this.invokeStartDate = invokeStartDate;
    }
    public Date getInvokeEndDate() {
        return invokeEndDate;
    }
    public void setInvokeEndDate(Date invokeEndDate) {
        this.invokeEndDate = invokeEndDate;
    }
    public String getTopUrl() {
        return topUrl;
    }
    public void setTopUrl(String topUrl) {
        this.topUrl = topUrl;
    }
    public String getAppKey() {
        return appKey;
    }
    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }
    public String getSecret() {
        return secret;
    }
    public void setSecret(String secret) {
        this.secret = secret;
    }
    public String getInvokeApi() {
        return invokeApi;
    }
    public void setInvokeApi(String invokeApi) {
        this.invokeApi = invokeApi;
    }
    public String getSuccessFlag() {
        return successFlag;
    }
    public void setSuccessFlag(String successFlag) {
        this.successFlag = successFlag;
    }
    public String getErrorCode() {
        return errorCode;
    }
    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }
    public String getErrorMsg() {
        return errorMsg;
    }
    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
    public String getSubErrorCode() {
        return subErrorCode;
    }
    public void setSubErrorCode(String subErrorCode) {
        this.subErrorCode = subErrorCode;
    }
    public String getSubErrorMsg() {
        return subErrorMsg;
    }
    public void setSubErrorMsg(String subErrorMsg) {
        this.subErrorMsg = subErrorMsg;
    }
    public String getParamIn() {
        return paramIn;
    }
    public void setParamIn(String paramIn) {
        this.paramIn = paramIn;
    }
    public String getParamQuery() {
        return paramQuery;
    }
    public void setParamQuery(String paramQuery) {
        this.paramQuery = paramQuery;
    }
    public String getOutputResult() {
        return outputResult;
    }
    public void setOutputResult(String outputResult) {
        this.outputResult = outputResult;
    }
    public String getMemo() {
        return memo;
    }
    public void setMemo(String memo) {
        this.memo = memo;
    }

	@Override
	public String toString() {
		return String
				.format("TopClientMonitorInfo [id=%s, beforeCheckFlag=%s, checkResult=%s, invokeStartDate=%s, invokeEndDate=%s, topUrl=%s, appKey=%s, secret=%s, invokeApi=%s, successFlag=%s, errorCode=%s, errorMsg=%s, subErrorCode=%s, subErrorMsg=%s, paramIn=%s, paramQuery=%s, outputResult=%s, memo=%s]",
						id, beforeCheckFlag, checkResult, invokeStartDate,
						invokeEndDate, topUrl, appKey, secret, invokeApi,
						successFlag, errorCode, errorMsg, subErrorCode,
						subErrorMsg, paramIn, paramQuery, outputResult, memo);
	}


    
    
    
}
