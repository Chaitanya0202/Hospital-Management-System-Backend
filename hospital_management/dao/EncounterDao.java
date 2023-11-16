package com.qsp.hospital_management.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.hospital_management.dto.Encounter;
import com.qsp.hospital_management.exception.EncounterIdNotFoundException;
import com.qsp.hospital_management.repo.EncounterRepo;

@Repository
public class EncounterDao {
	@Autowired
	private EncounterRepo encounterRepo;
	




	public Encounter getEncounterById(int id) {
		// TODO Auto-generated method stub
		Optional<Encounter>optional= encounterRepo.findById(id);
		if(optional!=null) {
			Encounter encounter=optional.get();
			return encounter;
		}
		throw new EncounterIdNotFoundException("Id nhi hai Aayega kya -->Nahi haai na? ");
	}


	public Encounter saveEncounter(Encounter encounter) {
		// TODO Auto-generated method stub
		return encounterRepo.save(encounter) ;
	}

}
