package com.example.demo.Direct;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 消息生产者*/
@Component
public class HelloSender1 {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    //设置交换器
    @Value("${mq.config.exchange}")
    private String exchange;

    public void send() {
        String sendMsg = "hello1 " + new Date();
        System.out.println("Sender1 : " + sendMsg+"11111111111111111111111111");
        this.rabbitTemplate.convertAndSend(this.exchange, "log.error.routing.key",sendMsg);// 路由键 和 发送的内容
    }
}
