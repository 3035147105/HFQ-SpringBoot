package com.toy.server.service.one;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by ghq on 2018/5/12.
 */
@Component
@RabbitListener(queues = {"hello"})
public class Tut1Receiver {

    @RabbitHandler
    public void receive(String in) {
        System.out.println("Received message: " + in);
    }
}
