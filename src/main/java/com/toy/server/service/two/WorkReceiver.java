package com.toy.server.service.two;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by ghq on 2018/5/18.
 */
@Component
public class WorkReceiver {

    private String name;

    public WorkReceiver(String name) {
        this.name = name;
    }

    // 监听名字为work-queue-2的队列，接收到消息后会把消息 “循环分发” 到消费者

    // notice: 默认 队列会均匀的往两个消费者中放 相等数量的消息
    @RabbitListener(queues = "work-queue-2", containerFactory = "listenerContainerFactory")
    public void receive(String n) {
       if (name.equals("rev1")) {
           try {
               Thread.sleep(500);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
       }
        System.out.println(name.concat("======:").concat(n));
    }
}
