/*
package com.qingyu.springboot.rocketmq.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.apache.rocketmq.spring.core.RocketMQLocalRequestCallback;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("test")
public class TestController {

    private final static Logger log = LoggerFactory.getLogger(TestController.class);

    private final static String topic = "rocketMQ-test-topic1";

    @Autowired
    private RocketMQTemplate mqTemplate;

    @GetMapping("/rocket")
    public String testRocketMQ() throws JsonProcessingException {
        Map<String, Object> jsonMap = new HashMap<>();
        jsonMap.put("id", UUID.randomUUID().toString().replaceAll("-", ""));
        jsonMap.put("name", "zhang");
        jsonMap.put("password", "123");
        jsonMap.put("age", "23");
        jsonMap.put("date", LocalDateTime.now());

        mqTemplate.syncSend(topic, jsonMap);
        return "success";
    }

    @GetMapping("/send-all")
    public void sendAll() {
        new Thread(() -> {
            while (true) {
                try {
                    rocketTest1();
                    TimeUnit.MICROSECONDS.sleep(10);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();
    }


    @GetMapping("/rocket-test1")
    public String rocketTest1() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        Map<String, Object> jsonMap = new HashMap<>();
        jsonMap.put("id", UUID.randomUUID().toString().replaceAll("-", ""));
        jsonMap.put("name", "zhang");
        jsonMap.put("password", "123");
        jsonMap.put("age", "23");
        jsonMap.put("date", LocalDateTime.now());
        String json = objectMapper.writeValueAsString(jsonMap);
        mqTemplate.sendAndReceive(topic, json, new RocketMQLocalRequestCallback<String>() {
            @Override
            public void onSuccess(String o) {
                log.info("消息处理成功：{}", o);

            }

            @Override
            public void onException(Throwable throwable) {
                log.error("消息处失败：{}", throwable.getMessage());
            }
        });
        return json;
    }


}
*/
