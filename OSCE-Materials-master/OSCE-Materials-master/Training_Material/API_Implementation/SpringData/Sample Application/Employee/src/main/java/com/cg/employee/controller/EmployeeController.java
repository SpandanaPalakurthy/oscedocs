package com.cg.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.employee.entities.Address;
import com.cg.employee.entities.Department;
import com.cg.employee.entities.Employee;
import com.cg.employee.service.IAddressService;
import com.cg.employee.service.IDepartmentService;
import com.cg.employee.service.IEmployeeService;


@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	IEmployeeService employeeService;
	
	@Autowired
	IAddressService addressService;
	  
	 @Autowired 
	 IDepartmentService departmentService;
	 
	 
	 
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public Employee getEmployeeDetails(@PathVariable int id)  {
		
		return employeeService.getEmployeeDetails(id); 
 

	}

	@RequestMapping(value="/employee", method=RequestMethod.GET)
	public Page<Employee> getEmployees(@RequestParam int page, @RequestParam int rpp) {

		return employeeService.getEmployees( page, rpp);

	}

	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public void updateProduct(@RequestBody Employee employee, @PathVariable int id) {

		employeeService.updateEmployee(employee,id);
	}
	
	 @RequestMapping(value="/{id}", method=RequestMethod.DELETE) 
	  public void deleteEmployee(@PathVariable int id) { 
		 
		 Employee employee = new Employee();
		 employee.setId(id);
		  employeeService.deleteEmployee(id); 
	 }
	 
	 //............................... add department .....................................
	 
	 @RequestMapping(value="/department", method=RequestMethod.POST)
	 public Department addDepartment(@RequestBody Department department) {
		 
		return departmentService.addDepartment(department);
		 
	 }
	 
	//.................................. add address ......................................
	 
	 @RequestMapping(value="/address", method= RequestMethod.POST)
	 
	 public Address addAddress(@RequestBody Address address) {
		 
		return addressService.addAddress(address);
		 
	 }	 
	 
	 //................................... add employee ...................................
	 
	 @RequestMapping(value="/addEmployee/{id}", method = RequestMethod.POST)
	 public Employee addEmployee(@RequestBody Employee employee, @PathVariable int id) {
		 
		Employee emp = employeeService.addEmployee(employee, id); 
		return emp;	 
	 }

}
