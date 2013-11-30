package com.ali.lp.top.hbm.dao;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.ali.lp.base.callback.QueryPageCallback;
import com.ali.lp.base.page.PageBean;

@Repository
@SuppressWarnings({ "rawtypes", "unchecked" })
public class BaseDaoHbm<T> extends HibernateDaoSupport {
    
	@Inject
	public void setSuperSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

    public void save(T entity) {
    	this.getHibernateTemplate().save(entity);
    }

    public void update(T entity) {
    	this.getHibernateTemplate().update(entity);
    }

	public void saveOrUpdate(T entity) {
		this.getHibernateTemplate().saveOrUpdate(entity);
	}

	public void saveOrUpdateAll(List<T> entities) {
		this.getHibernateTemplate().saveOrUpdateAll(entities);
	}
    
    public void delete(T entity) {
    	this.getHibernateTemplate().delete(entity);
    }

    public void deleteAll(List<T> entities) {
    	this.getHibernateTemplate().deleteAll(entities);
    }

    /**
     * 执行查询语句（HQL）。
     * 
     * @param queryStr
     *            查询语句HQL。
     * @return 查询结果。
     */

	public List<T> query(String queryStr) {
        return this.getHibernateTemplate().find(queryStr);
    }

    /**
     * 执行查询语句（HQL）。
     * 
     * @param queryStr
     *            查询语句HQL。
     * @param params
     *            参数值。
     * @return 查询结果。
     */
    public List<T> query(String queryStr, Object... params) {
        return this.getHibernateTemplate().find(queryStr, params);
    }

	public List<T> query(final String queryStr, final PageBean pageBean) {
    	return this.query(queryStr, new Object[]{}, pageBean);
    }

    /**
     * 分页查询对象
     * 
     * @param queryStr
     *            查询语句
     * @param params
     *            参数值
     * @param pageBean
     *            分页对象
     * @return 记录结果
     */
	public List<T> query(final String queryStr, final Object[] params,
            final PageBean pageBean) {

        if (pageBean == null) {
            return query(queryStr, params);
        }
        
        long recordCount = this.getRowCount(queryStr, params);
        pageBean.setRecordCount(recordCount);
        List<T> result = (List) this.getHibernateTemplate().execute(
                new QueryPageCallback(queryStr, params, pageBean));

        return result;
    }
    
    /**
     * 查询出单个对象。
     * @param queryString 查询语句。
     * @param params 参数值。
     */
    public T getSingle(String queryString, Object... params) {
        List list = this.getHibernateTemplate().find(queryString, params);

        if (list.size() > 0) {
            return (T) list.iterator().next();
        } else {
            return null;
        }
    }

    /**
     * 根据对象类型和ID查询一个对象。
     * 
     * @param entityClass
     *            要查询的实体类。
     * @param id
     *            对象标识。
     * @return 查询结果。
     * @throws DataAccessException
     */
    public T getObjectById(Class<?> entityClass, Serializable id)
            throws DataAccessException {
        return (T) this.getHibernateTemplate().get(entityClass, id);
    }
    
    /**
     * 根据给定的查询语句HQL删除实体。
     * 
     * @param queryStr
     *            查询语句。
     * @param params
     *            参数值。
     */
    public void deleteFromQuery(String queryStr, Object[] params) {
        List result = this.getHibernateTemplate().find(queryStr, params);
        deleteAll(result);
    }
    
    /**
     * 直接运行SQL更新语句
     * @param sql
     */
    public void runSqlUpdate(String sql)
    {
    	SQLQuery query = getSession().createSQLQuery(sql);
    	query.executeUpdate();
    }
    
    
    /**
     * 获取总查询结果总记录数
     * @param queryString
     * @param params
     * @return
     */
	public long getRowCount(String queryString, final Object[] params) {
		String countSql = createCountQL(queryString);
		Query countQuery = this.getSession().createQuery(countSql);

		for (int i = 0; i < params.length; i++) {
			countQuery.setParameter(i, params[i]);
		}
		Iterator iter = countQuery.iterate();
		Number countValue = null;

		if (iter.hasNext()) {
			countValue = (Number) iter.next();
		}

		if (countValue == null) {
			return 0;
		}
		return countValue.longValue();
	}

    
    /**
     * 创建记数的查询语句.
     * @param queryStr
     * @return
     */
    private String createCountQL(String queryStr) {
        int idxF = queryStr.indexOf("from");
        int idxD = queryStr.indexOf("distinct");

        if (idxD > 0 && idxD < 12) {
            String result =
                queryStr.substring(idxD + "distinct".length(), idxF);

            return "select distinct count(" + result + ") "
            + queryStr.substring(idxF);
        } else {
            return "select count(*) " + queryStr.substring(idxF);
        }
    }
}
