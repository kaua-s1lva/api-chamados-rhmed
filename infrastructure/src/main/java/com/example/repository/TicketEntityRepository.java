package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.TicketEntity;

public interface TicketEntityRepository extends JpaRepository<TicketEntity, Long>{
    
}
