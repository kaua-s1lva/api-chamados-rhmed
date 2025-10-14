package com.example.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.UserEntity;

public interface UserEntityRepository extends JpaRepository<UserEntity, UUID>{
    Boolean existsByEmail(String email);
    Optional<UserEntity> findByEmail(String email);
}
