package com.bruno.dao.service;

import com.bruno.model.bo.Filter;

public interface IDBDaoService {
	
	Object findbyId(String beanName, int id) throws InstantiationException, IllegalAccessException, ClassNotFoundException;
	Object genericquery(String query);	
	Object getResourceList(Filter filter, String resourceName);
	Long getCount (Filter filters, String resourceName);
}
