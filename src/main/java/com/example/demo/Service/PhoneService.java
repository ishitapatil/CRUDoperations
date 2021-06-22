package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Phone;
import com.example.demo.repository.PhoneRepository;
@Service
public class PhoneService {
	@Autowired
	PhoneRepository phoneRepository;
	public void create(Phone phone) {
		phoneRepository.save(phone);
	}
}
