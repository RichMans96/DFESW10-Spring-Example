package com.qa.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.entity.Person;
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
		return this.repo.findById(id).orElseThrow(() -> new EntityNotFoundException("Can't find that person"));
	}
	
//	public Person updatePerson(Integer id, Person p) {
//		return ;
//	}
//	
//	public Person deletePerson(Integer id) {
//		return ;
//	}

}
