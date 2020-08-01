package com.sivagtr.springbootconsumer.consumer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sivagtr.springbootconsumer.consumer.kafkaconsumer.ConsumerKafkaReceiver;

@RestController
@RequestMapping("kafka")
public class ConsumerController {

	@Autowired
	ConsumerKafkaReceiver kafkaReceiver;
	@GetMapping("/msg")
	public List<String> getMsg(){
		return kafkaReceiver.getMsgList();
	}
}
