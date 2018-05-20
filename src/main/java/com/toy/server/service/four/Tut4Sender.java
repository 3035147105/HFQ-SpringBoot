package com.toy.server.service.four;

import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by ghq on 2018/5/20.
 */
@Component
public class Tut4Sender {

    @Autowired
    private DirectExchange directExchange;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    private int index;

    private final String[] keys = {"orange", "black", "green"};

    public void send() {
        for (int i = 0; i < keys.length; i++) {
            StringBuilder builder = new StringBuilder("Hello to ");
            if (++this.index == 3) {
                this.index = 0;
            }

            String key = keys[index];
            builder.append(key);
            rabbitTemplate.convertAndSend(directExchange.getName(), key, builder.toString());
        }

    }
}
