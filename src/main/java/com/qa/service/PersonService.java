package com.qa.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.qa.entity.Person;

@Service
public class PersonService {
	
	//A Representation of a database
	private List<Person> people = new ArrayList<>();

	
	public Person createPerson(Person p) {
		this.people.add(p);
		
		return this.people.get(people.size() - 1);
	}
	
	
	public List<Person> getAllPersons() {
		return this.people;
	}
	
	public Person getById(Integer id) {
		return this.people.get(id);
	}
	
	public Person updatePerson(Integer id, Person p) {
		return this.people.set(id, p);
	}
	
	public Person deletePerson(Integer id) {
		return this.people.remove(id.intValue());
	}

}
