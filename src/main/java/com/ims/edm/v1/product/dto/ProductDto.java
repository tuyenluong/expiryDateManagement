package com.ims.edm.v1.product.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ProductDto {

    private String sku;
    private String name;
    private LocalDate expiryDate;
    private LocalDate productionDate;
}
