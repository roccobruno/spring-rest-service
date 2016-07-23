package com.bruno.security;

public interface AuthenticationService {


    boolean authenticate(String token);
}
