package com.notify.v1.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.notify.v1.annotation.NotMissing;
import com.notify.v1.constant.DateFormatCons;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.PastOrPresent;
import lombok.*;
import org.hibernate.annotations.BatchSize;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "products")
@Data
@Builder
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor
@BatchSize(size = 100)
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

