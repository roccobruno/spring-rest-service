package com.bruno.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

@Component
public class GestioneException {

    private static final Logger log = LoggerFactory.getLogger(GestioneException.class);

    public void gestisciException(Exception e) {
	log.info("Inizio metodo GestioneException.gestisciException!");

	String[] errorSplit = e.getMessage().split("/");
	StringBuffer sbMessage = new StringBuffer();
	try {
	   
	} catch (Exception ex) {
	    ex.printStackTrace();
	    log.error(ex + " on  method GestioneException.gestisciException!");
	  
	}
    }
}
