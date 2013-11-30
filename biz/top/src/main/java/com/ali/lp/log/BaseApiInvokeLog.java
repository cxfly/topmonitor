package com.ali.lp.log;

import java.io.Serializable;
import java.util.Date;

/**
 * 日志基类
 * TODO Comment of BaseApiInvokeLog
 * @author wb_zhe.liz
 *
 */
public abstract class BaseApiInvokeLog implements Serializable{
    private static final long serialVersionUID = 4399822194061888576L;
    
    private long id;
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
    
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
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
	@Override
	public String toString() {
		return String
				.format("BaseApiInvokeLog [id=%s, beforeCheckFlag=%s, beforeCheckResult=%s, startTime=%s, endTime=%s, invokeApi=%s, successFlag=%s, invokeHostName=%s, createDate=%s, lastModifyDate=%s, successInvokeTimes=%s, memo=%s, invokeSource=%s]",
						id, beforeCheckFlag, beforeCheckResult, startTime,
						endTime, invokeApi, successFlag, invokeHostName,
						createDate, lastModifyDate, successInvokeTimes, memo,
						invokeSource);
	}
}
