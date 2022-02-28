package com.qa.controller;

import java.util.ArrayList;
import java.util.List;

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

@RestController // Tells Spring this is a Rest controller and that Spring needs to manage it
public class Controller {

	//A Representation of a database
	private List<Person> people = new ArrayList<>();

	@GetMapping("/hw") //Response 200 OK
	public String helloWorld() {
		return "Hello World";
	}
	
	@PostMapping("/create")
	public ResponseEntity<Person> createPerson(@RequestBody Person person) {
		
		this.people.add(person);
		
		Person responseBody = this.people.get(people.size() - 1);
		
		return new ResponseEntity<Person>(responseBody, HttpStatus.CREATED);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Person>> getAll() {
		return new ResponseEntity<List<Person>>(this.people, HttpStatus.OK);
	}
	
	            // /getByIndex/0
	@GetMapping("/getByIndex/{id}")
	public ResponseEntity<Person> getByIndex(@PathVariable Integer id) {
		return new ResponseEntity<Person>(this.people.get(id), HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Person> deleteByIndex(@PathVariable Integer id) {
		return new ResponseEntity<Person>(this.people.remove(id.intValue()), HttpStatus.ACCEPTED);
	}  
	
	@PutMapping("/updatePerson/{id}")
	public ResponseEntity<Person> updatePerson(@PathVariable Integer id, @RequestBody Person person) {
		
		System.out.println("Replacing: " + this.people.get(id).toString() + ". With: " + person.toString());
		
		return null;
	}
	
	
}
