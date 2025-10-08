package com.example.ticket_rhmed;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.github.cdimascio.dotenv.Dotenv;

@SpringBootApplication
public class TicketRhmedApplication {

	public static void main(String[] args) {
		try {
            Dotenv dotenv = Dotenv.load();
            // Pega as variáveis do .env e as define como propriedades do sistema
            // para que o Spring possa encontrá-las
            dotenv.entries().forEach(entry -> {
                System.setProperty(entry.getKey(), entry.getValue());
            });
            System.out.println("Arquivo .env carregado com sucesso!");
        } catch (Exception e) {
            System.err.println("ERRO: Não foi possível carregar o arquivo .env: " + e.getMessage());
        }
		SpringApplication.run(TicketRhmedApplication.class, args);
	}

}
