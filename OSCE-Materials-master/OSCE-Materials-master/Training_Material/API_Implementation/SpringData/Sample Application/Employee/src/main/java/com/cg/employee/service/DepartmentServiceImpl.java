package com.cg.employee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.employee.entities.Address;
import com.cg.employee.entities.Department;
import com.cg.employee.entities.Employee;
import com.cg.employee.repositories.DepartmentRepository;
import com.cg.employee.repositories.EmployeeRepository;

@Service
public class DepartmentServiceImpl implements IDepartmentService {

	@Autowired
	private EmployeeRepository employeeRepo;

	@Autowired
	private DepartmentRepository depRepo;

	@Override
	public Department addDepartment(Department department) {
		
		return depRepo.save(department);
	}

	
	
	/*
	 * @Override public Department addDepartment(Department department, int empId) {
	 * 
	 * Employee employee = employeeRepo.findOne(empId); department.setId(empId);
	 * department.setName(employee.getName()); depRepo.save(department); return
	 * department;
	 * 
	 * }
	 */
	 
	 

}
