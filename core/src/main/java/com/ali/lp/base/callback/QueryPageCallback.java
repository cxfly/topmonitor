package com.ali.lp.base.callback;

import com.ali.lp.base.page.PageBean;

public class QueryPageCallback<T> extends QueryCallback<T> {
    public QueryPageCallback(String queryString, Object[] params, PageBean pageBean) {
        super(queryString, params, pageBean.getCurrentPageFirstRecord(), pageBean
                .getCurrentPageSize());
    }
}
