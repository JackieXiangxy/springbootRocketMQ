package com.qingyu.springboot.rocketmq.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Component(value = "testConsumer")
@Slf4j
public class ReceiveConsumer implements Consumer<Message<String>> {


    @Override
    public void accept(Message<String> stringMessage) {
        log.info("testConsumer消费消息{}", stringMessage);
    }
}
