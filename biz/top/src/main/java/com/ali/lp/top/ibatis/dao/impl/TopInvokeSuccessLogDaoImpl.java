package com.ali.lp.top.ibatis.dao.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.ali.lp.top.dao.TopInvokeSuccessLogDao;
import com.ali.lp.top.entity.TopInvokeSuccessLog;
import com.ali.lp.top.ibatis.dao.BaseDaoIbatis;

@Repository("topInvokeSuccessLogIbatisDao")
public class TopInvokeSuccessLogDaoImpl extends BaseDaoIbatis implements
        TopInvokeSuccessLogDao<TopInvokeSuccessLog> {

    public TopInvokeSuccessLogDaoImpl() {
        super();
    }

    @Override
    public void save(TopInvokeSuccessLog topInvokeSuccessLog) {
        Long id = (Long) this.getSqlMapClientTemplate().insert("TopInvokeSuccessLog.insert", topInvokeSuccessLog);
        if (id !=null) {
            topInvokeSuccessLog.setId(id.longValue());
        }
    }

    @Override
    public int updateSuccessLog(String apiName, Date lastUpdateDate, long times) {
        int result = 0;
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("apiName", apiName);
        param.put("times", times);
        param.put("lastModifyDate", lastUpdateDate);
        param.put("lastModifyDate2", (new java.sql.Date(lastUpdateDate.getTime())));
        result = this.getSqlMapClientTemplate().update("TopInvokeSuccessLog.updateByApiNameAndModifyDate", param);
        return result;
    }

    @Override
    public long getTopInvokeSuccessRowCount() {
        long result = 0;
        Long rowCount = (Long) this.getSqlMapClientTemplate().queryForObject("TopInvokeSuccessLog.selectRowCount");
        if (rowCount!=null) {
            result = rowCount.longValue();
        }
        return result;
    }

    @Override
    public void update(TopInvokeSuccessLog entity) {
        this.getSqlMapClientTemplate().update("TopInvokeSuccessLog.updateById", entity.getId());
    }

    @Override
    public void delete(TopInvokeSuccessLog entity) {
        this.getSqlMapClientTemplate().delete("TopInvokeSuccessLog.deleteById", entity.getId());
    }

    @Override
    public TopInvokeSuccessLog get(Long id) {
        return (TopInvokeSuccessLog) this.getSqlMapClientTemplate().queryForObject("TopInvokeSuccessLog.selectById", id);
    }

  
}
