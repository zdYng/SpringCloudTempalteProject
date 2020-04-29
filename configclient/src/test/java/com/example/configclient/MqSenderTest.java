package com.example.configclient;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;


// send client
@RunWith(SpringRunner.class)
@SpringBootTest
@Component
public class MqSenderTest extends ConfigclientApplicationTests{
    @Autowired
    private AmqpTemplate amqpTemplate;

    @Test
    public void send(){
        amqpTemplate.convertAndSend("myQueue", "now" + new Date());

    }

    @Test
    public void sendOrder(){
        amqpTemplate.convertAndSend("myOrder","computer", "now" + new Date());

    }

}
