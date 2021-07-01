package com.example.crud.serviceImpl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.crud.entity.PersonEntity;
import com.example.crud.repository.PersonRepository;
import com.example.crud.service.PersonService;

@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
	private PersonRepository personRepository;

	@Override
	@Transactional
	public PersonEntity save(PersonEntity person) {
		PersonEntity createResponse = personRepository.save(person);
		return createResponse;
	}

	@Override
	@Transactional
	public PersonEntity update(PersonEntity person) {
		PersonEntity updateResponse = personRepository.save(person);
		return updateResponse;
	}

	@Transactional
	public PersonEntity get(Long id) {
		Optional<PersonEntity> personResponse = personRepository.findById(id);
		PersonEntity getResponse = personResponse.get();
		return getResponse;
	}

	@Override
	@Transactional
	public void delete(PersonEntity person) {
		personRepository.delete(person);
	}

	@Override
	@Transactional
	public List<PersonEntity> getAllPerson() {
		return personRepository.findAll();
	}

	@Override
	public PersonEntity get(long id) {
		return personRepository.findById(id);
	}

}
