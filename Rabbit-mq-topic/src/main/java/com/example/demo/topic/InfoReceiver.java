package com.example.demo.topic;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

/*消息接受者*/
@Component
@RabbitListener(bindings = @QueueBinding(value = @Queue(
        value ="${mq.config.queue.info}",autoDelete = "true"),
        exchange=@Exchange(value = "${mq.config.exchange}",type = ExchangeTypes.TOPIC),
        key = "log.info.#"
))
public class InfoReceiver {
    @RabbitHandler
    public void process(String hello) {
        System.out.println("InfoReceiver1 ---------------------------------------- : " + hello);
    }
}
