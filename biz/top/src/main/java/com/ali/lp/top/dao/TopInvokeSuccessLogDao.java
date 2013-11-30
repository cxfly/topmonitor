package com.ali.lp.top.dao;

import java.util.Date;

import com.ali.lp.base.dao.BaseDao;

public interface TopInvokeSuccessLogDao<T> extends BaseDao<T> {

    public int updateSuccessLog(String apiName, Date lastUpdateDate, long times);

    public long getTopInvokeSuccessRowCount();
}
