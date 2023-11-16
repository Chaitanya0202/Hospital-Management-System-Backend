package com.qsp.hospital_management.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.qsp.hospital_management.dao.BranchDao;
import com.qsp.hospital_management.dao.EncounterDao;
import com.qsp.hospital_management.dao.PersonDao;
import com.qsp.hospital_management.dto.Branch;
import com.qsp.hospital_management.dto.Encounter;
import com.qsp.hospital_management.dto.Hospital;
import com.qsp.hospital_management.dto.Person;
import com.qsp.hospital_management.util.ResponseStructure;
@Service
public class EncounterService {
	@Autowired
	private EncounterDao edao;
	@Autowired
	private PersonDao pdao;
	@Autowired
	private BranchDao branchDao;
	
	ResponseStructure<Encounter> structure = new ResponseStructure<Encounter>();
	public ResponseEntity<ResponseStructure<Encounter>> saveEncounter(Encounter encounter, int pid, int bid) {
//		ResponseStructure<List<Encounter>> structure = new ResponseStructure<List<Encounter>>();
		Person person=pdao.getPersonById(pid);
//		person.setId(pid);
		Branch branch=branchDao.getBranchById(pid);
		
		List<Branch>lb=new ArrayList<>();
		lb.add(branch);
		encounter.setPerson(person);
		encounter.setBranchs(lb);
		ResponseStructure<Encounter> structure = new ResponseStructure<>();
		structure.setMessage("Saved");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setData(edao.saveEncounter(encounter));
		return new ResponseEntity<ResponseStructure<Encounter>>(structure, HttpStatus.CREATED);

		
	}


	public Encounter getEncounterById(int id) {
		// TODO Auto-generated method stub
		return edao.getEncounterById(id);
	}

}
