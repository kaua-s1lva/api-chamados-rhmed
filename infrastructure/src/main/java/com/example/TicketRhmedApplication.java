package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.github.cdimascio.dotenv.Dotenv;

@SpringBootApplication
public class TicketRhmedApplication {

	public static void main(String[] args) {
        //Dotenv dotenv = Dotenv.load();
		SpringApplication.run(TicketRhmedApplication.class, args);
	}

}
