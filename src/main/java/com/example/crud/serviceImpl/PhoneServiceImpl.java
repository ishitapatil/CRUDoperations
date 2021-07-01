package com.example.crud.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.crud.entity.PhoneEntity;
import com.example.crud.repository.PhoneRepository;
import com.example.crud.service.PhoneService;

@Service
public class PhoneServiceImpl implements PhoneService {

	@Autowired
	PhoneRepository phoneRepository;

	@Override
	public PhoneEntity create(PhoneEntity phone) {
		return phoneRepository.save(phone);

	}

	@Override
	public List<PhoneEntity> findAllByPersonId(long personId) {
		return phoneRepository.findAllByPersonId(personId);
	}

	@Override
	public PhoneEntity save(PhoneEntity phoneEntity) {
		// TODO Auto-generated method stub
		return phoneRepository.save(phoneEntity);
	}

	@Override
	public void delete(PhoneEntity entity) {
		phoneRepository.delete(entity);
	}

	@Override
	@Transactional
	public void deleteByPersonId(long personId) {
		phoneRepository.deleteByPersonId(personId);
	}

}
