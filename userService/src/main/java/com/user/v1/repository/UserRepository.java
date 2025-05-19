package com.user.v1.repository;

import com.user.v1.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByNameAndEmail(String name, String email);
}
