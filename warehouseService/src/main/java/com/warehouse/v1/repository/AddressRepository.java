package com.warehouse.v1.repository;

import com.warehouse.v1.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
