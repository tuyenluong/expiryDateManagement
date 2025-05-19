package com.product.v1.dto.request;

import com.product.v1.annotation.DateFormat;
import com.product.v1.annotation.NotContainsSpace;
import com.product.v1.annotation.NotMissing;
import com.product.v1.constant.DateFormatCons;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ProductDto {

    @Size(min = 7, max = 7, message = "SKU must equals to 7 characters")
    @NotMissing(message = "SKU must not be NULL, EMPTY or BLANK")
    @NotContainsSpace
    private String sku;

    @NotMissing(message = "NAME must not be NULL, EMPTY or BLANK")
    private String name;

    @DateFormat(pattern = DateFormatCons.YYYY_MM_DD_HYPHEN)
    @NotContainsSpace
    private String expiryDate;

    @DateFormat(pattern = DateFormatCons.YYYY_MM_DD_HYPHEN)
    @NotContainsSpace
    private String productionDate;
}
