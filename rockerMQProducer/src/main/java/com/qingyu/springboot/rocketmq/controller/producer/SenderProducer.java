package com.qingyu.springboot.rocketmq.controller.producer;

import lombok.AllArgsConstructor;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Component;

/**
 * @author jackie
 */
@Component
@AllArgsConstructor
public class SenderProducer {

    private final static String bindingName = "testConsumer-out-0";

    private final StreamBridge streamBridge;

    public void sendMessage(String data) {
        streamBridge.send(bindingName, data);
    }
}
