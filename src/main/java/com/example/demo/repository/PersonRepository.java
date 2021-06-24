package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

	@Override
	List<Person> findAll();

	Person findById(long id);

	@Override
	Person save(Person p);

}
