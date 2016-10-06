package com.bruno.security;

import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.web.authentication.preauth.AbstractPreAuthenticatedProcessingFilter;

public class UrlParametersAuthenticationFilter extends AbstractPreAuthenticatedProcessingFilter {

    private static final Logger log = LoggerFactory.getLogger(UrlParametersAuthenticationFilter.class);

    @Override
    protected Object getPreAuthenticatedPrincipal(HttpServletRequest request) {
	log.info("Start UrlParametersAuthenticationFilter.getPreAuthenticatedPrincipal method");
	try {
	    if (request.getParameterMap().size() == 1) {
		return true;
	    }
	} catch (Exception e) {
	    log.error("Exception invoked in method UrlParametersAuthenticationFilter.getPreAuthenticatedPrincipal: " + e.toString());
	}
	return false;
    }

    @Override
    protected Object getPreAuthenticatedCredentials(HttpServletRequest request) {
	log.info("Start UrlParametersAuthenticationFilter.getPreAuthenticatedCredentials method");
	String credentials = null;

	try {
	    credentials = request.getParameter("TOKEN");
	} catch (Exception e) {
	    log.error("Exception invoked in method UrlParametersAuthenticationFilter.getPreAuthenticatedCredentials: " + e.toString());
	}
	return credentials;
    }
}
