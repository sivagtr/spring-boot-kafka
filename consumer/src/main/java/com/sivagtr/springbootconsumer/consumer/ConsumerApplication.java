package com.sivagtr.springbootconsumer.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sivagtr.springbootconsumer.consumer.kafkaconsumer.ConsumerKafkaReceiver;

@SpringBootApplication
public class ConsumerApplication {

	@Autowired
	ConsumerKafkaReceiver kafkaReceiver;

	public static void main(String[] args) {
		SpringApplication.run(ConsumerApplication.class, args);
	}

}
