package com.example.demo.topic;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

/*消息接受者*/
@Component
@RabbitListener(bindings = @QueueBinding(value = @Queue(
        value ="${mq.config.queue.all}",autoDelete = "true"),
        exchange=@Exchange(value = "${mq.config.exchange}",type = ExchangeTypes.TOPIC),
        key = "#.log.#"
))
public class AllReceiver {
    @RabbitHandler
    public void process(String hello) {
        System.out.println("allReceiver1 ---------------------------------------- : " + hello);
    }
}
