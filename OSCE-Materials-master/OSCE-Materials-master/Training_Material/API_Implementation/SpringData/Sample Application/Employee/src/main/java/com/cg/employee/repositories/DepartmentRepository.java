package com.cg.employee.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.employee.entities.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer>{

}
