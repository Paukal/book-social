package com.project.bookservice.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class MyMessageProducer {
    private final RabbitTemplate rabbitTemplate;
    public MyMessageProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }
    public void sendMsg(String message) {
        rabbitTemplate.convertAndSend("myQueue", message);
    }
}
