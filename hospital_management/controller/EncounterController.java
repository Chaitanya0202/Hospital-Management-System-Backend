package com.qsp.hospital_management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qsp.hospital_management.dto.Encounter;

import com.qsp.hospital_management.service.EncounterService;
import com.qsp.hospital_management.util.ResponseStructure;

@RestController
@RequestMapping("/encounter")
public class EncounterController {
	@Autowired
	private EncounterService encounterService;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<Encounter>> saveEncounter(@RequestBody Encounter encounter,@RequestParam int pid,@RequestParam int bid) {
		return encounterService.saveEncounter(encounter,pid,bid);
	}
	@GetMapping
	public Encounter getEncounterById(@RequestParam int id) {
		return encounterService.getEncounterById(id);
	}
}
