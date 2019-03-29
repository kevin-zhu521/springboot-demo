package com.xiaoi.receive;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * @author kevin.zhu
 * @date 2019/3/26 20:59
 */
@Service
public class MessageReceive {


    @RabbitListener(bindings = {@QueueBinding(value = @Queue(value = "directQueue1"),
            exchange = @Exchange(value = "directExchange"),
            key = "key1")})
    public void receive1(String msg){
        System.out.println(msg);
    }

    @RabbitListener(bindings = {@QueueBinding(value = @Queue(value = "directQueue2"),
            exchange = @Exchange(value = "directExchange"),
            key = "key2")})
    public void receive2(String msg){
        System.out.println(msg);
    }

    @RabbitListener(bindings = {@QueueBinding(value = @Queue(value = "topicQueue1"),
            exchange = @Exchange(value = "topicExchange"))})
    public void receive3(String msg){
        System.out.println(msg);
    }
    
    @RabbitListener(bindings = {@QueueBinding(value = @Queue(value = "topicQueue2"),
            exchange = @Exchange(value = "topicExchange"))})
    public void receive4(String msg){
        System.out.println(msg);
    }

}
