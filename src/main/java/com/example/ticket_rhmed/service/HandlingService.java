package com.example.ticket_rhmed.service;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.ticket_rhmed.models.Handling;
import com.example.ticket_rhmed.repositories.HandlingRepository;

@Service
public class HandlingService {
    private final HandlingRepository handlingRepository;

    public HandlingService(HandlingRepository handlingRepository) {
        this.handlingRepository = handlingRepository;
    }

    public Handling createHandling(Handling handling) {
        return handlingRepository.save(handling);
    }

    public Handling getHandlingById(String id) {
        return handlingRepository.findById(id).orElse(null);
    }

    public List<Handling> getAllHandlings() {
        return Collections.unmodifiableList(handlingRepository.findAll());
    }

    public void updateHandling(Handling handling) {
        handlingRepository.save(handling);
    }

    public void deleteHandling(String id) {
        handlingRepository.deleteById(id);
    }
}
