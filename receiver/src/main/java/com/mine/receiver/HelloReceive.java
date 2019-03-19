package com.mine.receiver;

import com.mine.base.bean.Hello;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
/**
 * @创建人 Oliver.Liu
 * @创建时间 3/19/2019
 * @描述
 */
@Component
public class HelloReceive {
    @RabbitListener(queues = "directqueue")
    public void process(String str){
        System.out.println("Receive:"+str);
    }
    //@RabbitListener(queues = "directqueue")
    public void processObj(Hello hello){
        System.out.println("Receive:"+hello);
    }

    @RabbitListener(queues="topic.message")    //监听器监听指定的Queue
    public void processMsg(String str) {
        System.out.println("message:"+str);
    }
    @RabbitListener(queues="topic.messages")    //监听器监听指定的Queue
    public void processMsgs(String str) {
        System.out.println("messages:"+str);
    }
    @RabbitListener(queues="fanout.A")
    public void processA(String str1) {
        System.out.println("ReceiveA:"+str1);
    }
    @RabbitListener(queues="fanout.B")
    public void processB(String str) {
        System.out.println("ReceiveB:"+str);
    }
    @RabbitListener(queues="fanout.C")
    public void processC(String str) {
        System.out.println("ReceiveC:"+str);
    }
}
