package rabbitmqdemo.direct;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitMqTest {
    @Autowired
    HelloSender1 helloSender1;

    @Test
    public void send() throws Exception{
        while (true){
            Thread.sleep(1000);
            this.helloSender1.send();
        }
    }
}
