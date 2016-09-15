package com.bruno.dao.service;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bruno.dao.IDBDao;

@Service
public class DBDaoServiceImpl implements IDBDaoService{
	
	private static final Logger log = LoggerFactory.getLogger(DBDaoServiceImpl.class);
	
	
	@Autowired
	private IDBDao iDBDao;
	
	@Transactional
	public void insert(Object bean){	
		iDBDao.insert(bean);
	}
	
	@Transactional
	public void update(Object bean){
		iDBDao.update(bean);
	}
	
	@Transactional
	public void insertOrUpdate(Object bean){	
		iDBDao.insertOrUpdate(bean);
	}
	
	@Transactional
	public void delete(Object bean){
		iDBDao.delete(bean);
	}

	@Transactional
	public Object findbyId(String bean,int id) throws InstantiationException, IllegalAccessException, ClassNotFoundException{	
		return iDBDao.findbyId(bean,id);
	}
	
	@Transactional
	public List<Object> findAll(String bean) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		return iDBDao.findAll(bean);
	}
	
	@Transactional
	public Object genericquery(String query){
		return iDBDao.genericquery(query);
	}

}
