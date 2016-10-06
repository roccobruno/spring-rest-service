package com.bruno.web;

import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import com.bruno.exception.ControllerException;
import com.bruno.exception.GestioneException;
import com.bruno.exception.NotFoundException;

@RestController
@RequestMapping(value = "handle")
public class HandlerController {
	
	private static final Logger log = LoggerFactory.getLogger(HandlerController.class);
	
	@Autowired
    GestioneException gestioneException;
	
    @RequestMapping(value = "404")
    public Object handle404(HttpServletResponse response) {
	   try{
		   throw new NotFoundException();
	   }catch(ControllerException e){
		   log.error(e.getMessage());
           return gestioneException.gestisciException(e, response);
	   }
   }
}