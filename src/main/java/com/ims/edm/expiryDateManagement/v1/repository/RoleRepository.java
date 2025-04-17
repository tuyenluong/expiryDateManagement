package com.ims.edm.expiryDateManagement.v1.repository;

import com.ims.edm.expiryDateManagement.v1.entity.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Roles, Long> {
    Roles findByName(String name);
}
