package com.qsp.hospital_management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qsp.hospital_management.dao.AddressDao;
import com.qsp.hospital_management.dao.BranchDao;
import com.qsp.hospital_management.dao.HospitalDao;
import com.qsp.hospital_management.dto.Address;
import com.qsp.hospital_management.dto.Branch;
import com.qsp.hospital_management.dto.Hospital;

@Service
public class BranchService {
	@Autowired
	private BranchDao branchDao;
	
	@Autowired
	private HospitalDao hDao;
	@Autowired
	private AddressDao adao;

	public Branch saveBranch(int h_id, int a_id, Branch branch) {
		Hospital hospital=hDao.getHospital(h_id);
		Address address=adao.getAddress(a_id);
		if(hospital!=null && address!=null) {
			branch.setHospital(hospital);
			branch.setAddress(address);
			return branchDao.saveBranch(branch);
		}
		return null;
	}



	public Branch getBranchByHospital(int h_id, Branch branch) {
		Hospital hospital=hDao.getHospital(h_id);
		String hName=hospital.getName();
			
		return null;
	}



	public Branch getBranchById(int id) {
		// TODO Auto-generated method stub
		return branchDao.getBranchById(id);
	}

}
