package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Person;
import com.example.demo.service.PersonService;
import com.example.demo.service.PhoneService;

@RestController
@RequestMapping("v1/")
public class PersonController {

	@Autowired
	PersonService personService;

	@Autowired
	PhoneService phoneService;

	@GetMapping("/persons")
	public List<Person> getAllPersons() {
		List<Person> persons = personService.getAllPerson();
		persons.stream().forEach(person -> {
			person.setPhones(phoneService.findAllByPersonId(person.getId()));
		});
		return persons;
	}

	@PostMapping("/persons")
	public Person addPerson(@RequestBody Person person) {
		Person createResponse = personService.save(person);
		return createResponse;
	}

	@PutMapping("/persons")
	public Person updatePerson(@RequestBody Person person) {
		Person updateResponse = personService.update(person);
		return updateResponse;
	}

	@DeleteMapping("/persons/{id}")
	public String deletePerson(@PathVariable(value = "id") @RequestBody Person person) {
		personService.delete(person);
		return "Record deleted succesfully";
	}
}