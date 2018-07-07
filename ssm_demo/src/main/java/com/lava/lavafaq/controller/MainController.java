package com.lava.lavafaq.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lava.lavafaq.rabbitmq.MessageSender;

@Controller
@RequestMapping("/rabbit")
public class MainController {

    // 注入消息生产者
    @Autowired
    private MessageSender messageSender;

    private Logger logger = LoggerFactory.getLogger(MessageSender.class);

    @RequestMapping(value = "/main")
    public String main() {
        return "null";
    }

    @RequestMapping(value = "/doValid")
    @ResponseBody
    public String doValid() {

        // 设置RoutingKey，匹配message.*即可
        messageSender.setRoutingKey("message.test");
        // 发送消息
        messageSender.sendDataToQueue("insert Queue");

        logger.info("to send message:{}","insert Queue");

        return "{\"key\" : \"value\"}";
    }
}
