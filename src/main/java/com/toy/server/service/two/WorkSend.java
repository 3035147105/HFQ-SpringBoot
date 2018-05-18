package com.toy.server.service.two;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Created by ghq on 2018/5/18.
 */
@Component
public class WorkSend {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    @Qualifier("queue2")
    private Queue queue;

    public void send() {
        for (int i = 0; i < 10; i++) {
            String msg = "你好" + i;
            rabbitTemplate.convertAndSend(queue.getName(), msg);
        }
    }
}
