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
//	@Column(name = "favefood")
	private String favefood;
	
	
	public Person() {}
	
	public Person(int id, String name, int age, String faveFood) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.favefood = faveFood;
	}
	
	public Person(String name, int age, String faveFood) {
		super();
		this.name = name;
		this.age = age;
		this.favefood = faveFood;
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
		return favefood;
	}

	public void setFaveFood(String faveFood) {
		this.favefood = faveFood;
	}
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((favefood == null) ? 0 : favefood.hashCode());
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (age != other.age)
			return false;
		if (favefood == null) {
			if (other.favefood != null)
				return false;
		} else if (!favefood.equals(other.favefood))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Person [Id=" + id + ", name=" + name + ", age=" + age + ", faveFood=" + favefood + "]";
	}


	

}
