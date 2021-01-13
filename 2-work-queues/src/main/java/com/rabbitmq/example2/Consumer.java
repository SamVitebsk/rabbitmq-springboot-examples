package com.rabbitmq.example2;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Random;

@Slf4j
@Component
public class Consumer {
    @RabbitListener(queues = "queue2")
    public void listener1(String message) throws InterruptedException {
        log.info("listener 1 : {}",  message);
        Thread.sleep(1500);
    }

    @RabbitListener(queues = "queue2")
    public void listener2(String message) throws InterruptedException {
        log.info("listener 2 : {}", message);
        Thread.sleep(2000);
    }
}
