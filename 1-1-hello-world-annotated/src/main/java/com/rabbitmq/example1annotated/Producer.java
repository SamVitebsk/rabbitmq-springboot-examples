package com.rabbitmq.example1annotated;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequiredArgsConstructor
public class Producer {
    private final RabbitTemplate template;

    @GetMapping("/publish")
    public String publish() {
        String message = "Hello World!";
        log.info("Publish to queue1: {}", message);

        template.convertAndSend("queue1", message);

        return "publish to queue1...";
    }
}