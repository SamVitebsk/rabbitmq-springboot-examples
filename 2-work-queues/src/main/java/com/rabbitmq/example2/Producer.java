package com.rabbitmq.example2;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class Producer {
    private static int number = 0;
    private final AmqpTemplate template;

    @GetMapping("/publish")
    public String publish() {
        String message = "Example Work Queues ";

        for (int i = 0; i < 10; i++) {
            log.info("publish: {}", message + number);
            template.convertAndSend("queue2", message + number++);
        }

        return "Publish to queue2...";
    }
}