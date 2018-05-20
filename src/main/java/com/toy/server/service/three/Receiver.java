package com.toy.server.service.three;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * Created by ghq on 2018/5/20.
 */
@Service
public class Receiver {

    /**
     * 假如生产了5条消息到交换器，交换器各放了5条到每个队列。
     * 队列1被一个消费者监听，所以这个消费者会消费全部的消息
     * 队列2被两个消费者监听，两个消费者会平均消费这5条消息
     */

    @RabbitListener(queues = "#{autoDeleteQueue0.name}")
    public void receiver2(String n) {
        System.out.println("receiver2:" + n);
    }

    @RabbitListener(queues = "#{autoDeleteQueue0.name}")
    public void receiver0(String n) {
        System.out.println("receiver0:" + n);
    }

    @RabbitListener(queues = "#{autoDeleteQueue1.name}")
    public void receiver1(String n) {
        System.out.println("receiver1:" + n);
    }

    /**
     *      输出结果：
     receiver1:hello world
     receiver0:hello world
     receiver2:hello world
     receiver2:hello world
     receiver0:hello world
     receiver0:hello world
     receiver1:hello world
     receiver1:hello world
     receiver1:hello world
     receiver1:hello world
     */
}
