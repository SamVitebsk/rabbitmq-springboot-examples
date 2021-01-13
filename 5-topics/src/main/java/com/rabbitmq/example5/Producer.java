package com.rabbitmq.example5;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class Producer {
    private final RabbitTemplate template;

    @GetMapping("/publish/{key}/{message}")
    public String publish(@PathVariable("key") String key, @PathVariable("message") String message) {
        log.info("publish message: {} to: {}", message, key);

        template.convertAndSend(key, message);

        return String.format("publish message: %s to: %s", message, key);
    }
}


























//        /publish/quick.orange.rabbit/test-message
//        /publish/lazy.orange.elephant/test-message
//        /publish/quick.orange.fox/test-message
//        /publish/lazy.brown.fox/test-message