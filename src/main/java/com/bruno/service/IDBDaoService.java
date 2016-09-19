package com.bruno.service;

import java.util.List;

import com.bruno.model.Filter;

public interface IDBDaoService<T, D> {
	
	void insert(T bean);
	void insertOrUpdate(T bean);
	void update(T beanName);
	void delete(T bean);
	List<T> genericquery(String query);
	T findbyId(D id) throws InstantiationException, IllegalAccessException, ClassNotFoundException;
	List<T> findAll(String beanName) throws InstantiationException, IllegalAccessException, ClassNotFoundException;
	List<T> getResourceList(Filter filter, String resourceName);
}
