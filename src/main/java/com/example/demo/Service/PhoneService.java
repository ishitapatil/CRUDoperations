package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.entity.Phone;

@Component
public interface PhoneService {

	List<Phone> findAllByPersonId(long personId);
}
