package com.cg.tutorial.employeemanagement.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import com.cg.tutorial.employeemanagement.entities.Employee;
import com.cg.tutorial.employeemanagement.repositories.EmployeeRepository;
import com.cg.tutorial.employeemanagement.service.EmployeeServiceImpl;



@RunWith(MockitoJUnitRunner.class)
public class EmployeeTest {

	@Mock
	EmployeeRepository empRepo;
	
	@InjectMocks
	private EmployeeServiceImpl employeeService;

	@Test
	public void getEmployeeDetails() throws Exception {
		Employee employee = new Employee();
		
		employee.setEmpId(1);
		employee.setName("Sneha");
		employee.setAge(21);
		employee.setGender("female");
		employee.setSalary(20000);
		when(empRepo.findOne(1)).thenReturn(employee);
		Employee empExpected = employeeService.getEmployeeDetails(employee.getEmpId());
		assertEquals(employee,empExpected);

	}
	
	@Test
	public void getEmployees() {
		
		List<Employee> allEmployees = Arrays.asList();
		when(empRepo.findAll()).thenReturn(allEmployees);
		List<Employee> empExpec = employeeService.getEmployees();
		assertEquals(allEmployees, empExpec);
	}	
	
}
