package com.toy.server.service.six;

import org.springframework.amqp.core.HeadersExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ghq on 2018/5/20.
 *
 * 这个交换器应该有问题，没有达到预想的结果
 */
@Component
public class Tut6Sender {

    @Autowired
    private HeadersExchange headersExchange;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send() {
        Map<String, Object> arguments = new HashMap<String, Object>();
        arguments.put("x-match", "any");
        arguments.put("user", "login");
        rabbitTemplate.convertAndSend(headersExchange.getName(), arguments);
    }
}
