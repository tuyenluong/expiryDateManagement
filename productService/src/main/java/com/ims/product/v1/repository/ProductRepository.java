package com.ims.product.v1.repository;

import com.ims.product.v1.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {

    Optional<Product> findBySku(String sku);

    boolean existsBySku(String sku);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("DELETE FROM Product p WHERE p.sku = :sku")
    int deleteBySku(@Param("sku")String sku);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("UPDATE Product p SET p.expiryDate = :expiryDate WHERE p.sku = :sku")
    int updateExpiryDateBySku(@Param("expiryDate")LocalDate expiryDate, @Param("sku")String sku);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("UPDATE Product p SET p.productionDate = :productionDate WHERE p.sku = :sku")
    int updateProductionDateBySku(@Param("productionDate")LocalDate productionDate, @Param("sku")String sku);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("UPDATE Product p SET p.productionDate = :productionDate, p.expiryDate = :expiryDate WHERE p.sku = :sku")
    int updateDateBySku(@Param("expiryDate")LocalDate expiryDate, @Param("productionDate")LocalDate productionDate, @Param("sku")String sku);
}
