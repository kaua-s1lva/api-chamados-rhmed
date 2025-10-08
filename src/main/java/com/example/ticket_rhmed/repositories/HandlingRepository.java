package com.example.ticket_rhmed.repositories;

import com.example.ticket_rhmed.models.Handling;

import org.springframework.data.jpa.repository.JpaRepository;

public interface HandlingRepository extends JpaRepository<Handling, String> {
    
}
