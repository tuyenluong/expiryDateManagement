package com.ims.edm.v1.product.repository;

import com.ims.edm.v1.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, Long> {

    Product findByUUID(UUID id);
    Product findBySku(String sku);
}
