package com.user.v1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


//@EntityScan("com.ims.edm.expiryDateManagement.v1.user.entity")
//@EnableJpaRepositories("com.ims.edm.expiryDateManagement.v1.user.repository")
@SpringBootApplication
@EnableDiscoveryClient
public class UserServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserServiceApplication.class, args);
    }

}