package com.cg.tutorial.employeemanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cg.tutorial.employeemanagement.entities.Employee;
import com.cg.tutorial.employeemanagement.exception.EmployeeManagementException;
import com.cg.tutorial.employeemanagement.service.IEmployeeService;


@RestController
public class EmployeeController {
	
	@Autowired
	IEmployeeService employeeService;
	
	@RequestMapping(value="/employee", method=RequestMethod.POST)
	public Employee addEmployee(@RequestBody Employee employee) {

		return employeeService.addEmployee(employee);

	}

	@RequestMapping(value="/employee/{id}", method=RequestMethod.GET)
	public Employee getEmployeeDetails(@PathVariable int id) throws EmployeeManagementException {
 
		Employee employee = employeeService.getEmployeeDetails(id);
		if(employee==null)
		 throw new EmployeeManagementException(204,"Employee Not Found");
		return employee;

	}

	@RequestMapping(value="/employee", method=RequestMethod.GET)
	public List<Employee> getEmployees() {

		return employeeService.getEmployees();

	}

	@RequestMapping(value="/employee/{id}", method=RequestMethod.PUT)
	public void updateProduct(@RequestBody Employee employee, @PathVariable int id) {

		employeeService.updateEmployee(employee,id);
	}

	

}
