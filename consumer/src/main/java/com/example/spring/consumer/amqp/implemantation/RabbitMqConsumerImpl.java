package com.example.spring.consumer.amqp.implemantation;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.spring.consumer.amqp.AmqpConsumer;
import com.example.spring.consumer.dto.Message;
import com.example.spring.consumer.service.ConsumerService;

@Component
public class RabbitMqConsumerImpl implements AmqpConsumer<Message> {
	
	@Autowired
	private ConsumerService consumerService;
	
	@Override
	@RabbitListener(queues = "${spring.rabbitmq.request.routing-key.producer}")
	public void consumer(Message message) {
		this.consumerService.action(message);
	}

}
