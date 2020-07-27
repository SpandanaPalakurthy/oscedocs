package com.cg.employee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.employee.entities.Address;
import com.cg.employee.repositories.AddressRepository;
import com.cg.employee.repositories.EmployeeRepository;

@Service
public class AddressServiceImpl implements IAddressService {
	
	@Autowired
	private EmployeeRepository employeeRepo;
	
	@Autowired
	private AddressRepository addressRepo;

	@Override
	public Address addAddress(Address address) {
		
		return addressRepo.save(address);
	}

	
	/*
	 * @Override public Address addAddressDetails(Address address, int empId) {
	 * Employee employee = employeeRepo.findOne(empId);
	 * address.setEmployee(employee); Address newAddress =
	 * addressRepo.save(address); return newAddress; }
	 */
	 
	 
}
