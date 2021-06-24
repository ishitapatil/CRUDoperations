package com.example.demo.serviceImpl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Person;
import com.example.demo.repository.PersonRepository;
import com.example.demo.service.PersonService;

@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
	private PersonRepository personRepository;

	@Override
	@Transactional
	public Person save(Person person) {
		Person createResponse = personRepository.save(person);
		return createResponse;
	}

	@Override
	@Transactional
	public Person update(Person person) {
		Person updateResponse = personRepository.save(person);
		return updateResponse;
	}

	@Transactional
	public Person get(Long id) {
		Optional<Person> personResponse = personRepository.findById(id);
		Person getResponse = personResponse.get();
		return getResponse;
	}

	@Override
	@Transactional
	public void delete(Person person) {
		personRepository.delete(person);
	}

	@Override
	@Transactional
	public List<Person> getAllPerson() {
		return personRepository.findAll();
	}

	@Override
	public Person get(long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
