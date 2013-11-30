package com.ali.lp.top.entity;

import java.io.Serializable;
import java.util.Date;

//@Entity
public class InvokeLog implements Serializable{
    private static final long serialVersionUID = 4486486714558868484L;
//    private long id;
    private int beforeCheckFlag;
    private String beforeCheckResult;
    private Date startTime;
    private Date endTime;
    private String invokeApi;
    private int successFlag;
    private String invokeHostName;
    private Date createDate;
    private Date lastModifyDate;
    private long successInvokeTimes;
    private String memo;
    private String invokeSource;
    
    private String errorCode;
    private String errorInfo;
    private String subErrorCode;
    private String subErrorInfo;
    private String inputParam;
    private String queryParam;
    private String outputResult;
    
//    public long getId() {
//        return id;
//    }
//    public void setId(long id) {
//        this.id = id;
//    }
    public int getBeforeCheckFlag() {
        return beforeCheckFlag;
    }
    public void setBeforeCheckFlag(int beforeCheckFlag) {
        this.beforeCheckFlag = beforeCheckFlag;
    }
    public String getBeforeCheckResult() {
        return beforeCheckResult;
    }
    public void setBeforeCheckResult(String beforeCheckResult) {
        this.beforeCheckResult = beforeCheckResult;
    }
    public Date getStartTime() {
        return startTime;
    }
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }
    public Date getEndTime() {
        return endTime;
    }
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
    public String getInvokeApi() {
        return invokeApi;
    }
    public void setInvokeApi(String invokeApi) {
        this.invokeApi = invokeApi;
    }
    public int getSuccessFlag() {
        return successFlag;
    }
    public void setSuccessFlag(int successFlag) {
        this.successFlag = successFlag;
    }
    public String getInvokeHostName() {
        return invokeHostName;
    }
    public void setInvokeHostName(String invokeHostName) {
        this.invokeHostName = invokeHostName;
    }
    public Date getCreateDate() {
        return createDate;
    }
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
    public Date getLastModifyDate() {
        return lastModifyDate;
    }
    public void setLastModifyDate(Date lastModifyDate) {
        this.lastModifyDate = lastModifyDate;
    }
    public long getSuccessInvokeTimes() {
        return successInvokeTimes;
    }
    public void setSuccessInvokeTimes(long successInvokeTimes) {
        this.successInvokeTimes = successInvokeTimes;
    }
    public String getMemo() {
        return memo;
    }
    public void setMemo(String memo) {
        this.memo = memo;
    }
    public String getInvokeSource() {
        return invokeSource;
    }
    public void setInvokeSource(String invokeSource) {
        this.invokeSource = invokeSource;
    }
    public String getErrorCode() {
        return errorCode;
    }
    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }
    public String getErrorInfo() {
        return errorInfo;
    }
    public void setErrorInfo(String errorInfo) {
        this.errorInfo = errorInfo;
    }
    public String getSubErrorCode() {
        return subErrorCode;
    }
    public void setSubErrorCode(String subErrorCode) {
        this.subErrorCode = subErrorCode;
    }
    public String getSubErrorInfo() {
        return subErrorInfo;
    }
    public void setSubErrorInfo(String subErrorInfo) {
        this.subErrorInfo = subErrorInfo;
    }
    public String getInputParam() {
        return inputParam;
    }
    public void setInputParam(String inputParam) {
        this.inputParam = inputParam;
    }
    public String getQueryParam() {
        return queryParam;
    }
    public void setQueryParam(String queryParam) {
        this.queryParam = queryParam;
    }
    public String getOutputResult() {
        return outputResult;
    }
    public void setOutputResult(String outputResult) {
        this.outputResult = outputResult;
    }
}
