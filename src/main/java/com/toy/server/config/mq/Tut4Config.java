package com.toy.server.config.mq;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * Created by ghq on 2018/5/20.
 *
 * direct  直连交换器
 * 交换器 只将 "符合规则" 的消息放到 队列
 * 当多个队列对 "同一个路由" 感兴趣时，就相当于 fanout
 *
 *
 * 就是研究  交换器 和 队列 的关系
 */
@Configuration
public class Tut4Config {

    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange("direct-exchange");
    }

    @Bean
    public Queue autoDeleteQueue0() {
        return new AnonymousQueue();
    }

    @Bean
    public Queue autoDeleteQueue1() {
        return new AnonymousQueue();
    }

    // 队列0可以接收black和orange
    @Bean
    public Binding binding0a(DirectExchange directExchange, Queue autoDeleteQueue0) {
        return BindingBuilder.bind(autoDeleteQueue0)
                .to(directExchange)
                .with("black");
    }

    @Bean
    public Binding binding0b(DirectExchange directExchange, Queue autoDeleteQueue0) {
        return BindingBuilder.bind(autoDeleteQueue0)
                .to(directExchange)
                .with("orange");
    }

    // 队列1可以接收green 和 orange
    @Bean
    public Binding binding1a(DirectExchange directExchange, Queue autoDeleteQueue1) {
        return BindingBuilder.bind(autoDeleteQueue1)
                .to(directExchange)
                .with("green");
    }

    @Bean
    public Binding binding1b(DirectExchange directExchange, Queue autoDeleteQueue1) {
        return BindingBuilder.bind(autoDeleteQueue1)
                .to(directExchange)
                .with("orange");
    }
}
