package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "phone")
public class PhoneDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int phoneId;

	@Column(name = "number")
	private String number;

	@Column(name = "type")
	private String type;

	@Column(name = "personId")
	private long personId;

	public int getPhoneId() {
		return phoneId;
	}

	public void setPhoneId(int phoneId) {
		this.phoneId = phoneId;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public long getPersonId() {
		return personId;
	}

	public void setPersonId(long personId) {
		this.personId = personId;
	}
}
