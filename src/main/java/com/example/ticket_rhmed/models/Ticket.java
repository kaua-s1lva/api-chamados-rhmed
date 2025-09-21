package com.example.ticket_rhmed.models;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Setter;
import lombok.Getter;
import lombok.NonNull;

@Entity
@Table(name = "tickets")
@Getter
@Setter
public class Ticket {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @Column(nullable = false)
    private String code;

    @NonNull
    @Column(nullable = false)
    private String title;

    @NonNull
    @Column(nullable = false)
    private String description;

    @NonNull
    @Column(nullable = false)
    private LocalDate term;

    @NonNull
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TicketPriority priority;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "requester_id", nullable = false)
    private User requester;

    @NonNull
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TicketStatus status;

}
