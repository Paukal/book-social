package com.project.bookservice.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class MyMessageListener {
    @RabbitListener(queues = "myQueue")
    public void receiveMsg(String message) {
        System.out.println("Received: " + message);
    }
}
