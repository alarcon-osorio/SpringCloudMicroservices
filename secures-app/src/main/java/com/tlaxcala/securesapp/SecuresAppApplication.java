package com.tlaxcala.securesapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication(scanBasePackages = "com.tlaxcala.securesapp")
@ComponentScan("com.tlaxcala.securesapp")
@EnableFeignClients
public class SecuresAppApplication {

	private static final Logger logger = LoggerFactory.getLogger(SecuresAppApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SecuresAppApplication.class, args);
		logger.info("Application started successfully.");
	}

}
