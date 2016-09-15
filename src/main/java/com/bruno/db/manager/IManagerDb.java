package com.bruno.db.manager;

import java.util.List;

import com.bruno.model.Pagamento;
import com.bruno.model.Swpagamenti;

public interface IManagerDb {
    
	 public List<Object> getPagamenti();
	 public Object getRisorsaList(String resourceName) throws Exception;
	 
}
