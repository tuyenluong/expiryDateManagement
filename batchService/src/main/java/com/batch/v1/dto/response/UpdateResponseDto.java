package com.batch.v1.dto.response;

import lombok.Data;

@Data
public class UpdateResponseDto {

    private String sku;

    private String expiryDate;

    private String productionDate;

    private String message;
}
