package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;


@RestController
@Slf4j
public class DemoController {

  @GetMapping("/dummy")
  public Mono<String> getDummy(ServerWebExchange exchange) {
    String header = exchange.getRequest().getHeaders().get("cust-full-name").get(0);
    log.info("header from GET {}", header);


    return Mono.fromCallable(() -> header);
  }

  @PostMapping("/dummy")
  public Mono<String> getDummyPost(@RequestBody DummyDto dto, ServerWebExchange exchange) {
    log.info("dto {}", dto.getDni());
    String header = exchange.getRequest().getHeaders().get("cust-full-name").get(0);
    log.info("header from POST {}", header);

    return Mono.fromCallable(() -> header);
  }
}
