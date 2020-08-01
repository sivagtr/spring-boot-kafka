package com.sivagtr.springbootconsumer.consumer.kafkaconsumer;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Component;

import lombok.Getter;

@Component
@Getter
public class ConsumerKafkaReceiver {

	private List<String> msgList = new LinkedList<>();


}
