package com.toy.server.config.mq;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by ghq on 2018/5/20.
 *
 * headers  头交换器，用的不多
 */
@Configuration
public class Tut6Config {

    @Bean
    public HeadersExchange headersExchange() {
        return new HeadersExchange("headers-exchange");
    }

    @Bean
    public Queue autoDeleteQueue() {
        return new AnonymousQueue();
    }

    @Bean
    public Binding binding(HeadersExchange exchange, Queue autoDeleteQueue) {
        return BindingBuilder.bind(autoDeleteQueue)
                .to(exchange)
                .where("user")
                .exists();
    }
}
