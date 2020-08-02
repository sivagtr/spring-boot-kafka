package com.sivagtr.springbootconsumer.consumer.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sivagtr.springbootconsumer.consumer.kafkaconsumer.ConsumerQueue;
import com.sivagtr.springbootconsumer.consumer.model.ConsumerMsgModel;

@RestController
@RequestMapping("kafka")
public class ConsumerController {

	@Autowired
	ConsumerQueue kafkaReceiver;

	@GetMapping("/msg")
	public List<String> getMsg(){
		List<String> collect = kafkaReceiver.getReceivedMsgs().stream().map(ConsumerMsgModel::getValue).collect(Collectors.toList());
		kafkaReceiver.getReceivedMsgs().clear();
		return collect;
	}
}
