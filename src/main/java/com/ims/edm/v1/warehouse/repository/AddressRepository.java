package com.ims.edm.v1.warehouse.repository;

import com.ims.edm.v1.warehouse.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
