package com.bruno.db.manager;

import java.util.List;

import com.bruno.model.Filter;
import com.bruno.model.Pagamento;
import com.bruno.model.SwPagamenti;

public interface IManagerDb {
    
	List<Object> getPagamenti();
	Object getRisorsaList(String resourceName, Filter filter) throws Exception;
	 
}
