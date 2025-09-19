package com.example.ticket_rhmed;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.example.ticket_rhmed.models.User;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TicketRhmedApplicationTests {
	@Autowired
	private WebTestClient webTestClient;

	@Test
	void testCreateUserSuccess() {
		User user = new User("Kauã", "kaua@gmail.com", "123456");

		webTestClient
			.post()
			.uri("/auth/register")
			.bodyValue(user)
			.exchange()
			.expectStatus().isOk()
			.expectBody()
			.jsonPath("$.name").isEqualTo("Kauã")
			.jsonPath("$.token").isNotEmpty();
	}

	@Test
	void testCreateUserFailure() {
		
	}

}
