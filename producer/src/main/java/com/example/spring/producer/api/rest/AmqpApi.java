package com.example.spring.producer.api.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring.producer.dto.MessageQueue;
import com.example.spring.producer.service.AmqpService;

@RestController
@RequestMapping("/api")
public class AmqpApi {

	@Autowired
	private AmqpService service;

	@PostMapping("/send")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public void sendToConsumer(@RequestBody MessageQueue message) {
		service.sendToConsumer(message);
	}

}