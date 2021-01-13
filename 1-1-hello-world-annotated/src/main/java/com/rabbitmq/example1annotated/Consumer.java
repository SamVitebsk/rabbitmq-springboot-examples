package com.rabbitmq.example1annotated;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Consumer {
    @RabbitListener(queues = "queue1")
    public void processQueue1(String message) {
        log.info("Received from queue 1: {}", message);
    }
}