package com.toy.server.config.mq.tut1;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by ghq on 2018/5/12.
 */
@Configuration
public class Tut1Config {

    @Bean
    @Qualifier("queue1")
    public Queue hello() {
        return new Queue("hello");
    }
}
