package com.bruno.exception;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.bruno.utils.MessageJson;

@Component
public class GestioneException {

    private static final Logger log = LoggerFactory.getLogger(GestioneException.class);

    public MessageJson gestisciException(Exception e,HttpServletResponse response) {
	log.info("Inizio metodo GestioneException.gestisciException!");

	MessageJson message = null;
	int statusCode;
	
	try {
		if(e instanceof IGeneralException){
			message = ((IGeneralException) e).getMessageJson();
			statusCode = ((IGeneralException) e).getStatusCode();
			response.setStatus(statusCode);
			}
	} catch (Exception ex) {
	    ex.printStackTrace();
	    log.error(ex + " on  method GestioneException.gestisciException!");	  
	}
	return message;
    }
}
