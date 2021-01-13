package com.rabbitmq.example4;

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

    @GetMapping("/publish/error")
    public String error() {
        String message = "Error";
        log.info("publish error: {}", message);

        template.convertAndSend("error", message);

        return "publish error...";
    }

    @GetMapping("/publish/info")
    public String info() {
        String message = "Info";
        log.info("publish info: {}", message);

        template.convertAndSend("info", message);

        return "publish info...";
    }

    @GetMapping("/publish/warning")
    public String warning() {
        String message = "Warning";
        log.info("publish warning: {}", message);

        template.convertAndSend("warning", message);

        return "publish warning...";
    }
}