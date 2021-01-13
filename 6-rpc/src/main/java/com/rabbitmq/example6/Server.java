package com.rabbitmq.example6;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Server {
    @RabbitListener(queues = "queue6")
    public String listen(String message) throws InterruptedException {
        log.info("Received on server : " + message);

        Thread.sleep(2000);

        return "after";
    }
}
