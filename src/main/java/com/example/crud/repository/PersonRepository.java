package com.example.crud.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.crud.entity.PersonEntity;

@Repository
public interface PersonRepository extends JpaRepository<PersonEntity, Long> {

	@Override
	List<PersonEntity> findAll();

	PersonEntity findById(long id);
}
