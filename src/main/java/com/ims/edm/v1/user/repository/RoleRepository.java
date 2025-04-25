package com.ims.edm.v1.user.repository;

import com.ims.edm.expiryDateManagement.user.entity.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Roles, Long> {
    Roles findByName(String name);
}
