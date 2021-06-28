package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.PersonEntity;
import com.example.demo.entity.PhoneEntity;
import com.example.demo.model.Person;
import com.example.demo.model.Phone;
import com.example.demo.objectmapper.ObjectMapperUtils;
import com.example.demo.service.PersonService;
import com.example.demo.service.PhoneService;

@RestController
@RequestMapping("v1/")
public class PersonController {

	@Autowired
	PersonService personService;

	@Autowired
	PhoneService phoneService;

	@Autowired
	ObjectMapperUtils mapper;

	@GetMapping("/people")
	public List<Person> getAllPersons() {
		List<PersonEntity> entities = personService.getAllPerson();

		List<Person> persons = new ArrayList<>();

		entities.stream().forEach(entity -> {
			Person person = mapper.map(entity, Person.class);
			List<PhoneEntity> phoneEntities = phoneService.findAllByPersonId(entity.getId());
			person.setPhones(mapper.mapAll(phoneEntities, Phone.class));
			persons.add(person);
		});

		return persons;
	}

	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/people/{id}")
	public ResponseEntity<Person> getPerson(@PathVariable(name = "id") long id) {
		PersonEntity personEntity = personService.get(id);
		if (personEntity != null) {
			personEntity.setPhones(phoneService.findAllByPersonId(personEntity.getId()));
			Person person = mapper.map(personEntity, Person.class);
			return new ResponseEntity<Person>(person, HttpStatus.OK);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/people")
	public ResponseEntity<Person> addPerson(@RequestBody Person person) {
		PersonEntity personRequest = mapper.map(person, PersonEntity.class);
		PersonEntity createResponse = personService.save(personRequest);
		person.getPhones().stream().forEach(phone -> {
			PhoneEntity createPhoneRequest = mapper.map(phone, PhoneEntity.class);
			createPhoneRequest.setPersonId(createResponse.getId());
			phoneService.create(createPhoneRequest);
		});
		Person createdPerson = mapper.map(createResponse, Person.class);
		return new ResponseEntity<Person>(createdPerson, HttpStatus.CREATED);
	}

	@CrossOrigin(origins = "http://localhost:3000")
	@PutMapping("/people")
	public ResponseEntity<Person> updatePerson(@RequestBody Person person) {
		PersonEntity exisitingPerson = personService.get(person.getId());
		if (exisitingPerson == null) {
			return ResponseEntity.notFound().build();
		}
		PersonEntity personRequest = mapper.map(person, PersonEntity.class);
		PersonEntity updateResponse = personService.save(personRequest);
		phoneService.deleteByPersonId(person.getId());
		if (person.getPhones() != null) {
			person.getPhones().stream().forEach(phone -> {
				PhoneEntity phoneEntity = mapper.map(phone, PhoneEntity.class);
				phoneEntity.setPersonId(person.getId());
				PhoneEntity updatePhoneResponse = phoneService.save(phoneEntity);
				updateResponse.getPhones().add(updatePhoneResponse);
			});
		}
		return ResponseEntity.ok().body(mapper.map(updateResponse, Person.class));

	}

	@DeleteMapping("/people/{id}")
	public HttpStatus deletePerson(@PathVariable(name = "id") long id) {
		PersonEntity personEntity = personService.get(id);
		if (personEntity == null) {
			return HttpStatus.NOT_FOUND;
		}
		personEntity.getPhones().stream().forEach(phone -> {
			phoneService.delete(phone);
		});
		personService.delete(personEntity);
		System.out.println("Person entry deleted");
		return HttpStatus.OK;
	}
}