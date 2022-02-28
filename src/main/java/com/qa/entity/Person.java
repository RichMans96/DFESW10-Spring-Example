package com.qa.entity;

public class Person {
	 
	private int Id;
	private String name;
	private int age;
	private String faveFood;
	
	
	public Person() {}
	
	public Person(int id, String name, int age, String faveFood) {
		super();
		this.Id = id;
		this.name = name;
		this.age = age;
		this.faveFood = faveFood;
	}

	
	
	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
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
		return "Person [Id=" + Id + ", name=" + name + ", age=" + age + ", faveFood=" + faveFood + "]";
	}


	

}
