package com.example.demo.Service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.Entity.Person;

@Component
public interface PersonService {
	
	public Person save(Person person);
	public Person update(Person person);
	public Person get(Integer id);
	public void delete(Person person);
	public List<Person> getAllPerson();
}
