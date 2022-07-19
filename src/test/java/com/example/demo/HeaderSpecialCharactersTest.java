package com.example.demo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

@ExtendWith(SpringExtension.class)
@WebFluxTest(DemoController.class)
public class HeaderSpecialCharactersTest {

  @Autowired
  private WebTestClient webClient;

  @Test
  void testSendHeaderFromGet() {
    webClient.get()
        .uri("/dummy")
        .header("cust-full-name", "muñoz")
        .exchange()
        .expectBody(String.class)
        .isEqualTo("muñoz");
  }

  @Test
  void testSendHeaderFromPost() {
    DummyDto dummy = new DummyDto();
    dummy.setDni("123");
    webClient.post()
        .uri("/dummy")
        .contentType(MediaType.APPLICATION_JSON)
        .body(Mono.just(dummy), DummyDto.class)
        .header("cust-full-name", "muñoz")
        .exchange()
        .expectBody(String.class)
        .isEqualTo("muñoz");
  }
}
