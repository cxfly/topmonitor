package com.ali.lp.top.hbm.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ali.lp.top.dao.TopInvokeErrorLogDao;
import com.ali.lp.top.entity.TopInvokeErrorLog;
import com.ali.lp.top.hbm.dao.BaseDaoHbm;


@Repository("topInvokeErrorLogDao")
public class TopInvokeErrorLogDaoImpl extends BaseDaoHbm<TopInvokeErrorLog> implements TopInvokeErrorLogDao<TopInvokeErrorLog> {
    @Override
    public long getTopInvokeErrorRowCount() {
        long result = 0;
        List<?> ls = this.getSession().createSQLQuery("select count(*) from wl_top_invoke_error_log t").list();
        if (ls!=null && ls.size()>0) {
            Object obj = ls.get(0);
            if (obj!=null) {
                result =  Long.parseLong(obj.toString());
            }
        }
        return result ;
    }

    @Override
    public TopInvokeErrorLog get(Long id) {
        return this.getObjectById(TopInvokeErrorLog.class, id);
    }
}
