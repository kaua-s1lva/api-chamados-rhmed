package com.example.ticket_rhmed.service;

import java.util.Collections;
import java.util.List;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.example.ticket_rhmed.models.Handling;
import com.example.ticket_rhmed.models.HandlingId;
import com.example.ticket_rhmed.models.Ticket;
import com.example.ticket_rhmed.models.TicketStatus;
import com.example.ticket_rhmed.models.User;
import com.example.ticket_rhmed.repositories.TicketRepository;

@Service
public class TicketService {
    private final TicketRepository ticketRepository;
    private final HandlingService handlingService;

    public TicketService(TicketRepository ticketRepository, HandlingService handlingService) {
        this.ticketRepository = ticketRepository;
        this.handlingService = handlingService;
    }

    public void createTicket(Ticket ticket) {
        ticketRepository.save(ticket);

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null || !authentication.isAuthenticated() || authentication instanceof AnonymousAuthenticationToken) {
            return;
        }

        User userPrincipal = (User) authentication.getPrincipal();

        Handling handling = new Handling();
        handling.setTicket(ticket);
        handling.setUser(userPrincipal);
        handling.setComment("Ticket criado pelo usuário");
        handling.setId(new HandlingId(ticket.getId(), TicketStatus.ABERTO));

        handlingService.createHandling(handling);
        //notifyObservers(ticket);
    }

    public Ticket getTicketById(Long id) {
        return ticketRepository.findById(id).orElse(null);
    }

    public List<Ticket> getAllTickets() {
        return Collections.unmodifiableList(ticketRepository.findAll());
    }

    public void deleteTicket(Long id) {
        ticketRepository.deleteById(id);
    }
}
