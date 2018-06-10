package com.rabbitmqdemo.demo.young;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.amqp.core.Queue;

@Configuration
public class SendConfig {
    @Bean
    public Queue aganqueue(){
        return new Queue("helloQueue"); //创建一个名为 helloQueue 的队列
    }
}
