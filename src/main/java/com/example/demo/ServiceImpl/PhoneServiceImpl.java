package com.example.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Phone;
import com.example.demo.repository.PhoneRepository;
import com.example.demo.service.PhoneService;

@Service
public class PhoneServiceImpl implements PhoneService {

	@Autowired
	PhoneRepository phoneRepository;

	@Override
	public List<Phone> findAllByPersonId(long personId) {
		// TODO Auto-generated method stub
		return phoneRepository.findAllNumberAndTypeByPersonId(personId);
	}

	public void create(Phone phone) {
		phoneRepository.save(phone);
	}
}
