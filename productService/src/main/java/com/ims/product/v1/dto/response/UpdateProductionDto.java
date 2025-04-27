package com.ims.product.v1.dto.response;

import lombok.Data;

import java.time.LocalDate;

@Data
public class UpdateProductionDto {

    private String sku;
    private String name;
    private LocalDate productionDate;
    private String message;
}
