package com.cg.tutorial.employeemanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.tutorial.employeemanagement.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Integer>{

}
