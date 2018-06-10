package com.example.demo.topic;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 消息生产者*/
@Component
public class OrderSender {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    //设置交换器
    @Value("${mq.config.exchange}")
    private String exchange;

    public void send() {
        String sendMsg = "hello1 " + new Date();
        System.out.println("Sender1 : " + sendMsg+"------------order");
        this.rabbitTemplate.convertAndSend(this.exchange, "log.error.routing.key",sendMsg+"order   error");// 路由键 和 发送的内容
        this.rabbitTemplate.convertAndSend(this.exchange, "log.info.routing.key",sendMsg+"order   info");
        //this.rabbitTemplate.convertAndSend(this.exchange, "log.all.routing.key",sendMsg+"order   all");
    }
}
