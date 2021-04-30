package com.example.demo.security;

public interface Constants {
    String SECRET = "secretKey";
    long EXPIRATION_TIME = 864_000_000;
    String TOKEN_TYPE = "Bearer ";
    String HEADER = "Authorization";
    String CREATE_URL = "/api/user/create";
}
