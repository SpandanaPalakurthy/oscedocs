package com.cg.employee.service;

import org.springframework.data.domain.Page;

import com.cg.employee.entities.Employee;

public interface IEmployeeService {

   public Employee addEmployee(Employee employee, int id);

   public Employee getEmployeeDetails(int id);

   public Page<Employee> getEmployees(int page, int rpp);

   public void updateEmployee(Employee employee, int id);
   
   public void deleteEmployee(int id);

   

}
