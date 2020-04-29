package com.example.configclient.message;


import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(StreamingClient.class)
@Slf4j
public class StreamReceiver {

    @StreamListener("myMessage")
    public void process(Object message){
        log.info("StreamReceiver: {}",message);
    }


}
