package com.shishi.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableBinding(Sink.class)
@Slf4j
public class MessageReceiveController {

    @Value("${server.port}")
    private String bindPort;

    @StreamListener(Sink.INPUT)
    public void inputMessage(Message<String> message){
        log.info("2 received serial is ："+message.getPayload()+"\t  port:"+bindPort);
    }
}
