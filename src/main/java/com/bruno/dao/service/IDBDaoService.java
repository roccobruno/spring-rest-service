package com.bruno.dao.service;

import java.util.List;

import com.bruno.model.Filter;

public interface IDBDaoService {
	
	Object findbyId(String beanName, int id) throws InstantiationException, IllegalAccessException, ClassNotFoundException;
	Object genericquery(String query);	
	long getCountValue(String queryString);
	Object getResourceList(Filter filter, String resourceName);
}
