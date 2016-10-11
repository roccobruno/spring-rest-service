package com.bruno.security;

public interface AuthenticationService {

	boolean checkAuthorization(String resourceName,String  auth_id);
    boolean authenticate(String token);
}
