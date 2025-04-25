package com.ims.edm.v1.user.repository;

import com.ims.edm.v1.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByNameAndEmail(String name, String email);
}
