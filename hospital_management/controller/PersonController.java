package com.qsp.hospital_management.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.qsp.hospital_management.dto.Person;
import com.qsp.hospital_management.service.PersonService;

@RestController
@RequestMapping("/person")
public class PersonController {
	@Autowired
	private PersonService personService;
	
	@PostMapping
	public Person savePerson(@Valid @RequestBody Person person) {
		return personService.savePerson(person);
	}
	
	@GetMapping
	public Person getPersonById(@RequestParam int id) {
		return personService.getPersonById(id);
	}
	
	@DeleteMapping
	public Person deletePersonById(@RequestParam int id) {
		return personService.deletePersonById(id);
	}
	@PutMapping
	public Person updatePerson(@RequestParam int id,@RequestBody Person person) {
		return personService.updatePerson(id,person);
	}
	
	
	@GetMapping("/getPersonByPhone")
	public Person getPersonByPhone(@RequestParam long phone) {
		return personService.getPersonByPhone(phone);
	}
	
	
	@GetMapping("/getPersonByName")
	public Person getPersonByName(@RequestParam String name) {
		return personService.getPersonByName(name);
	}
	
	@GetMapping("/getPersonByEmail")
	public Person getPersonByEmail(@RequestParam String email) {
		return personService.getPersonByEmail(email);
	}
	
	@GetMapping("/getPersonByAddress")
	public Person getPersonByAddress(@RequestParam String address) {
		return personService.getPersonByAddress(address);
	}
	
	
}
