package com.ims.edm.expiryDateManagement.v1.repository;

import com.ims.edm.expiryDateManagement.v1.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
