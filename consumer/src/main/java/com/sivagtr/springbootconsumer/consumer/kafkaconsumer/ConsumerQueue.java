package com.sivagtr.springbootconsumer.consumer.kafkaconsumer;

import java.util.LinkedList;
import java.util.Queue;

import org.springframework.stereotype.Component;

import com.sivagtr.springbootconsumer.consumer.model.ConsumerMsgModel;

import lombok.Getter;
import lombok.Setter;

@Component
@Getter
@Setter
public class ConsumerQueue {
	private Queue<ConsumerMsgModel> receivedMsgs = new LinkedList<>();
}
