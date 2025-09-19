package com.example.ticket_rhmed.dto;

import com.example.ticket_rhmed.models.UserRole;

public record RegisterRequestDTO(String name, String email, String password, UserRole role) {}
