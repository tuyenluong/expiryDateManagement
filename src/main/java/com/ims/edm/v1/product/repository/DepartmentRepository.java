package com.ims.edm.v1.product.repository;

import com.ims.edm.v1.product.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
