package com.bruno.exception;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.bruno.utils.MessageJson;

@Component
public class GestioneException {

    private static final Logger log = LoggerFactory.getLogger(GestioneException.class);

    public MessageJson gestisciException(ControllerException e, HttpServletResponse response) {
        response.setStatus(e.getStatusCode());
        return e.getMessageJson();
    }
}
