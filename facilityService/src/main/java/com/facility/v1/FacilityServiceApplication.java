package com.facility.v1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@EntityScan("com.facility.v1.model")
@EnableJpaRepositories("com.facility.v1.repository")
@SpringBootApplication
@EnableDiscoveryClient()
public class FacilityServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(FacilityServiceApplication.class, args);
    }

}