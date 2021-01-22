package com.example.spring.consumer.service.implamantation;

import org.springframework.stereotype.Component;

import com.example.spring.consumer.dto.Message;
import com.example.spring.consumer.service.ConsumerService;

@Component
public class ConsumerServiceImpl implements ConsumerService {

	@Override
	public void action(Message message) throws Exception {
		System.out.println(message.getText());
		throw new Exception("Error");
	}

}
