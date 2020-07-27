package com.cg.employee.repositories;



import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.cg.employee.entities.Employee;


//public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	
public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Integer> {
	/*
	 * List<Employee> findByempId(int empId);
	 * 
	 * @Query(value="SELECT * FROM Employee e WHERE e.name = 'name'", nativeQuery =
	 * true) List<Employee> findByname();
	 */

	List<Employee> findBySalary(String salary, Pageable pageable);
}
