package com.example.configclient.message;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface StreamingClient {

    @Input("myMessage")
    SubscribableChannel input();

    @Output("myMessage")
    MessageChannel output();

}
