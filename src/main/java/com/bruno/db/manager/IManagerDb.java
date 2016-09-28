package com.bruno.db.manager;

import com.bruno.exception.GeneralException;
import com.bruno.model.filter.Filter;
import com.bruno.model.response.RisultatiRicerca;

public interface IManagerDb {

	RisultatiRicerca getRisorsaList(String resourceName,Filter filter,String baseUrl) throws GeneralException;
	Object getRisorsaById(String resourceName,String id, String baseUrl) throws GeneralException;
}
