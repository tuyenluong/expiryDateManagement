package com.ims.edm.v1.warehouse.repository;

import com.ims.edm.v1.warehouse.entity.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WarehouseRepository extends JpaRepository<Warehouse, Long> {
}