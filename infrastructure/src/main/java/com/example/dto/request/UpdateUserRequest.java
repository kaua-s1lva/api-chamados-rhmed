package com.example.dto.request;

public record UpdateUserRequest(
    Long id,
    String name,
    String password,
    String email
) {}