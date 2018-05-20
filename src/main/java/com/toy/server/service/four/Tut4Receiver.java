package com.toy.server.service.four;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by ghq on 2018/5/20.
 */
@Component
public class Tut4Receiver {

    // queue0监听路由是black和orange的消息
    @RabbitListener(queues = "#{autoDeleteQueue0.name}")
    public void receiver0(String n) {
        System.out.println("receiver0:" + n);
    }

    // queue1监听路由是green和orange的消息
    @RabbitListener(queues = "#{autoDeleteQueue1.name}")
    public void receiver1(String n) {
        System.out.println("receiver1:" + n);
    }
}
