package com.cg.tutorial.employeemanagement.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="employee")

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class Employee {
	@Id
	@NotNull
	private int empId;
	@Size(min = 4, message = "Length between 4-8 characters") 
	private String name;
	@Size(min = 1, message = "Length between 1-6 characters") 
	private String gender;
	@Min(21)
	private int age;
	@NotNull
	private double salary;
	
	
}
