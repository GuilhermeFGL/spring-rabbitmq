package com.example.spring.producer.amqp;

import org.springframework.stereotype.Service;

@Service
public interface AmqpProducer<T> {
	
	void producer(T t);

}
