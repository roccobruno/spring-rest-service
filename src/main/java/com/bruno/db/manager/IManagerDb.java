package com.bruno.db.manager;

import com.bruno.model.Filter;

public interface IManagerDb {
    
	Object getRisorsaList(String resourceName, Filter filter) throws Exception;	 
	Object getRisorsaById(String resourceName, String id) throws Exception; 
}
