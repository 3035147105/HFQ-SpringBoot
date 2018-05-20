package com.toy.server.config.mq;

import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by ghq on 2018/5/20.
 *
 * topic  主题交换器，
 *
 * 规则："*"表示一个字符，"#"表示0个或多个
 *
 * 最灵活的交换器；当一个队列和"#"绑定键绑定时，该队列能收到所有消息，这点与fanout交换器类似；
 * 当不使用"#"和"*"时，与direct交换器类似
 */
@Configuration
public class Tut5Config {

    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange("topic-exchange");
    }



}
