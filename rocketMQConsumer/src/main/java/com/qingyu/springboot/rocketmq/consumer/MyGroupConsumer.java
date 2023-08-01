package com.qingyu.springboot.rocketmq.consumer;


import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

/**
 * @author jackie
 */
@Component(value = "myGroup")
@Slf4j
public class MyGroupConsumer implements Consumer<Message<String>> {

    @Override
    public void accept(Message<String> stringMessage) {

        log.info("myGroup消费消息：{}", stringMessage);


    }
}
