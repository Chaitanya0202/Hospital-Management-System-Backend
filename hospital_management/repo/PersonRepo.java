package com.qsp.hospital_management.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qsp.hospital_management.dto.Person;

public interface PersonRepo extends JpaRepository<Person, Integer>{

	Person findPersonByPhone(long phone);

	Person findPersonByName(String name);

	Person findPersonByemail(String email);

	

	Person findPersonByAddress(String address);

}
