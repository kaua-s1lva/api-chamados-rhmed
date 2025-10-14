package com.example.dto.request;

public record LoginUserRequest (
    String email,
    String password
) {}
