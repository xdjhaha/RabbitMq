package com.example.demo;

import com.example.demo.topic.OrderSender;
import com.example.demo.topic.UserSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitMqTest {
    @Autowired
    OrderSender orderSender;

    @Autowired
    UserSender userSender;

    @Test
    public void send() throws Exception{
        //while (true){
            Thread.sleep(1000);
            this.orderSender.send();
            this.userSender.send();
        //}
    }
}
