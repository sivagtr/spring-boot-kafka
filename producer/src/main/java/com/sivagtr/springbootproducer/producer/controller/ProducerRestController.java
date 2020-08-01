package com.sivagtr.springbootproducer.producer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sivagtr.springbootproducer.producer.kafkamsg.ProducerApacheKafkaMsgSender;
import com.sivagtr.springbootproducer.producer.model.InformationModel;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("kafka")
public class ProducerRestController {

	@Autowired
	private ProducerApacheKafkaMsgSender kafkaMsgSender;

	@PostMapping("/msg")
	public void sendMsg(@RequestBody String msg) {
		log.info("Received msg : " + msg);
		kafkaMsgSender.initializeKafkaPrducer();
		kafkaMsgSender.sendMsg(msg);
	}

	@PostMapping("/information")
	public void sendJsonMsg(@RequestBody InformationModel informationModel){
		log.info("Received Json : " + informationModel);
		kafkaMsgSender.initializeKafkaPrducer();
		kafkaMsgSender.sendJson(informationModel);
	}
}
