package com.example.demo.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "phone")
public class Phone {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int phoneId;
	
	@Column(name = "number")
	private String number;
	
	@Column(name = "type")
	private String type;
	
	@Column(name="personId")
	private long personId;
	
}