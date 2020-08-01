package com.sivagtr.springbootproducer.producer.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;

@Configuration
@Getter
public class PropertiesConfig {
	@Value("${msg.topic}")
	private String msgTopic;

	@Value("${json.topic}")
	private String jsonTopic;

	@Value("${kafka.server}")
	private String kafkaServer;

	@Value("${key}")
	private String Key;

	@Value("${msgValue}")
	private String msgValue;
}
