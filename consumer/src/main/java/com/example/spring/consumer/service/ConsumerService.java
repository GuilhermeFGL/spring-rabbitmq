package com.example.spring.consumer.service;

import org.springframework.stereotype.Service;

import com.example.spring.consumer.dto.Message;

@Service
public interface ConsumerService {
	
	void action(Message message) throws Exception;

}
