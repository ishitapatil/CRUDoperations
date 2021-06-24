package com.example.demo.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Phone;

@Repository
public interface PhoneRepository extends JpaRepository<Phone, Serializable> {

	public static final String FIND_PHONES_BY_PERSON_ID = "select number,type from phone person_id=?1";

	@Query(value = FIND_PHONES_BY_PERSON_ID, nativeQuery = true)
	public List<Phone> findAllByPersonId(long personId);

	public List<Phone> findAllNumberAndTypeByPersonId(long personId);
}