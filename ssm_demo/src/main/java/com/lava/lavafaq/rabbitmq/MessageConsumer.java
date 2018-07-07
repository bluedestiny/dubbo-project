package com.lava.lavafaq.rabbitmq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lava.lavafaq.service.OrderService;
@Component
public class MessageConsumer implements MessageListener,OrderService {

    private Logger logger = LoggerFactory.getLogger(MessageConsumer.class);
//    @Autowired
//    private OrderMapper orderMapper;
    @Override
    public void onMessage(Message message) {
        createOrder();
        logger.info("receive message:{}",message);
    }

    @Override
    public void createOrder() {
            //创建订单
            System.out.println("--------------------------");
            System.out.println("进入创建订单");
    }

    

}
