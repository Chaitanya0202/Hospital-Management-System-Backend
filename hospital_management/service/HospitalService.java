package com.qsp.hospital_management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.qsp.hospital_management.dao.HospitalDao;
import com.qsp.hospital_management.dto.Hospital;
import com.qsp.hospital_management.exception.HospitalIdNotFoundException;
import com.qsp.hospital_management.exception.HospitalNoDataAvailableException;
import com.qsp.hospital_management.util.ResponseStructure;

import net.bytebuddy.implementation.bytecode.Throw;

@Service
public class HospitalService {
	@Autowired
	private HospitalDao dao;
	ResponseStructure<Hospital> structure = new ResponseStructure<Hospital>();

	public ResponseEntity<ResponseStructure<Hospital>> saveHospital(Hospital hospital) {

		structure.setMessage("Hospital Saved SuccessFully");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setData(dao.saveHospital(hospital));
		return new ResponseEntity<>(structure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Hospital>> getHospital(int id) {

		Hospital hospital = dao.getHospital(id);
		if (hospital != null) {

			structure.setMessage("Hospital Found SuccessFully");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(hospital);
			return new ResponseEntity<>(structure, HttpStatus.FOUND);
		} else {
//			structure.setMessage("Hospital NOT Found SuccessFully");
//			structure.setStatus(HttpStatus.NOT_FOUND.value());
//			structure.setData(hospital);
//			return new ResponseEntity<>(structure,HttpStatus.NOT_FOUND);
			throw new HospitalIdNotFoundException("Hospital Id Not Found Give Propere Id");
		}

	}

//	public ResponseEntity<ResponseStructure<List<Hospital>>> getAllHospital() {
//		ResponseStructure<List<Hospital>> structure = new ResponseStructure<List<Hospital>>();
//		structure.setMessage("Hospital ALL Found SuccessFully");
//		structure.setStatus(HttpStatus.FOUND.value());
//		structure.setData(dao.getAllHospital());
//		return new ResponseEntity<>(structure, HttpStatus.FOUND);
//	}

//	github.com/Rajath1091
//Delete
	public ResponseEntity<ResponseStructure<Hospital>> deleteHospital(int id) {

		Hospital hospital = dao.getHospital(id);
		if (hospital != null) {

			ResponseStructure<Hospital> structure = new ResponseStructure<Hospital>();
			structure.setMessage("Deleted The Data SuccesFully");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(dao.deleteHospital(id));
//		return dao.deleteHospital(id);
//		return structure;
			return new ResponseEntity<ResponseStructure<Hospital>>(structure, HttpStatus.OK);
		}
		else {
			throw new HospitalNoDataAvailableException("Abe Id Sahi Dal..");
		}
	}

	//Update
	public ResponseEntity<ResponseStructure<Hospital>> updateHospital(int id, Hospital hospital) {
		Hospital hospital2=dao.getHospital(id);
		if(hospital2!=null) {
			ResponseStructure<Hospital>structure=new ResponseStructure<Hospital>();
			structure.setMessage("Updated SuccessFull");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(dao.getHospitalByEmail("a@mail"));
			return new ResponseEntity<ResponseStructure<Hospital>>(structure,HttpStatus.OK);
		}
		throw new HospitalNoDataAvailableException("Kuch Nahi be Ess ID me..");
	}

	public ResponseEntity<ResponseStructure<Hospital>> getHospitalByEmail(String email) {
		Hospital hospital=dao.getHospitalByEmail(email);
		if(hospital!=null) {
			ResponseStructure<Hospital>structure=new ResponseStructure<Hospital>();
			structure.setMessage("Data Found");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(hospital);
			return new ResponseEntity<ResponseStructure<Hospital>>(structure,HttpStatus.FOUND); 
			
		}
		throw new HospitalNoDataAvailableException("kuch bhi nahi hai esme update karne k liye");
	}

	public Hospital getHospitalByName(String name) {
		// TODO Auto-generated method stub
		return dao.getHospitalByName(name);
	}

	public List<Hospital> getAllHospital() {
		// TODO Auto-generated method stub
		return dao.getAllHospital();
	}
}
