package com.toy.server.service.one;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by ghq on 2018/5/12.
 */
@Component
public class Tut1Sender {

    @Autowired
    private RabbitTemplate rabbitTemplate;


    public void send() {
        String message = "Hello World";
        rabbitTemplate.convertAndSend("hello", message);
        System.out.println("Send Message：" + message);
    }
}
