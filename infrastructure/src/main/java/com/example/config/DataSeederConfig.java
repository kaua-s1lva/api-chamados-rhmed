package com.example.config;

import com.example.domain.enums.UserRoleEnum;
import com.example.entity.UserEntity;
import com.example.repository.UserEntityRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;
import java.util.UUID;

@Configuration
public class DataSeederConfig {

    @Bean
    public CommandLineRunner initDatabase(UserEntityRepository userRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            String adminEmail = "admin@rhmed.com.br";
            if (userRepository.findByEmail(adminEmail).isEmpty()) {
                UserEntity admin = new UserEntity();
                admin.setId(UUID.randomUUID());
                admin.setName("Administrador");
                admin.setEmail(adminEmail);
                admin.setPassword(passwordEncoder.encode("admin123"));
                admin.setRole(UserRoleEnum.ADMIN);
                admin.setCreateAt(LocalDateTime.now());
                userRepository.save(admin);
            }
        };
    }
}
