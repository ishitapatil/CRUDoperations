package com.example.crud.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class Person {

	private long id;

	private String firstName;

	private String lastName;

	private List<Phone> phones = new ArrayList<>();

}