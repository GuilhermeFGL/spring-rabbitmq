package com.example.spring.consumer.amqp;

import org.springframework.stereotype.Service;

@Service
public interface AmqpConsumer<T> {
	
	void consumer(T t);

}
