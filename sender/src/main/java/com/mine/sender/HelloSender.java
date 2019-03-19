package com.mine.sender;

import com.mine.base.bean.Hello;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @创建人 Oliver.Liu
 * @创建时间 3/19/2019
 * @描述
 */
@Component
public class HelloSender {
    @Autowired
    private AmqpTemplate template;

    public void sendDirect() {
        Hello hello = new Hello();
        hello.setFldStr("fldStr");
        hello.setFldInt(100);
        hello.setFldBool(false);
        //template.convertAndSend("directqueue", hello);
        template.convertAndSend("directqueue", "hello, rabbit~");
    }
    public void sendTopic() {
        template.convertAndSend("exchange","topic.message", "hello, rabbit~message~");
        template.convertAndSend("exchange","topic.messages", "hello, rabbit~messages~");
    }
    public void sendFanout() {
        template.convertAndSend("fanoutExchange","", "hello, rabbit~fanoutMessage~");
        template.convertAndSend("fanoutExchange","", "hello, rabbit~fanoutMessages~");
    }
}
