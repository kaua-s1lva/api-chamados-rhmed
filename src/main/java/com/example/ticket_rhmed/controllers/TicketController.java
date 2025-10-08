package com.example.ticket_rhmed.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ticket_rhmed.dto.ticket.TicketRequestDTO;
import com.example.ticket_rhmed.dto.ticket.TicketResponseDTO;
import com.example.ticket_rhmed.dto.ticket.TicketUpdateDTO;
import com.example.ticket_rhmed.models.Ticket;
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
        newTicket.setPriority(ticket.priority());
        newTicket.setTerm(ticket.term());
        newTicket.setRequester(currentUser);

        ticketService.createTicket(newTicket);
    }

    @GetMapping
    public List<TicketResponseDTO> list() {
        return ticketService.getAllTickets().stream()
            .map(TicketResponseDTO::new)
            .collect(Collectors.toList());
    }

    @GetMapping("{id}")
    public ResponseEntity<TicketResponseDTO> show(@PathVariable("id") Long id) {
        Ticket ticket = ticketService.getTicketById(id);
        if (ticket == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(new TicketResponseDTO(ticket));
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
            if (ticketData.status() != existingTicket.getStatus()) {
                
            }
            existingTicket.setStatus(ticketData.status());
        }
        if (ticketData.priority() != null) {
            existingTicket.setPriority(ticketData.priority());
        }
        if (ticketData.term() != null) {
            existingTicket.setTerm(ticketData.term());
        }


    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Long id) {
        ticketService.deleteTicket(id);
    }
 
}
