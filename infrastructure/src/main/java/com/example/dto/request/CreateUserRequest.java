package com.example.dto.request;

import jakarta.validation.constraints.NotBlank;

public record CreateUserRequest(@NotBlank String email, @NotBlank String password, @NotBlank String name) {}
