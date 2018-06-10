package rabbitmqdemo.direct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 控制器
 */
@RestController
@RequestMapping("/rabbit")
public class RabbitTest {
    @Autowired
    private HelloSender1 helloSender1;

    @PostMapping("/hello")
    public void hello() throws Exception{
            helloSender1.send();
    }
}
