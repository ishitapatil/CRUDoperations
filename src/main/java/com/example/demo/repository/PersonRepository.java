package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

	  List<Person> findAll();
	  Person findById(long id);
	  Person save(Person p);
}
