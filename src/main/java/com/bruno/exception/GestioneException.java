package com.bruno.exception;

import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bruno.utils.IUtilityClass;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Component
public class GestioneException {

    private static final Logger log = LoggerFactory.getLogger(GestioneException.class);
    
    @Autowired
    IUtilityClass utilityClass;

    public Object gestisciException(ControllerException e, HttpServletResponse response) {
        response.setStatus(e.getStatusCode());
        GsonBuilder builder = new GsonBuilder().disableHtmlEscaping();
    	Gson gson = builder.setPrettyPrinting().create();               
        return gson.toJson(e.getMessageJson());
    }
}
