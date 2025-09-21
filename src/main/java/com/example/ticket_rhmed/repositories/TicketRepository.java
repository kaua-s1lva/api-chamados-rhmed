package com.example.ticket_rhmed.repositories;

import com.example.ticket_rhmed.models.Ticket;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
}
