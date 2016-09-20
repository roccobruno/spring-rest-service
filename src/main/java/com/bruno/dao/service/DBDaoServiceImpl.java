//package com.bruno.service;
//
//import java.util.List;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.bruno.dao.IDBDao;
//import com.bruno.model.Filter;
//
//public abstract class DBDaoServiceImpl<T, D> implements IDBDaoService<T, D>{
//	
//	private static final Logger log = LoggerFactory.getLogger(DBDaoServiceImpl.class);
//	
//	
//	public abstract IDBDao<T, D> getIDBDao();
//	
//	@Transactional
//	public void insert(T bean){
//		getIDBDao().insert(bean);
//	}
//	
//	@Transactional
//	public void update(T bean){
//		getIDBDao().update(bean);
//	}
//	
//	@Transactional
//	public void insertOrUpdate(T bean){
//		getIDBDao().insertOrUpdate(bean);
//	}
//	
//	@Transactional
//	public void delete(T bean){
//		getIDBDao().delete(bean);
//	}
//
//	@Transactional
//	public T findbyId(D id) throws InstantiationException, IllegalAccessException{
//		return getIDBDao().findbyId(id);
//	}
//	
//	@Transactional
//	public List<T> findAll(String bean) throws InstantiationException, IllegalAccessException {
//		return getIDBDao().findAll();
//	}
//	
//	@Transactional
//	public List<T> genericquery(String query){
//		return getIDBDao().genericquery(query);
//	}
//
//	@Transactional
//	public List<T> getResourceList(Filter filter, String resourceName){
//		return getIDBDao().getResourceList(filter, resourceName);
//	}
//
//}

package com.bruno.dao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.bruno.dao.IDBDao;
import com.bruno.model.Filter;

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
	public Object genericquery(String query) {
		return dBDao.genericquery(query);
	}

}
