package com.example.configclient.message;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

//接收mq消息
@Slf4j
@Component
public class MqReceiver {
//    1.@RabbitListener(queues = "myQueue")
    // 2.自动创建队列
//    @RabbitListener(queuesToDeclare = @Queue("myQueue"))
    //3. 自动创建Exchange和Queue绑定
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue("myQueue"),
            exchange = @Exchange("myExchange")

    ))
    public void process(String message){
        log.info("MqReceiver: {}", message);
    }

    // 数据接收队列 2
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue("computerOrder"),
            exchange = @Exchange("myOrder"),
            key = "computer"  //只接受computer消息

    ))
    public void processComputer(String message){
        log.info("computer MqReceiver: {}", message);
    }

    // 数据接收队列 3
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue("fruitOrder"),
            exchange = @Exchange("myOrder"),
            key = "fruit"  //只接受computer消息

    ))
    public void processFruit(String message){
        log.info("Fruit MqReceiver: {}", message);
    }

}
