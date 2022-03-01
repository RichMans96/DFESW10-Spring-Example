package com.qa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity // Creates Person as a table
public class Person {
	 
	@Id // is the PK of our table
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increments
	private int id;
	
//	@Column(name = "fullname")
	private String name;
	private int age;
	private String faveFood;
	
	
	public Person() {}
	
	public Person(String name, int age, String faveFood) {
		super();
		this.name = name;
		this.age = age;
		this.faveFood = faveFood;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getFaveFood() {
		return faveFood;
	}

	public void setFaveFood(String faveFood) {
		this.faveFood = faveFood;
	}

	@Override
	public String toString() {
		return "Person [Id=" + id + ", name=" + name + ", age=" + age + ", faveFood=" + faveFood + "]";
	}


	

}
