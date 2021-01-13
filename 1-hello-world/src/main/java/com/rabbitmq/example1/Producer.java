package com.rabbitmq.example1;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class Producer {
    private final RabbitTemplate rabbitTemplate;

    @GetMapping("/publish")
    public String publish() {
        String message = "Hello, World!";
        log.info("Publish to queue1: {}", message);
        rabbitTemplate.convertAndSend("queue1",message);

        return "Publish to queue...";
    }
}