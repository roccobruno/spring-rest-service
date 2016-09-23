package com.bruno.dao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.bruno.dao.IDBDao;
import com.bruno.model.bo.Filter;

@Service
public class DBDaoServiceImpl implements IDBDaoService{
	
	@Autowired
	private IDBDao dBDao;
	
	@Transactional
	public Object findbyId(String bean,int id) throws InstantiationException, IllegalAccessException, ClassNotFoundException{	
		return dBDao.findbyId(bean,id);
	}

	@Transactional
	public Object getResourceList(Filter filter, String resourceName) {
		return dBDao.getResourceList(filter,resourceName);
	}

	@Transactional
	public Long getCount(Filter filters, String resourceName) {
		return dBDao.getCount(filters, resourceName);
	}

	@Transactional
	public Object genericquery(String query) {
		return dBDao.genericquery(query);
	}
}
