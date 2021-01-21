package com.example.spring.producer.service;
import org.springframework.stereotype.Service;

import com.example.spring.producer.dto.MessageQueue;

@Service
public interface AmqpService {

	void sendToConsumer(MessageQueue message);

}
