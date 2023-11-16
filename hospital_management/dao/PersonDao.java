package com.qsp.hospital_management.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.qsp.hospital_management.dto.Person;
import com.qsp.hospital_management.repo.PersonRepo;
@Repository
public class PersonDao {
	
	@Autowired
	private PersonRepo personRepo;

	public Person savePerson(Person person) {
		// TODO Auto-generated method stub
		return personRepo.save(person);
	}

	public Person getPersonById(int id) {
		// TODO Auto-generated method stub
		Optional<Person>optional=personRepo.findById(id);
		if(optional.isPresent()) {
			
			return optional.get();
		}
		return null;
	}

	public Person deletePersonById(int id) {
		Optional<Person>optional=personRepo.findById(id);
		if(optional.isPresent()) {
			Person person=optional.get();
			personRepo.delete(person);
			return person;
		}
		return null;
	}

	public Person updatePerson(int id, Person person) {
		Optional<Person>optional=personRepo.findById(id);
		if(optional.isPresent()) {
			person.setId(id);
			return personRepo.save(person);
		}
		return null;
	}

	public Person getPersonByPhone(long phone) {
		// TODO Auto-generated method stub
		return personRepo.findPersonByPhone(phone);
	}

	public Person getPersonByName(String name) {
		// TODO Auto-generated method stub
		return personRepo.findPersonByName(name);
	}

	public Person getPersonByEmail(String email) {
		// TODO Auto-generated method stub
		return personRepo.findPersonByemail(email);
	}

	public Person getPersonByAddress(String address) {
		// TODO Auto-generated method stub
		return personRepo.findPersonByAddress(address);
	}

}
