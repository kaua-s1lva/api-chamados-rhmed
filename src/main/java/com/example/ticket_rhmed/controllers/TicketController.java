package com.example.ticket_rhmed.controllers;

import java.util.List;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ticket_rhmed.dto.TicketRequestDTO;
import com.example.ticket_rhmed.dto.TicketUpdateDTO;
import com.example.ticket_rhmed.models.Ticket;
import com.example.ticket_rhmed.models.TicketStatus;
import com.example.ticket_rhmed.models.User;
import com.example.ticket_rhmed.service.TicketService;

@RestController
@RequestMapping("/tickets")
public class TicketController {
    private TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }
    
    @PostMapping
    public void create(@RequestBody TicketRequestDTO ticket, @AuthenticationPrincipal User currentUser) {
        Ticket newTicket = new Ticket();
        newTicket.setCode(ticket.code());
        newTicket.setTitle(ticket.title());
        newTicket.setDescription(ticket.description());
        newTicket.setStatus(TicketStatus.ABERTO);
        newTicket.setPriority(ticket.priority());
        newTicket.setTerm(ticket.term());
        newTicket.setRequester(currentUser);

        ticketService.createTicket(newTicket);
    }

    @GetMapping
    public List<Ticket> list() {
        return ticketService.getAllTickets();
    }

    @GetMapping("{id}")
    public Ticket show(@PathVariable("id") Long id) {
        return ticketService.getTicketById(id);
    }

    @PutMapping
    public void update(@RequestBody TicketUpdateDTO ticketData) {
        Ticket existingTicket = ticketService.getTicketById(ticketData.id());
        
        if (ticketData.title() != null) {
            existingTicket.setTitle(ticketData.title());
        }
        if (ticketData.description() != null) {
            existingTicket.setDescription(ticketData.description());
        }
        if (ticketData.status() != null) {
            existingTicket.setStatus(ticketData.status());
        }
        if (ticketData.priority() != null) {
            existingTicket.setPriority(ticketData.priority());
        }
        if (ticketData.term() != null) {
            existingTicket.setTerm(ticketData.term());
        }
        
        ticketService.updateTicket(existingTicket);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Long id) {
        ticketService.deleteTicket(id);
    }
 
}
