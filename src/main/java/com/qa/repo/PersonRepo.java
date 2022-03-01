package com.qa.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.qa.entity.Person;

@Repository
public interface PersonRepo extends JpaRepository<Person, Integer> {
//
//				//SELECT * FROM person WHERE name = VVV AND fave_food=VV
//	List<Person> findPersonByNameAndFavefood(String name, String faveFood);
//	//SELECT * FROM person WHERE name =  VVV
//	List<Person> findPersonByName(String name);
//	
//	@Query(value = "SELECT * FROM person WHERE name = ?1", nativeQuery=true)
//	List<Person> findPersonByNameSql(String name);

	@Query("SELECT p from Person p")
	List<Person> findAllJPQL();

//	List<Person> findPersonByNameAndAge(String name, int age);

	@Query(value = "SELECT * from Person", nativeQuery = true)
	List<Person> findAllSQL();

	List<Person> findPersonByAgeGreaterThan(int age);

	@Query("SELECT p from Person p WHERE p.age > ?1")
	List<Person> findPersonByAgeGreaterThanJPQL(int age);

	@Query(value = "SELECT * from Person WHERE age > ?1", nativeQuery = true)
	List<Person> findPersonByAgeGreaterThanSQL(int age);

	List<Person> findPersonByAgeLessThan(int age);

	@Query("SELECT p from Person p WHERE p.age < ?1")
	List<Person> findPersonByAgeLessThanJPQL(int age);

	@Query(value = "SELECT * from Person WHERE age < ?1", nativeQuery = true)
	List<Person> findPersonByAgeLessThanSQL(int age);

	List<Person> findPersonByName(String name);

	@Query("SELECT p from Person p WHERE p.name = ?1")
	List<Person> findPersonByNameJPQL(String name);

	@Query(value = "SELECT * from Person WHERE name = ?1", nativeQuery = true)
	List<Person> findPersonByNameSQL(String name);

	Person findPersonByNameAndAge(String name, int age);

	@Query("SELECT p from Person p WHERE p.name = ?1 and p.age = ?2")
	Person findPersonByNameAndAgeJPQL(String name, int age);

	@Query(value = "SELECT * from Person WHERE name = ?1 and age = ?2", nativeQuery = true)
	Person findPersonByNameAndAgeSQL(String name, int age);

	List<Person> findPersonByNameIsNotNull();

	@Query("SELECT p from Person p WHERE p.name != NULL")
	List<Person> findPersonByNameIsNotNullJPQL();

	@Query(value = "SELECT * from Person WHERE name IS NOT NULL", nativeQuery = true)
	List<Person> findPersonByNameIsNotNullSQL();

	List<Person> findPersonByNameIsNull();

	@Query("SELECT p from Person p WHERE p.name = NULL")
	List<Person> findPersonByNameIsNullJPQL();

	@Query(value = "SELECT * from Person WHERE name IS NULL", nativeQuery = true)
	List<Person> findPersonByNameIsNullSQL();

}
