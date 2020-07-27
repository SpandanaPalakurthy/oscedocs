package com.capgemini.mongodb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.mongodb.entities.Employee;
import com.capgemini.mongodb.repository.EmployeeRepository;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	EmployeeRepository employeeRepository;

	// create
	@RequestMapping(value = "/employee", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void create(@RequestBody Employee employee) {
		employeeRepository.save(employee);
	}

//read
	@RequestMapping(value = "/{id}")
	public Employee read(@PathVariable String id) {
		return employeeRepository.findOneById(id);
	}

	// update

	@RequestMapping(value = "/employee", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void update(@RequestBody Employee employee) {
		employeeRepository.save(employee);
	}

	// delete

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable String id) {

		Employee employee = employeeRepository.findOneById(id);
		employeeRepository.delete(employee);
	}

}
