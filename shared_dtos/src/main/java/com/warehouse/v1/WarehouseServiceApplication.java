package com.warehouse.v1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


//@EntityScan("com.ims.edm.expiryDateManagement.v1.warehouse.entity")
//@EnableJpaRepositories("com.ims.edm.expiryDateManagement.v1.warehouse.repository")
@SpringBootApplication
public class WarehouseServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(WarehouseServiceApplication.class, args);
    }

}