package com.example.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import com.example.domain.enums.TicketPriorityEnum;
import com.example.domain.enums.TicketStatusEnum;
import com.example.domain.ticketstatus.OpenTicketState;
import com.example.domain.ticketstatus.TicketStatusState;
import com.example.domain.ticketstatus.TicketStatusStateFactory;

public class Ticket {
    private Long id;
    private String code;
    private String title;
    private String description;
    private LocalDate term;
    private TicketPriorityEnum priority;
    private User requester;
    private TicketStatusState status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Long getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getTerm() {
        return term;
    }

    public TicketPriorityEnum getPriority() {
        return priority;
    }

    public User getRequester() {
        return requester;
    }

    public TicketStatusEnum getStatus() {
        return status.getStatus();
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    private void setStatus(TicketStatusEnum status) {
        this.status = new TicketStatusStateFactory(this).create(status);
    }

    public Ticket(String title, String description, LocalDate term, TicketPriorityEnum priority, User requester) {
        this.code = UUID.randomUUID().toString();
        this.title = title;
        this.description = description;
        this.term = term;
        this.priority = priority;
        this.requester = requester;
        this.status = new OpenTicketState(this);
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public Ticket(Long id, String code, String title, String description, LocalDate term, TicketPriorityEnum priority,
            User requester, TicketStatusEnum status, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.code = code;
        this.title = title;
        this.description = description;
        this.term = term;
        this.priority = priority;
        this.requester = requester;
        this.setStatus(status);
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public void changeState(TicketStatusState state) {
        this.status = state;
    }

    public void analyze() {
        this.status.analyze();
    }

    public void requestInformation() {
        this.status.requestInformation();
    }

    public void approveAnalysis() {
        this.status.approveAnalysis();
    }

    public void validate() {
        this.status.validate();
    }

    public void approveValidation() {
        this.status.approveValidation();
    }

    public void rejectValidation() {
        this.status.rejectValidation();
    }

    public void cancel() {
        this.status.cancel();
    }
    
}
