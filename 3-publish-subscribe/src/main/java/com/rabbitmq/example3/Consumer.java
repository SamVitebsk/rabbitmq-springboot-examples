package com.rabbitmq.example3;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Consumer {
    @RabbitListener(queues = "queue3-1")
    public void worker1(String message) {
        log.info("listener 1 : {}", message);
    }

    @RabbitListener(queues = "queue3-2")
    public void worker2(String message) {
        log.info("listener 2 : {}", message);
    }
}
