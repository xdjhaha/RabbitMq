package rabbitmqdemo.direct;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

/*消息接受者*/
@Component
@RabbitListener(bindings = @QueueBinding(value = @Queue(
        value ="${mq.config.queue.info}",autoDelete = "true"),
        exchange=@Exchange(value = "${mq.config.exchange}",type = ExchangeTypes.DIRECT),
        key = "${mq.config.queue.info.routing.key}"
))
public class InfoReceiver {
    @RabbitHandler
    public void process(String hello) {
        System.out.println("InfoReceiver1 ---------------------------------------- : " + hello);
    }
}
