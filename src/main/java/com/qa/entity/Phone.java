package com.qa.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Phone {


	@Id
	private Long id;
	
	private String make;
	
	
	public Phone() {}

	public Phone(Long id, String make) {
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
