package com.qingyu.springboot.rocketmq.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.qingyu.springboot.rocketmq.controller.producer.SenderProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RequestMapping("/message")
@RestController
@Slf4j
public class CloudController {
    @Autowired
    private SenderProducer senderService;

    @RequestMapping("/senderService")
    public String sendNormalMsg() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        Map<String, Object> jsonMap = new HashMap<>();
        jsonMap.put("id", UUID.randomUUID().toString().replaceAll("-", ""));
        jsonMap.put("name", "zhang");
        jsonMap.put("password", "123");
        jsonMap.put("age", "23");
        jsonMap.put("date", LocalDateTime.now());
        String json = objectMapper.writeValueAsString(jsonMap);
        senderService.sendMessage(json);
        log.info("{}", json);
        return json;
    }
}
