package com.bruno.db.manager;

import com.bruno.exception.ControllerException;
import com.bruno.model.filter.Filter;
import com.bruno.model.response.RisultatiRicerca;

public interface IManagerDb {

	RisultatiRicerca getRisorsaList(String resourceName,Filter filter,String baseUrl) throws ControllerException;
	Object getRisorsaById(String resourceName,String id, String baseUrl) throws ControllerException;
}
