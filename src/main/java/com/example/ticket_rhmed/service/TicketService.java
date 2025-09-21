package com.example.ticket_rhmed.service;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.ticket_rhmed.models.Ticket;
import com.example.ticket_rhmed.repositories.TicketRepository;

@Service
public class TicketService {
    private TicketRepository ticketRepository;

    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public Ticket createTicket(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    public Ticket getTicketById(Long id) {
        return ticketRepository.findById(id).orElse(null);
    }

    public List<Ticket> getAllTickets() {
        return Collections.unmodifiableList(ticketRepository.findAll());
    }

    public void updateTicket(Ticket ticket) {
        ticketRepository.save(ticket);
    }

    public void deleteTicket(Long id) {
        ticketRepository.deleteById(id);
    }
}
