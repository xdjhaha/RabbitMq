package com.example.demo.fanout;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

/*消息接受者*/
@Component
@RabbitListener(bindings = @QueueBinding(value = @Queue(
        value ="${mq.config.queue.error}",autoDelete = "true"),
        exchange=@Exchange(value = "${mq.config.exchange}",type = ExchangeTypes.FANOUT)))
public class ErrorReceiver {
    @RabbitHandler
    public void process(String hello) {
        System.out.println("errorReceiver1 --------------订阅-------------------------- : " + hello);
    }
}
