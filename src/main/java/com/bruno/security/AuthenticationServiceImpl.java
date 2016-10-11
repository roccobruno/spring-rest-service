package com.bruno.security;

import org.springframework.stereotype.Component;

@Component
public class AuthenticationServiceImpl implements AuthenticationService {
	
	public static final String AUTHENTICATION_HEADER = "authorization_id";
	
    @Override
    public boolean authenticate(String token) {
    	
//    	if(token == null)
//    		return false;
    	return true;
    }
    
    public boolean checkAuthenticate(String auth_id){
    	
    	return authenticate(auth_id);
    }
}
