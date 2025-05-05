package com.ims.product.v1.dto.request;

import com.ims.product.v1.annotation.DateFormat;
import com.ims.product.v1.constant.DateFormatCons;
import lombok.Data;

@Data
public class UpdateRequestDto {

    @DateFormat(pattern = DateFormatCons.YYYY_MM_DD_HYPHEN)
    private String expiryDate;

    @DateFormat(pattern = DateFormatCons.YYYY_MM_DD_HYPHEN)
    private String productionDate;
}
