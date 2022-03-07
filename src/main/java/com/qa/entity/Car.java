package com.qa.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Car {

	@Id
	private Long id;
	
	private String make;
	
	
	public Car() {}

	public Car(Long id, String make) {
		super();
		this.id = id;
		this.make = make;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}
	
	
	
	
}
