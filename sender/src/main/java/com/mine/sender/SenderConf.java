package com.mine.sender;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.naming.NamingEnumeration;

/**
 * @创建人 Oliver.Liu
 * @创建时间 3/19/2019
 * @描述
 */
@Configuration
public class SenderConf {
    @Bean
    public Queue queue(){
        //由于采用的是Direct模式,需要在配置Queue的时候,指定一个键,使其和交换机绑定.
        return new Queue("directqueue");
    }
    //Topic转发模式)
    //首先我们看发送端,我们需要配置队列Queue,再配置交换机(Exchange),再把队列按照相应的规则绑定到交换机上
    @Bean(name = "message")
    public Queue queueMessage(){
        return new Queue("topic.message");
    }
    @Bean(name = "messages")
    public Queue queueMessages(){
        return new Queue("topic.messages");
    }
    @Bean
    public TopicExchange exchange(){
        return new TopicExchange("exchange");
    }
    @Bean
    Binding bindingExchangeMessage(@Qualifier("message") Queue queueMessage, TopicExchange exchange) {
        return BindingBuilder.bind(queueMessage).to(exchange).with("topic.message");
    }
    @Bean
    Binding bindingExchangeMessages(@Qualifier("messages") Queue queueMessage, TopicExchange exchange) {
        return BindingBuilder.bind(queueMessage).to(exchange).with("topic.*");//*表示一个词,#表示零个或多个词
    }
    //Fanout Exchange形式又叫广播形式,因此我们发送到路由器的消息会使得绑定到该路由器的每一个Queue接收到消息,
    //这个时候就算指定了Key,或者规则(即上文中convertAndSend方法的参数2)
    @Bean(name="Amessage")
    public Queue AMessage() {
        return new Queue("fanout.A");
    }
    @Bean(name="Bmessage")
    public Queue BMessage() {
        return new Queue("fanout.B");
    }
    @Bean(name="Cmessage")
    public Queue CMessage() {
        return new Queue("fanout.C");
    }
    @Bean
    FanoutExchange fanoutExchange() {
        return new FanoutExchange("fanoutExchange");//配置广播路由器
    }
    @Bean
    Binding bindingExchangeA(@Qualifier("Amessage") Queue AMessage,FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(AMessage).to(fanoutExchange);
    }
    @Bean
    Binding bindingExchangeB(@Qualifier("Bmessage") Queue BMessage, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(BMessage).to(fanoutExchange);
    }
    @Bean
    Binding bindingExchangeC(@Qualifier("Cmessage") Queue CMessage, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(CMessage).to(fanoutExchange);
    }
}
