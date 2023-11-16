package com.qsp.hospital_management.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qsp.hospital_management.dto.Hospital;
import com.qsp.hospital_management.dto.MedOrder;
import com.qsp.hospital_management.service.MedOerderService;
import com.qsp.hospital_management.util.ResponseStructure;
@RestController
@RequestMapping("/medorder")
public class MedOrderController {
	@Autowired
	private MedOerderService medOerderService;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<MedOrder>> saveMedOrder( @RequestBody MedOrder medOrder,@RequestParam int eid) {
		return medOerderService.saveMedOrder(medOrder, eid);
	}
	@GetMapping
	public ResponseEntity<ResponseStructure<MedOrder>> getMedOrderById(int id) {
		return medOerderService.getMedOrderById(id);
	}
	
	@DeleteMapping
	public ResponseEntity<ResponseStructure<MedOrder>>  deleteMedOrder(int id) {
		return medOerderService.deleteMedOrder(id);
	}
	
	@PutMapping
	public ResponseEntity<ResponseStructure<MedOrder>> updateMedOrder(@RequestBody MedOrder medOrder,@RequestParam int id) {
		return medOerderService.updateMedOrder(medOrder,id);
	}
	
//	@GetMapping("/findMedorderByDoctor")
	public MedOrder FindByDoctor(String doctor) {
		return medOerderService.FindByDoctor(doctor);
	}
		

}
