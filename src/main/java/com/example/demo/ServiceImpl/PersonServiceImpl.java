package com.example.demo.ServiceImpl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Person;
import com.example.demo.Repository.PersonRepository;
import com.example.demo.Service.PersonService;

@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
	private PersonRepository personRepository;
	
	@Transactional
	public Person save(Person person) {
		Person createResponse = personRepository.save(person);
		return createResponse;
	}

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

	@Transactional
	public void delete(Person person) {
		personRepository.delete(person);
	}
	
	@Transactional
	public List<Person> getAllPerson(){
		return personRepository.findAll();
	}

	@Override
	public Person get(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
