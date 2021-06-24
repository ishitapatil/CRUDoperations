package com.example.demo.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.PhoneEntity;

@Repository
public interface PhoneRepository extends JpaRepository<PhoneEntity, Serializable> {

	List<PhoneEntity> findAllByPersonId(long personId);

	void deleteByPersonId(long personId);
}