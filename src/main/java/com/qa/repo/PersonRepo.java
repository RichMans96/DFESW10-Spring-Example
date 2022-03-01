package com.qa.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.qa.entity.Person;

@Repository
public interface PersonRepo extends JpaRepository<Person, Integer> {

				//SELECT * FROM person WHERE name = VVV AND fave_food=VV
	List<Person> findPersonByNameAndFavefood(String name, String faveFood);
	//SELECT * FROM person WHERE name =  VVV
	List<Person> findPersonByName(String name);
	
	@Query(value = "SELECT * FROM person WHERE name = ?1", nativeQuery=true)
	List<Person> findPersonByNameSql(String name);

	
}
