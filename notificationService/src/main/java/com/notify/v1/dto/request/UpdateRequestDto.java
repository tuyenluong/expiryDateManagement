package com.notify.v1.dto.request;

import com.notify.v1.annotation.DateFormat;
import com.notify.v1.annotation.NotContainsSpace;
import com.notify.v1.constant.DateFormatCons;
import lombok.Data;

@Data
public class UpdateRequestDto {

    @DateFormat(pattern = DateFormatCons.YYYY_MM_DD_HYPHEN)
    @NotContainsSpace
    private String expiryDate;

    @DateFormat(pattern = DateFormatCons.YYYY_MM_DD_HYPHEN)
    @NotContainsSpace
    private String productionDate;
}
