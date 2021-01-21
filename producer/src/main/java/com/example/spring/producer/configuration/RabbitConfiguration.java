package com.example.spring.producer.configuration;

import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.StdDateFormat;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

@Configuration
public class RabbitConfiguration {

	@Autowired
	private ConnectionFactory connectionFactory;

	public SimpleRabbitListenerContainerFactory rabbitListener() {
		SimpleRabbitListenerContainerFactory rabbitListener = new SimpleRabbitListenerContainerFactory();
		rabbitListener.setConnectionFactory(this.connectionFactory);
		rabbitListener.setMessageConverter(this.jacksonConverter());
		
		return rabbitListener;
	}

	@Bean
	public RabbitTemplate rabbitTemplate() {
		RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
		rabbitTemplate.setMessageConverter(this.jacksonConverter());
		
		return rabbitTemplate;
	}

	@Bean
	Jackson2JsonMessageConverter jacksonConverter() {
		ObjectMapper jacksonMapper = Jackson2ObjectMapperBuilder.json()
				.modules(new JavaTimeModule())
				.dateFormat(new StdDateFormat())
				.build();
		
		return new Jackson2JsonMessageConverter(jacksonMapper);
	}

}
