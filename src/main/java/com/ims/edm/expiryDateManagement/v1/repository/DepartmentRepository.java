package com.ims.edm.expiryDateManagement.v1.repository;

import com.ims.edm.expiryDateManagement.v1.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
