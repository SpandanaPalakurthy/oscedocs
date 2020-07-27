package com.cg.tutorial.employeemanagement.service;

import java.util.List;

import com.cg.tutorial.employeemanagement.entities.Employee;

public interface IEmployeeService {

 public	Employee addEmployee(Employee employee);

 public	Employee getEmployeeDetails(int id);

 public	List<Employee> getEmployees();

 public	Employee updateEmployee(Employee employee, int id);

}
