package com.example.demo.fanout;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

/*消息接受者*/
@Component
@RabbitListener(bindings = @QueueBinding(value = @Queue(
        value ="${mq.config.queue.info}",autoDelete = "true"),
        exchange=@Exchange(value = "${mq.config.exchange}",type = ExchangeTypes.FANOUT)
))
public class InfoReceiver {
    @RabbitHandler
    public void process(String hello) {
        System.out.println("InfoReceiver1 -----------订阅----------------------------- : " + hello);
    }
}
