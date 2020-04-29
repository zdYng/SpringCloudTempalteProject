package com.example.configclient.controller;


import com.example.configclient.message.StreamingClient;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class SendMessageController {

    @Autowired
    private StreamingClient streamingClient;

//    @GetMapping("/sendMessage")
//    public void process(){
//        String message = "now " + new Date();
//        streamingClient.output().send(MessageBuilder.withPayload(message).build());
//    }

    @GetMapping("/sendMessage")
    public void process(){
//        OrderDTO orderDTO = new OrderDTo();
        String message = "now " + new Date();
        streamingClient.output().send(MessageBuilder.withPayload(message).build());

    }

}
