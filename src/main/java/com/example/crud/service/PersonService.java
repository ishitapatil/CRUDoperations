package com.example.crud.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.crud.entity.PersonEntity;

@Component
public interface PersonService {

	PersonEntity save(PersonEntity person);

	PersonEntity update(PersonEntity person);

	PersonEntity get(long id);

	void delete(PersonEntity person);

	List<PersonEntity> getAllPerson();
}
