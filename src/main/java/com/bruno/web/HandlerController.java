package com.bruno.web;

import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import springfox.documentation.annotations.ApiIgnore;
import com.bruno.exception.GestioneException;
import com.bruno.exception.InternalServerErrorException;
import com.bruno.exception.NotFoundException;

@ApiIgnore
@Controller
@RequestMapping(value = "handler")
public class HandlerController {
	
	private static final Logger log = LoggerFactory.getLogger(HandlerController.class);
	
	@Autowired
    GestioneException gestioneException;
	
    @RequestMapping(value = "404")
    public @ResponseBody Object handle404(HttpServletResponse response) {
    	return gestioneException.gestisciException(new NotFoundException(), response);
   }
    
    @RequestMapping(value = "500")
    public @ResponseBody Object handle500(HttpServletResponse response) {    	
    	return gestioneException.gestisciException(new InternalServerErrorException(), response);
   }
}