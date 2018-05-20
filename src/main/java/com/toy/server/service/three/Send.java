package com.toy.server.service.three;

import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by ghq on 2018/5/20.
 */
@Service
public class Send {

    @Autowired
    private FanoutExchange fanoutExchange;

    @Autowired
    private RabbitTemplate template;

    public void send() {
        String message = "hello world";
        for (int i = 0; i < 5; i ++) {
            template.convertAndSend(fanoutExchange.getName(), "", message);
        }

    }
}
