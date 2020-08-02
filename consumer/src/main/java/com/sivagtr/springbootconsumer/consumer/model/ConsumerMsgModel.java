package com.sivagtr.springbootconsumer.consumer.model;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
@Getter
@Setter
public class ConsumerMsgModel {
	private String key;
	private String value;
}
