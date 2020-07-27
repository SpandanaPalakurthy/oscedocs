package com.cg.employee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.cg.employee.entities.Address;
import com.cg.employee.entities.Department;
import com.cg.employee.entities.Employee;
import com.cg.employee.repositories.AddressRepository;
import com.cg.employee.repositories.DepartmentRepository;
import com.cg.employee.repositories.EmployeeRepository;

@Service

public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	EmployeeRepository employeeRepo;

	@Autowired
	DepartmentRepository departmentRepo;

	@Autowired
	AddressRepository addressRepo;

	@Override
	public Employee addEmployee(Employee employee, int id) {

		Department department = departmentRepo.findOne(id);
		employee.setDepartment(department);
		Address address = addressRepo.findOne(id);
		employee.setAddress(address);
		Employee newemployee = employeeRepo.save(employee);
		return newemployee;
	}

	@Override
	public void updateEmployee(Employee employee, int id) {
		Department dep = departmentRepo.findOne(id);
		employee.setDepartment(dep);
		employeeRepo.save(employee);

	}

	public void deleteEmployee(int id) {

		employeeRepo.delete(id);
	}

	@Override
	public Employee getEmployeeDetails(int id) {
		
		return employeeRepo.findOne(id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Page<Employee> getEmployees(int page, int rpp) {
		
		PageRequest prd= new PageRequest(page, rpp);
		
		return employeeRepo.findAll(prd);
	}

}
