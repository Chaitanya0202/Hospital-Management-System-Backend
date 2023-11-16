package com.qsp.hospital_management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qsp.hospital_management.dto.Address;
import com.qsp.hospital_management.dto.Branch;
import com.qsp.hospital_management.dto.Hospital;
import com.qsp.hospital_management.service.BranchService;

@RestController
@RequestMapping("/branch")
public class BranchController {
	@Autowired
	private BranchService branchService;
	
	@PostMapping
	public Branch saveBranch(@RequestParam int h_id,@RequestParam int a_id,@RequestBody Branch branch) {
		return branchService.saveBranch(h_id,a_id,branch);
	}
	
//	@GetMapping
//	public Branch getBranchByHospital(@RequestParam int h_id,@RequestBody Branch branch) {
//		return branchService.getBranchByHospital(h_id,branch);
//	}
	
	@GetMapping
	public Branch getBranchById(@RequestParam int id) {
		return branchService.getBranchById(id);
	}
	
	
	
	
}
