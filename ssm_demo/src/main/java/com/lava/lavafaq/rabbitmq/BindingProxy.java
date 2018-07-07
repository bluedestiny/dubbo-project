package com.lava.lavafaq.rabbitmq;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.TopicExchange;

import com.rabbitmq.client.impl.AMQImpl.Queue;



public class BindingProxy {
	private org.springframework.amqp.core.Queue queue;

    private TopicExchange exchange;

    public void setQueue(org.springframework.amqp.core.Queue queue) {
        this.queue = queue;
    }

    public void setExchange(TopicExchange exchange) {
        this.exchange = exchange;
    }

    public Binding getBinding(){
        return BindingBuilder.bind(queue).to(exchange).with(queue.getName());
    }
}
