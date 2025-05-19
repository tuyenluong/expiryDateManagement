package com.product.v1.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.product.v1.annotation.NotMissing;
import com.product.v1.constant.DateFormatCons;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "products")
@Data
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "sku", length = 50)
    @NotMissing
    private String sku;

    @Column(nullable = false, length = 100)
    @NotMissing
    private String name;

    @Column(name = "expiry_date")
    @Future(message = "EXPIRY_DATE must not in the present or the past")
    @JsonFormat(pattern = DateFormatCons.YYYY_MM_DD_HYPHEN)
    private LocalDate expiryDate;

    @Column(name = "production_date")
    @PastOrPresent(message = "PRODUCTION_DATE must not in the future")
    @JsonFormat(pattern = DateFormatCons.YYYY_MM_DD_HYPHEN)
    private LocalDate productionDate;
}

