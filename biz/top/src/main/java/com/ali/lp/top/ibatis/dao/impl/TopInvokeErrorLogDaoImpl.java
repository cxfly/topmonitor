package com.ali.lp.top.ibatis.dao.impl;

import org.springframework.stereotype.Repository;

import com.ali.lp.top.dao.TopInvokeErrorLogDao;
import com.ali.lp.top.entity.TopInvokeErrorLog;
import com.ali.lp.top.ibatis.dao.BaseDaoIbatis;

@Repository("topInvokeErrorLogIbatisDao")
public class TopInvokeErrorLogDaoImpl extends BaseDaoIbatis implements
        TopInvokeErrorLogDao<TopInvokeErrorLog> {

    @Override
    public void save(TopInvokeErrorLog entity) {
        this.getSqlMapClientTemplate().insert("TopInvokeErrorLog.insert", entity);
    }

    @Override
    public void update(TopInvokeErrorLog entity) {
        this.getSqlMapClientTemplate().update("", entity);
    }

    @Override
    public void delete(TopInvokeErrorLog entity) {
        this.getSqlMapClientTemplate().delete("", entity);
    }

    @Override
    public long getTopInvokeErrorRowCount() {
        long result = 0;
        Long rowCount = (Long) this.getSqlMapClientTemplate().queryForObject("TopInvokeErrorLog.queryAllRowCount");
        if (rowCount != null) {
            result = rowCount.longValue();
        }
        return result;
    }

    @Override
    public TopInvokeErrorLog get(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

}
