package com.rabbitmq.example6;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class Client {
    private final RabbitTemplate template;

    @GetMapping("/publish/{message}")
    public String publish(@PathVariable("message") String message) {
        log.info("publish: {}", message);

        String response = (String) template.convertSendAndReceive("queue6", message);

        log.info("Received on client: {}", response);

        return "returned from worker: " + response;
    }
}