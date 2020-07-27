package com.cg.employee.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.employee.entities.Address;

public interface AddressRepository extends JpaRepository<Address, Integer> {

}
