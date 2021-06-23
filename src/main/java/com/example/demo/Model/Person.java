package com.example.demo.Model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "person")
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name= "firstName")
	private String firstName;
	
	@Column(name= "lastName")
	private String lastName;
		
	@OneToMany(mappedBy = "person",cascade = {CascadeType.PERSIST,CascadeType.MERGE})
	List<Phone> phoneNumbers;	
}