package com.ali.lp.top.dao;

import com.ali.lp.base.dao.BaseDao;

public interface TopInvokeErrorLogDao <T> extends BaseDao<T>{

    public long getTopInvokeErrorRowCount();

}
