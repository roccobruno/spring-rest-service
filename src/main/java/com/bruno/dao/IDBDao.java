package com.bruno.dao;

import java.util.List;

import com.bruno.model.Filter;

public interface IDBDao {

    public void insert(Object bean);

    public void insertOrUpdate(Object bean);

    public void update(Object beanName);

    public void delete(Object bean);

    public Object genericquery(String query);

    public Object findbyId(String beanName, int id) throws InstantiationException, IllegalAccessException, ClassNotFoundException;

    public List<Object> findAll(String beanName) throws InstantiationException, IllegalAccessException, ClassNotFoundException;

	List<Object> getBy(Filter filter);
}
