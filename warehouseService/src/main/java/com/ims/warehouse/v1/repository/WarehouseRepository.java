package com.ims.warehouse.v1.repository;

import com.ims.warehouse.v1.entity.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WarehouseRepository extends JpaRepository<Warehouse, Long> {
}