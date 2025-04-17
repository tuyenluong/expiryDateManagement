package com.ims.edm.expiryDateManagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan("com.ims.edm.expiryDateManagement.v1.entity")
@EnableJpaRepositories("com.ims.edm.expiryDateManagement.v1.repository")
@SpringBootApplication
public class ExpiryDateManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExpiryDateManagementApplication.class, args);
	}

}
