package com.ali.lp.top.ibatis.dao;

import javax.inject.Inject;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ibatis.sqlmap.client.SqlMapClient;

public class BaseDaoIbatis extends SqlMapClientDaoSupport {
    
   @Inject
    public void setSqlMapClient2(SqlMapClient sqlMapClient){
        super.setSqlMapClient(sqlMapClient);
    }
    
}
