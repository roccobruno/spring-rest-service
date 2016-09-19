package com.bruno.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.bruno.utils.MessageJson;

@Component
public class GestioneException {

    private static final Logger log = LoggerFactory.getLogger(GestioneException.class);

    public MessageJson gestisciException(Exception e) {
	log.info("Inizio metodo GestioneException.gestisciException!");

	try {
		if(e instanceof IGeneralException)
			return ((IGeneralException) e).getMessageJson();
	} catch (Exception ex) {
	    ex.printStackTrace();
	    log.error(ex + " on  method GestioneException.gestisciException!");	  
	}
	return null;
    }
}
