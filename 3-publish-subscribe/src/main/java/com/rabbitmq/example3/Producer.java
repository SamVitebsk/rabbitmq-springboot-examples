package com.rabbitmq.example3;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequiredArgsConstructor
public class Producer {
    private static int number = 0;
    private final RabbitTemplate template;

    @GetMapping("/publish")
    public String publish() {
        String message = "fanout message" + number++;
        log.info("Publish to exchange3: {}", message);

        template.setExchange("exchange3");
        template.convertAndSend(message);

        return "Publish to exchange3...";
    }
}