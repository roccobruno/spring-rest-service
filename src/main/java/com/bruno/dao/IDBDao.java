//package com.bruno.dao;
//
//import java.util.List;
//
//import com.bruno.model.Filter;
//
//public interface IDBDao<T, D> {
//
//    public void insert(T bean);
//
//    public void insertOrUpdate(T bean);
//
//    public void update(T beanName);
//
//    public void delete(T bean);
//
//    public List<T> genericquery(String query);
//
//    public T findbyId( D id) throws InstantiationException, IllegalAccessException;
//
//    public List<T> findAll() throws InstantiationException, IllegalAccessException;
//
//	List<T> getResourceList(Filter filter, String resourceName);
//}

package com.bruno.dao;

import com.bruno.model.filter.Filter;

public interface IDBDao {

	Object genericquery(String query);
    Long getCount(Filter filter, String resourceName);
    Object findbyId(String beanName, int id) throws InstantiationException, IllegalAccessException, ClassNotFoundException;
	Object getResourceList(Filter filter, String resourceName);
}
