package com.example.crud.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "phone")
public class PhoneEntity {

	@Id
	@Column(name = "number")
	private String number;

	@Column(name = "type")
	private String type;

	@Column(name = "personId")
	private long personId;

}