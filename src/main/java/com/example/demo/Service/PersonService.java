package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.entity.Person;

@Component
public interface PersonService {

	Person save(Person person);

	Person update(Person person);

	Person get(long id);

	void delete(Person person);

	List<Person> getAllPerson();

}
