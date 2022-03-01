package com.qa.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.entity.Person;
import com.qa.exceptions.PersonNotFoundException;
import com.qa.repo.PersonRepo;

@Service
public class PersonService {

	private PersonRepo repo;
	
	@Autowired
	public PersonService(PersonRepo repo) {
		this.repo = repo;
	}
	
	public Person createPerson(Person p) {
		return this.repo.save(p);
	}
	
	
	public List<Person> getAllPersons() {
		                // SELECT * FROM person;
		return this.repo.findAll();
	}
	
	public Person getById(Integer id) {
//		Optional<Person> optionalPerson = this.repo.findById(id);
//		
//		if(optionalPerson.isPresent()) {
//			return optionalPerson.get();
//		} else {
//			throw new EntityNotFoundException("Can't find that person");
//		}
//		
		return this.repo.findById(id).orElseThrow(() -> new PersonNotFoundException("Can't find that person"));
	}
	
//	public List<Person> findByNameAndFood(String name, String faveFood) {
//		return this.repo.findPersonByNameAndFavefood(name, faveFood);
//	}
//	
	public Person updatePerson(Integer id, Person p) {
		//find that person
		Person foundPerson = this.getById(id);
		//update their info
		foundPerson.setAge(p.getAge());
		foundPerson.setFaveFood(p.getFaveFood());
		foundPerson.setName(p.getName());
		//save that back to the database
		                 //INSERT INTO...
		return this.repo.save(foundPerson);
	}
	
	public boolean deletePerson(Integer id) {
		this.repo.deleteById(id);
		return !this.repo.existsById(id);   
	}

}
