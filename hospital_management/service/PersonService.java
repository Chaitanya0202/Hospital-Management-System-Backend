package com.qsp.hospital_management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qsp.hospital_management.dao.PersonDao;
import com.qsp.hospital_management.dto.Branch;
import com.qsp.hospital_management.dto.Person;

@Service
public class PersonService {
	
	@Autowired
	private PersonDao personDao;

	public Person savePerson(Person person) {
		// TODO Auto-generated method stub
		return personDao.savePerson(person);
	}

	public Person getPersonById(int id) {
		// TODO Auto-generated method stub
		return personDao.getPersonById(id);
	}

	public Person deletePersonById(int id) {
		// TODO Auto-generated method stub
		return personDao.deletePersonById(id);
	}

	public Person updatePerson(int id, Person person) {
		// TODO Auto-generated method stub
		return personDao.updatePerson(id,person);
	}

	public Person getPersonByPhone(long phone) {
		// TODO Auto-generated method stub
		return personDao.getPersonByPhone(phone);
	}

	public Person getPersonByName(String name) {
		// TODO Auto-generated method stub
		return personDao.getPersonByName(name);
	}

	public Person getPersonByEmail(String email) {
		// TODO Auto-generated method stub
		return personDao.getPersonByEmail(email);
	}

	public Person getPersonByAddress(String address) {
		// TODO Auto-generated method stub
		return personDao.getPersonByAddress(address);
	}
	
	
	

}
