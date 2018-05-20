package com.toy.server.config.mq;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by ghq on 2018/5/20.
 *
 * 采用Fanout交换器实现发布与订阅
 * 生产者不知道队列的存在。生产者将消息发给交换器
 */
@Configuration
public class Tu3Config {

    // 定义扇出交换器
    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange("fanout-exchange");
    }

    // 定义匿名队列
    @Bean
    public Queue autoDeleteQueue0() {
        return new AnonymousQueue();
    }

    @Bean
    public Queue autoDeleteQueue1() {
        return new AnonymousQueue();
    }

    // 将匿名队列绑定到交换器上
    @Bean
    public Binding binding0(FanoutExchange exchange, Queue autoDeleteQueue0) {
        return BindingBuilder.bind(autoDeleteQueue0).to(exchange);
    }

    @Bean
    public Binding binding1(FanoutExchange exchange, Queue autoDeleteQueue1) {
        return BindingBuilder.bind(autoDeleteQueue1).to(exchange);
    }


}
