package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Person;
import com.example.demo.Service.PersonService;

@RestController
@RequestMapping("person/")
public class PersonController {

	@Autowired
	PersonService personService;
	
	@GetMapping("/all")
	public List<Person> getAllPersons(){
		List<Person> persons = personService.getAllPerson();
		persons.stream().forEach(person-> {
//			person.setPhones(PhoneRepository.findAllByPersonId(person.getId()));
		});
		return persons;
	}
	
	@PostMapping("/add")
	public Person addPerson(@RequestBody Person person) {
		Person createResponse = personService.save(person);
		return createResponse;
	}
}