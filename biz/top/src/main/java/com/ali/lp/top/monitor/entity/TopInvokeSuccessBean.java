package com.ali.lp.top.monitor.entity;

import java.util.Date;

public class TopInvokeSuccessBean {
    private String apiName;
    private long   times;
    private Date   lastModifyDate;

	public TopInvokeSuccessBean(String apiName, long times, Date lastModifyDate) {
        super();
        this.apiName = apiName;
        this.times = times;
        this.lastModifyDate = lastModifyDate;
    }

    public TopInvokeSuccessBean() {
        super();
    }

    public String getApiName() {
        return apiName;
    }

    public void setApiName(String apiName) {
        this.apiName = apiName;
    }

    public long getTimes() {
        return times;
    }

    public void setTimes(long times) {
        this.times = times;
    }

    public Date getLastModifyDate() {
        return lastModifyDate;
    }

    public void setLastModifyDate(Date lastModifyDate) {
        this.lastModifyDate = lastModifyDate;
    }
    
    public long addSuccessTimes(Date date) {
        this.times += 1;
        this.lastModifyDate = date;
        return this.times;
    }
    
    @Override
	public String toString() {
		return String
				.format("TopInvokeSuccessBean ++OKKK++ [apiName=%s, times=%s, lastModifyDate=%s]",
						apiName, times, lastModifyDate);
	}
}
