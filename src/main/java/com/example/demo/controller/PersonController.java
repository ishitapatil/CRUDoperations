package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Person;
import com.example.demo.Entity.Phone;
import com.example.demo.Repository.PersonRepository;
import com.example.demo.Repository.PhoneRepository;
import com.example.demo.Service.PersonService;
import com.example.demo.Service.PhoneService;

@RestController
public class PersonController {
	@Autowired
	PersonService personService;
	@Autowired
	PhoneService phoneService;
	
	@CrossOrigin(origins = "http://localhost:8081")
	@GetMapping("/person")
    public List<Person> getAllDetail() {
        return personService.getAllDetails();
    }
	@CrossOrigin(origins = "http://localhost:8081")
	@GetMapping("/phones/id")
    public Person getByID(@RequestParam(name ="id") long id ) {
        return personService.getByID(id);
    }
	
	@PostMapping("/saveperson")
	public String save(@RequestBody Person person, ModelMap modelMap) {
		
		Person p = new Person();
		p.setFname(person.getFname());
		p.setLname(person.getLname());
		personService.create(p);
		List<Phone> phones = person.getPhones();
		for (Phone phone : phones) {
			phone.setPerson(p);
			phoneService.create(phone);
		}
		return "Success";
	}
	
	
}
