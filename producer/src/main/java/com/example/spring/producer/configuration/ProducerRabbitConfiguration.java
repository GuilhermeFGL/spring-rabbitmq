package com.example.spring.producer.configuration;

import java.util.HashMap;
import java.util.Map;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProducerRabbitConfiguration {

	@Value("${pring.rabbitmq.request.routing-key.producer}")
	private String queue;

	@Value("${pring.rabbitmq.request.exchange.producer}")
	private String exchange;

	@Value("${pring.rabbitmq.request.deadletter.producer}")
	private String deadLetter;

	@Bean
	public DirectExchange exchange() {
		return new DirectExchange(this.exchange);
	}

	@Bean
	public Queue deadLetter() {
		return new Queue(this.deadLetter);
	}

	@Bean
	public Queue queue() {
		Map<String, Object> args = new HashMap<>();
		args.put("x-dead-letter-exchange", this.exchange);
		args.put("x-dead-letter-routing-key", this.deadLetter);

		return new Queue(this.queue, true, false, false, args);
	}

	@Bean
	public Binding bindingQueue() {
		return BindingBuilder.bind(this.queue()).to(this.exchange()).with(this.queue);
	}

	@Bean
	public Binding bindingDeadLetter() {
		return BindingBuilder.bind(this.queue()).to(this.exchange()).with(this.deadLetter);
	}

}
