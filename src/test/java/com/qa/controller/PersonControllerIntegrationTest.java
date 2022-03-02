package com.qa.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.entity.Person;

@SpringBootTest
@ActiveProfiles("test")
@Sql(scripts = {"classpath:person-schema.sql", "classpath:person-data.sql"}, 
     executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@AutoConfigureMockMvc
public class PersonControllerIntegrationTest {

	@Autowired
	private MockMvc mvc;

	@Autowired
	private ObjectMapper mapper;

	@Test
	void createPersonTest() throws Exception {
		// Given
		Person newPerson = new Person("Richard", 25, "Pizza");
		String newPersonJSON = this.mapper.writeValueAsString(newPerson);

		Person savedPerson = new Person(4, "Richard", 25, "Pizza");
		String savedPersonJSON = this.mapper.writeValueAsString(savedPerson);
		// When
		RequestBuilder request = post("/create").contentType(MediaType.APPLICATION_JSON).content(newPersonJSON);
//		
		ResultMatcher responseStatus = status().isCreated();
		ResultMatcher responseContent = content().json(savedPersonJSON);
		// Then
		this.mvc.perform(request).andExpect(responseStatus).andExpect(responseContent);
	}

	@Test
	void readAllPeopleTest() throws Exception {
		List<Person> people = new ArrayList<>();
		people.add(new Person(1, "Richard", 25, "Pizza"));
		people.add(new Person(2, "David", 25, "Pasta"));
		people.add(new Person(3, "Celia", 25, "Pineapples"));
		
		String savedPeopleJSON = this.mapper.writeValueAsString(people);
		
		RequestBuilder req = get("/getAll");
		
		ResultMatcher responseStatus = status().isOk();
		ResultMatcher responseContent = content().json(savedPeopleJSON);

		this.mvc.perform(req).andExpect(responseStatus).andExpect(responseContent);
	}

}
