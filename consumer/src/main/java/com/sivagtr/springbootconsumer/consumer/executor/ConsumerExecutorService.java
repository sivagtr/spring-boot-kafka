package com.sivagtr.springbootconsumer.consumer.executor;

import java.util.Arrays;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sivagtr.springbootconsumer.consumer.config.PropertiesConfig;
import com.sivagtr.springbootconsumer.consumer.kafkaconsumer.ConsumerQueue;
import com.sivagtr.springbootconsumer.consumer.model.ConsumerMsgModel;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ConsumerExecutorService {

	KafkaConsumer<String, String> kafkaConsumer;

	@Autowired
	private PropertiesConfig config;

	@Autowired
	private ConsumerQueue internalQueue;

	private void initializeKafkaConsumer(){
		if(kafkaConsumer == null) {
			Properties properties = getProperties();
			kafkaConsumer = new KafkaConsumer<String, String>(properties);
		}
	}

	private Properties getProperties(){
		Properties properties = new Properties();
		properties.put("bootstrap.servers", config.getKafkaServer());
		properties.put("key.deserializer", config.getKey());
		properties.put("value.deserializer", config.getMsgValue());
		properties.put("group.id", "1");
		return properties;
	}
	public void execute(){
		initializeKafkaConsumer();
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		executorService.execute(() -> {
			kafkaConsumer.subscribe(Arrays.asList(config.getMsgTopic()));
			try {
				while (true) {
					ConsumerRecords<String, String> records = kafkaConsumer.poll(100);
					for (ConsumerRecord record : records) {
						log.info(String.format("Record Key %s", record.key()));
						log.info(String.format("Record Value %s", record.value()));
						ConsumerMsgModel model = new ConsumerMsgModel();
						model.setKey((String) record.key());
						model.setValue((String) record.value());
						internalQueue.getReceivedMsgs().add(model);
					}
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			} finally {
				kafkaConsumer.close();
			}
		});
	}


}
