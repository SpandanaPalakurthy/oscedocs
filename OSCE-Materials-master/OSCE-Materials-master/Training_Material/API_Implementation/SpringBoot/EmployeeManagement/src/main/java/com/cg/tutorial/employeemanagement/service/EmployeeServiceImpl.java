package com.cg.tutorial.employeemanagement.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.tutorial.employeemanagement.entities.Employee;
import com.cg.tutorial.employeemanagement.repositories.EmployeeRepository;

@Service
public class EmployeeServiceImpl  implements IEmployeeService{

	@Autowired
	EmployeeRepository employRepo;
	
	Logger log = Logger.getLogger(this.getClass());

	public Employee addEmployee(Employee employee) {
		
		return employRepo.save(employee);
	}

	
	public Employee getEmployeeDetails(int id) {
		
		log.info("In service- get Employee Details");
		return employRepo.findOne(id);
	}

	
	public List<Employee> getEmployees() {
		
		return employRepo.findAll();
	}

	
	public Employee updateEmployee(Employee employee, int id) {
		
		return employRepo.save(employee);
		
	}
		

}
