package com.bruno.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bruno.utils.MessageJson;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


public class RestAuthenticationFilter implements javax.servlet.Filter {
	
	private AuthenticationService authenticationService = new AuthenticationServiceImpl();
	
    public static final String AUTHENTICATION_HEADER = "authorization_id";

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,FilterChain filter) throws IOException, ServletException {
    	
        if (request instanceof HttpServletRequest) {
        	
            HttpServletRequest httpServletRequest = (HttpServletRequest) request;
            String authCredentials = httpServletRequest.getHeader(AUTHENTICATION_HEADER);            

            boolean authenticationStatus = authenticationService.authenticate(authCredentials);

            if (authenticationStatus) {
            	boolean authorizationStatus = authenticationService.checkAuthorization(httpServletRequest.getServletPath().substring(10),authCredentials);
            	
            	if(authorizationStatus){
            		filter.doFilter(request, response);
            	}else{
            		if (response instanceof HttpServletResponse) {
            			createErrorMessage(response, HttpServletResponse.SC_FORBIDDEN);
            			}}
                
            } else {
                if (response instanceof HttpServletResponse) {
                	createErrorMessage(response, HttpServletResponse.SC_UNAUTHORIZED);             
                }
            }
        }
    }
    
    public void createErrorMessage(ServletResponse response,int statuscode) throws IOException{
    	
    	HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        httpServletResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.setContentType("application/json");	 
        GsonBuilder builder = new GsonBuilder().disableHtmlEscaping();
    	Gson gson = builder.setPrettyPrinting().create();
        response.getWriter().write(gson.toJson(new MessageJson("Non Autorizzato!")));
    }

    @Override
    public void destroy() {
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {
    }
}
