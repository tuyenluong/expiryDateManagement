package com.ims.product.v1.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ProductDto {

    private String sku;
    private String name;
    private LocalDate expiryDate;
    private LocalDate productionDate;
}
