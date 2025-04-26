package com.ims.product.v1.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "products")
@Setter
@Getter
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "product_id")
    private UUID uuid;

    @Column(length = 50)
    private String sku;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(name = "expiry_date")
    private LocalDate expiryDate;

    @Column(name = "production_date")
    private LocalDate productionDate;
}

