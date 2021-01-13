package com.rabbitmq.example5;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Topic {
    @Bean
    public ConnectionFactory connectionFactory() {
        return new CachingConnectionFactory("localhost");
    }

    @Bean
    public AmqpAdmin amqpAdmin() {
        return new RabbitAdmin(connectionFactory());
    }

    @Bean
    public TopicExchange topicExchange(){
        return new TopicExchange("exchange5");
    }

    @Bean
    public RabbitTemplate rabbitTemplate() {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory());
        rabbitTemplate.setExchange("exchange5");

        return rabbitTemplate;
    }

    @Bean
    public Queue myQueue1() {
        return new Queue("queue5-1");
    }

    @Bean
    public Queue myQueue2() {
        return new Queue("queue5-2");
    }

    @Bean
    public Binding binding1(){
        return BindingBuilder.bind(myQueue1()).to(topicExchange()).with("*.orange.*");
    }

    @Bean
    public Binding binding2(){
        return BindingBuilder.bind(myQueue2()).to(topicExchange()).with("*.*.rabbit");
    }

    @Bean
    public Binding binding3(){
        return BindingBuilder.bind(myQueue2()).to(topicExchange()).with("lazy.#");
    }



    public static void main(String[] args) {
        SpringApplication.run(Topic.class, args);
    }
}
