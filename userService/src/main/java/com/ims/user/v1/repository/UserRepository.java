package com.ims.user.v1.repository;

import com.ims.user.v1.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByNameAndEmail(String name, String email);
}
