package com.example.crud.response;

import org.springframework.stereotype.Component;

import com.example.crud.entity.PersonEntity;

@Component
public class PersonResponse {

	private PersonEntity personEntity;

	private String status;

	public PersonEntity getPersonEntity() {
		return personEntity;
	}

	public void setPersonEntity(PersonEntity personEntity) {
		this.personEntity = personEntity;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
