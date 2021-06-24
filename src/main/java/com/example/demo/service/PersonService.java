package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.entity.PersonEntity;

@Component
public interface PersonService {

	public PersonEntity save(PersonEntity person);

	public PersonEntity update(PersonEntity person);

	public PersonEntity get(long id);

	public void delete(PersonEntity person);

	public List<PersonEntity> getAllPerson();
}
