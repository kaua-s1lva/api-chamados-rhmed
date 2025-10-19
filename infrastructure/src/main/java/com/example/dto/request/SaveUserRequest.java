package com.example.dto.request;

import jakarta.validation.constraints.NotBlank;

public record SaveUserRequest(@NotBlank String email, @NotBlank String password, @NotBlank String name) {}
