package com.rabbitmq.example4;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Consumer {
    @RabbitListener(queues = "queue4-1")
    public void listener1(String message) {
        log.info("listener 1 : {}", message);
    }

    @RabbitListener(queues = "queue4-2")
    public void listener2(String message) {
        log.info("listener 2 : {}", message);
    }
}
