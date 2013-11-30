package com.ali.lp.base.dao;

public interface BaseDao<T> {

    public T get(Long id);
    public void save(T entity);
    public void update(T entity);
    public void delete(T entity);
}
