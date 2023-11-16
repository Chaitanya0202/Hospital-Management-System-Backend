package com.qsp.hospital_management.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;


import com.qsp.hospital_management.dto.Encounter;
import com.qsp.hospital_management.dto.MedOrder;
import com.qsp.hospital_management.exception.EncounterIdNotFoundException;
import com.qsp.hospital_management.repo.MedOrderRepo;
import com.qsp.hospital_management.util.ResponseStructure;

@Repository
public class MedOrderDao {
	@Autowired
	private MedOrderRepo medOrderRepo;
	@Autowired
	private EncounterDao edao;


	public MedOrder saveMedOrder(MedOrder medOrder, int eid) {
		Encounter encounter = edao.getEncounterById(eid);
		medOrder.setEncounter(encounter);
		return medOrderRepo.save(medOrder);
	}


	public MedOrder getMedOrderById(int id) {
		return medOrderRepo.findById(id).get();
	}


	public MedOrder deleteMedOrder(int id) {
		// TODO Auto-generated method stub
		Optional<MedOrder>optional=medOrderRepo.findById(id);
		if(optional!= null) {
			MedOrder medOrder=optional.get();
			medOrderRepo.delete(medOrder);
			return medOrder;
		}
		return null;
	}


	public MedOrder updateMedOrder(int id, MedOrder medOrder) {
		Optional<MedOrder>optional=medOrderRepo.findById(id);
		if(optional!= null) {
			MedOrder dbmedOrder1=optional.get();
			medOrder.setId(id);
			medOrder.setEncounter(dbmedOrder1.getEncounter());
			
			
			medOrderRepo.save(medOrder);
			return medOrder;
		}
		return null;
	}


	public MedOrder FindByDoctor(String doctor) {
		// TODO Auto-generated method stub
		return medOrderRepo.findMedOrderByDoctor(doctor);
	}



}
