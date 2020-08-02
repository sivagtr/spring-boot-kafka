package com.sivagtr.springbootconsumer.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sivagtr.springbootconsumer.consumer.executor.ConsumerExecutorService;

@SpringBootApplication
public class ConsumerApplication implements CommandLineRunner {

	@Autowired
	ConsumerExecutorService executorService;

	public static void main(String[] args) {
		SpringApplication.run(ConsumerApplication.class, args);
	}

	/**
	 * Callback used to run the bean.
	 *
	 * @param args incoming main method arguments
	 * @throws Exception on error
	 */
	@Override
	public void run(String... args) throws Exception {
		executorService.execute();
	}
}
