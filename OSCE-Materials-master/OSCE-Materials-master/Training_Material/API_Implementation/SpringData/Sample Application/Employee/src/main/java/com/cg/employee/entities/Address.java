package com.cg.employee.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "ADDRESS")
@Getter
@Setter
public class Address implements Serializable {


		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		@Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    @Column(name = "ID", updatable = false, nullable = false)
	    private int id;

	    @Column(name = "STREET")
	    private String street;

	    @Column(name = "HOUSE_NUMBER")
	    private String houseNumber;

	    @Column(name = "ZIP_CODE")
	    private String zipCode;

		
	}


