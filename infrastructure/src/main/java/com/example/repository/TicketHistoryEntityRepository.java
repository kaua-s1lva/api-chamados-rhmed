package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.TicketHistoryEntity;

public interface TicketHistoryEntityRepository extends JpaRepository<TicketHistoryEntity, Long>{
    
}
