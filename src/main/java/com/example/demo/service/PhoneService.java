package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.entity.PhoneEntity;

@Component
public interface PhoneService {

	PhoneEntity create(PhoneEntity phone);

	List<PhoneEntity> findAllByPersonId(long personId);

	PhoneEntity save(PhoneEntity phoneEntity);

	void delete(PhoneEntity phoneEntity);

	void deleteByPersonId(long personId);
}
