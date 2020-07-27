package com.capgemini.mongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.mongodb.entities.Employee;


@Repository
public interface EmployeeRepository extends MongoRepository<Employee, String> {

	public Employee findOneById(String id);

	public void save(String id);

	





	
	

}
