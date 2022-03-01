package com.qa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qa.entity.Person;
import com.qa.service.PersonService;

@RestController // Tells Spring this is a Rest controller and that Spring needs to manage it
public class Controller {
	
	private PersonService service;
	
	@Autowired
	public Controller(PersonService service) {
		this.service = service;
	}

	@PostMapping("/create")
	public ResponseEntity<Person> createPerson(@RequestBody Person person) {
		return new ResponseEntity<Person>(this.service.createPerson(person), HttpStatus.CREATED);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Person>> getAll() {
		return new ResponseEntity<List<Person>>(this.service.getAllPersons(), HttpStatus.OK);
	}
	
	            // /getByIndex/0
	@GetMapping("/getByIndex/{id}")
	public ResponseEntity<Person> getByIndex(@PathVariable Integer id) {
		return new ResponseEntity<Person>(this.service.getById(id), HttpStatus.OK);
	}
//	
//	@GetMapping("/findByNameAndFood/{name}/{food}")
//	public ResponseEntity<List<Person>> getByNameAndFood(@PathVariable String name, @PathVariable String food) {
//		return new ResponseEntity<List<Person>>(this.service.findByNameAndFood(name, food), HttpStatus.OK);
//	}

	
	@PutMapping("/updatePerson/{id}")
	public ResponseEntity<Person> updatePerson(@PathVariable Integer id, @RequestBody Person person) {
		return new ResponseEntity<Person>(this.service.updatePerson(id, person), HttpStatus.ACCEPTED);
	}
	
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Boolean> deleteByIndex(@PathVariable Integer id) {
		boolean hasDeleted = this.service.deletePerson(id);
		
		if(hasDeleted) {
		return new ResponseEntity<Boolean>(hasDeleted, HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<Boolean>(hasDeleted, HttpStatus.I_AM_A_TEAPOT);
		}
	}  
	
	
}
