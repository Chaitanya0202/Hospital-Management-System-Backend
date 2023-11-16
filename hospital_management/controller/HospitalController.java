package com.qsp.hospital_management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qsp.hospital_management.dto.Hospital;
import com.qsp.hospital_management.service.HospitalService;
import com.qsp.hospital_management.util.ResponseStructure;

@RestController
@CrossOrigin("http://localhost:3000/")
//@RequestMapping("/hospital")
public class HospitalController {
	@Autowired
	private HospitalService hospitalService;
	
	@PostMapping("/savehospital")
	public ResponseEntity<ResponseStructure<Hospital>> saveHospital(@RequestBody Hospital hospital) {
		return hospitalService.saveHospital(hospital);
	}
	

	
	
	@GetMapping("/getHospitalById")
	public ResponseEntity<ResponseStructure<Hospital>> getHospital(int id) {
		return hospitalService.getHospital(id);
	}
	
//	@GetMapping("/getAllHospital")
//	public ResponseEntity<ResponseStructure<List<Hospital>>> getAllHospital() {
//		return hospitalService.getAllHospital();
//	}
	
	@GetMapping("/getAllHospital")
	public List<Hospital> getAllHospital() {
		return hospitalService.getAllHospital();
	}
	
	@DeleteMapping("/deleteHospital")
	public ResponseEntity<ResponseStructure<Hospital>> deleteHospital(@RequestParam int hid) {
		return hospitalService.deleteHospital(hid);
	}
	
	@PutMapping("/update")
	public ResponseEntity<ResponseStructure<Hospital>> updateHospital(@RequestParam int id,@RequestBody Hospital hospital) {
		return hospitalService.updateHospital(id,hospital);
	}
	
	@GetMapping("/getHospitalByEmail")
	public ResponseEntity<ResponseStructure<Hospital>> getHospitalByEmail(@RequestParam String email) {
		return hospitalService.getHospitalByEmail(email);
	}
	
	@GetMapping("/getByName")
	public Hospital getHospitalByName(@RequestParam String name) {
		return hospitalService.getHospitalByName(name);
	}
	
	
	
}
