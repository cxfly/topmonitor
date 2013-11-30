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
@Table(name="WL_TOP_INVOKE_SUCCESS_LOG")
public class TopInvokeSuccessLog implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="WL_TOP_INVOKE_SUCCESS_LOG_ID_GENERATOR", sequenceName="WL_TOP_INVOKE_SUCCESS_LOG_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="WL_TOP_INVOKE_SUCCESS_LOG_ID_GENERATOR")
	private long id;

	@Column(name="API_NAME")
	private String apiName;

    @Temporal( TemporalType.TIMESTAMP)
	@Column(name="CREATE_DATE")
	private Date createDate;

    @Temporal( TemporalType.TIMESTAMP)
	@Column(name="LAST_MODIFY_DATE")
	private Date lastModifyDate;

	private long times;

    public TopInvokeSuccessLog() {
    }

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getApiName() {
		return this.apiName;
	}

	public void setApiName(String apiName) {
		this.apiName = apiName;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getLastModifyDate() {
		return this.lastModifyDate;
	}

	public void setLastModifyDate(Date lastModifyDate) {
		this.lastModifyDate = lastModifyDate;
	}

	public long getTimes() {
		return this.times;
	}

	public void setTimes(long times) {
		this.times = times;
	}

}