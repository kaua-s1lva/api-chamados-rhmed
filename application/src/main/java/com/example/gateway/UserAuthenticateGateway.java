package com.example.gateway;

public interface UserAuthenticateGateway {
    Boolean authenticate(String email, String password);
}
