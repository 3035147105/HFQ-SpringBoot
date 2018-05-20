package com.toy.server.service.six;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by ghq on 2018/5/20.
 */
@Component
public class Tut6Receiver {

    @RabbitListener(queues = "#{autoDeleteQueue.name}")
    public void receiver(String n) {
        System.out.println("receiver:" + n);
    }
}
