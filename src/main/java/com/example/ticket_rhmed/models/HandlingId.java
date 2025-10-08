package com.example.ticket_rhmed.models;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HandlingId implements Serializable {

    @Column(name = "ticket_id")
    private Long ticketId;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private TicketStatus status;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HandlingId that = (HandlingId) o;
        return Objects.equals(ticketId, that.ticketId) && status == that.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ticketId, status);
    }
}