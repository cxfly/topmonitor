package com.ali.lp.top.hbm.dao.impl;

import java.util.Date;

import org.springframework.stereotype.Repository;

import com.ali.lp.top.dao.TopInvokeSuccessLogDao;
import com.ali.lp.top.entity.TopInvokeSuccessLog;
import com.ali.lp.top.hbm.dao.BaseDaoHbm;

@Repository("topInvokeSuccessLogDao")
public class TopInvokeSuccessLogDaoImpl  extends BaseDaoHbm<TopInvokeSuccessLog> implements TopInvokeSuccessLogDao<TopInvokeSuccessLog> {

    public TopInvokeSuccessLogDaoImpl() {
        super();
    }
    
    @Override
    public int updateSuccessLog(String apiName, Date lastUpdateDate, long times) {
//    	String a = "234324234242345645657657657678567896796789087078-90-709-89098967865784575467345643564564252452345432123412412412432542435346346457654a34";
        String sql = "update wl_top_invoke_success_log t "
                + " set t.times=t.times+ :times , t.last_modify_date=:last_modify_date "
                + " where t.api_name= :api_name and trunc(t.last_modify_date)= :last_modify_date2 ";
        int result = this.getSession().createSQLQuery(sql).setLong("times", new Long(times))
                .setTimestamp("last_modify_date", lastUpdateDate).setString("api_name", apiName).setDate("last_modify_date2", lastUpdateDate)
                .executeUpdate();
        return result;
    }
    
    @Override
    public long getTopInvokeSuccessRowCount() {
        long result = 0;
        Object obj = this.getSession()
                .createSQLQuery(" select nvl(sum(t.times),0) from wl_top_invoke_success_log t ")
                .uniqueResult();
        if (obj != null) {
            result = Long.parseLong(obj.toString());
        }
        return result;
    }

    @Override
    public TopInvokeSuccessLog get(Long id) {
        return  this.getObjectById(TopInvokeSuccessLog.class, id);
    }

}