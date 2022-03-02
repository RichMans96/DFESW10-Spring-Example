package com.qa.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.qa.entity.Person;
import com.qa.repo.PersonRepo;

@SpringBootTest
public class PersonServiceUnitTest {
	
	@Autowired
	private PersonService service;
	
	@MockBean
	private PersonRepo repo;
	
	
	@Test
	void getByIdTest() {
		//Given
		int id = 1;
		Person foundPerson = new Person(1, "Richard", 25, "Pizza");
		//When
		Mockito.when(this.repo.findById(id)).thenReturn(Optional.of(foundPerson));
		//Then
		assertThat(this.service.getById(id)).isEqualTo(foundPerson);
		//Verify
		Mockito.verify(this.repo, Mockito.times(1)).findById(Mockito.anyInt());
	}
	
	@Test
	void createPersonTest() {
		//Given
		Person personToSave = new Person("Richard", 25, "Pizza");
		Person personSaved = new Person(1, "Richard", 25, "Pizza");
		//When
		Mockito.when(this.repo.save(personToSave)).thenReturn(personSaved);
		//Then
		assertThat(this.service.createPerson(personToSave)).isEqualTo(personSaved);
		//Verify
		Mockito.verify(this.repo, Mockito.times(1)).save(Mockito.any(Person.class));
	}

}
