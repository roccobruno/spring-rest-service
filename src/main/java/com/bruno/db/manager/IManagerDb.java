package com.bruno.db.manager;

import com.bruno.exception.GeneralException;
import com.bruno.model.bo.Filter;
import com.bruno.model.bo.RisultatiRicerca;

public interface IManagerDb {

	RisultatiRicerca getRisorsaList(String resourceName, Filter filter) throws GeneralException;
	Object getRisorsaById(String resourceName, String id) throws GeneralException;
}
