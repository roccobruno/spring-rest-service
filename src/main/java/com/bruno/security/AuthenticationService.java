package com.bruno.security;

public interface AuthenticationService {

	boolean checkAuthenticate(String  auth_id);
    boolean authenticate(String token);
}
