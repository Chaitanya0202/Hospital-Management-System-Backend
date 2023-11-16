package com.qsp.hospital_management.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.hospital_management.dto.Hospital;
import com.qsp.hospital_management.repo.HospitalRepo;
@Repository
public class HospitalDao {
	@Autowired
	private HospitalRepo hospitalRepo;



	public Hospital saveHospital(Hospital hospital) {
		// TODO Auto-generated method stub
		return hospitalRepo.save(hospital);
	}



	public Hospital getHospital(int id) {
		// TODO Auto-generated method stub
		Optional<Hospital>optional=hospitalRepo.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}



	public Hospital deleteHospital(int id) {
		Optional<Hospital>optional=hospitalRepo.findById(id);
		if(optional.isPresent()) {
			Hospital hospital=optional.get();
			hospitalRepo.delete(hospital);
			return hospital;
		}
		return null;
		
	}



	public Hospital updateHospital(int id, Hospital hospital) {
		Optional<Hospital>optional=hospitalRepo.findById(id);
		if(optional.isPresent()) {
			hospital.setId(id);
			return hospitalRepo.save(hospital);
		}
		return null;
	}



	public Hospital getHospitalByEmail(String email) {
		// TODO Auto-generated method stub
		return hospitalRepo.findHospitalByEmail(email);
	}



//	public List<Hospital> getAllHospital() {
//		// TODO Auto-generated method stub
//		return hospitalRepo.findAll();
//	}



	public Hospital getHospitalByName(String name) {
		// TODO Auto-generated method stub
		return hospitalRepo.findHospitalByName(name);
	}



	public List<Hospital> getAllHospital() {
		// TODO Auto-generated method stub
		return hospitalRepo.findAll();
	}



}
