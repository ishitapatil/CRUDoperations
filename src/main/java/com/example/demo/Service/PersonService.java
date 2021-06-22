package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Person;
import com.example.demo.model.Phone;
import com.example.demo.repository.PersonRepository;
import com.example.demo.repository.PhoneRepository;
@Service
public class PersonService {
	@Autowired
	PersonRepository personRepository;
	@Autowired
	PhoneRepository phoneRepository;

	public List<Person> getAllDetails(){
		List<Person> person = personRepository.findAll();
		return person;
	}
	public Person getByID(long id){
		Person person = personRepository.findById(id);
		return person;
	}
	public void create(Person person) {
		
		personRepository.save(person);
		
		
	}
}
