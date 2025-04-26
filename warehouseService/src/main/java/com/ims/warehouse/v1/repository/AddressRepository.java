package com.ims.warehouse.v1.repository;

import com.ims.warehouse.v1.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
