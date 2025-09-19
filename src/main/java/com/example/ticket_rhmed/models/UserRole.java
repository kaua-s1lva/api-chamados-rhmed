package com.example.ticket_rhmed.models;

public enum UserRole {

    ADMIN("admin"),

    USER("user");

    private final String role;

    private UserRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
