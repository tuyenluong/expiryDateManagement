package com.ims.product.v1.repository;

import com.ims.product.v1.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {

    Optional<Product> findByUuid(UUID id);
    Optional<Product> findBySku(String sku);
}
