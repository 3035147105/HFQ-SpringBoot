package com.toy.server.config.mq;

import com.toy.server.service.two.WorkReceiver;
import com.toy.server.service.two.WorkSend;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by ghq on 2018/5/12.
 */
@Configuration
public class Tut2Config {

    @Bean
    @Qualifier("queue2")
    public Queue workQueue() {
        return new Queue("work-queue-2");
    }

    @Bean
    public WorkReceiver workReceiver() {
        return new WorkReceiver("rev0");
    }

    @Bean
    public WorkReceiver workReceiver2() {
        return new WorkReceiver("rev1");
    }

    @Bean
    public WorkSend workSend() {
        return new WorkSend();
    }

    @Bean
    public SimpleRabbitListenerContainerFactory listenerContainerFactory() {
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory());
        factory.setPrefetchCount(0);
        return factory;
    }

    private ConnectionFactory connectionFactory() {
        CachingConnectionFactory factory = new CachingConnectionFactory("127.0.0.1");
        factory.setUsername("guest");
        factory.setPassword("guest");
        return factory;
    }
}
