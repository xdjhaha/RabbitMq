package com.rabbitmqdemo.demo.young;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/*消息接受者*/
@Component
public class HelloReceiver1 {

    @RabbitListener(queues = "helloQueue") //绑定路由键
    public void process(String hello) {
        System.out.println("Receiver1 ---------------------------------------- : " + hello);
    }
}
