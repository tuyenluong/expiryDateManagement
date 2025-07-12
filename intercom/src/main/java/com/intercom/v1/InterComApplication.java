package com.intercom.v1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class InterComApplication {

	public static void main(String[] args) {
		SpringApplication.run(InterComApplication.class, args);
	}

}
