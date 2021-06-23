package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Phone;
import com.example.demo.Repository.PhoneRepository;
@Service
public class PhoneService {
	@Autowired
	PhoneRepository phoneRepository;
	public void create(Phone phone) {
		phoneRepository.save(phone);
	}
}
