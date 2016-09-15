package com.bruno.dao.service;

import java.util.List;

import com.bruno.model.Filter;
import com.bruno.model.Pagamento;

public interface IDBDaoService {
	
	void insert(Object bean);
	void insertOrUpdate(Object bean);
	void update(Object beanName);
	void delete(Object bean);
	Object genericquery(String query);
	Object findbyId(String beanName, int id) throws InstantiationException, IllegalAccessException, ClassNotFoundException;	
	List<Object> findAll(String beanName) throws InstantiationException, IllegalAccessException, ClassNotFoundException;
	Object getResourceList(Filter filter, String resourceName);
}
