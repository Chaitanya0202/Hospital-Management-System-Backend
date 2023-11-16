package com.qsp.hospital_management.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.qsp.hospital_management.dto.Branch;
import com.qsp.hospital_management.dto.Hospital;
import com.qsp.hospital_management.repo.BranchRepo;

@Repository
public class BranchDao {
	@Autowired
	private BranchRepo branchRepo;

	public Branch saveBranch(Branch branch) {
		// TODO Auto-generated method stub
		return branchRepo.save(branch);
	}

	public Branch getBranchById(int id) {
		Optional<Branch>optional=branchRepo.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

}
