package com.targa.labs.myBoutique.product.repository;

import com.targa.labs.myBoutique.product.domain.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
