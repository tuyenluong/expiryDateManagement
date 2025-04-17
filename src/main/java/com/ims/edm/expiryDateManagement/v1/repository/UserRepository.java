package com.ims.edm.expiryDateManagement.v1.repository;

import com.ims.edm.expiryDateManagement.v1.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByNameAndEmail(String name, String email);
}
