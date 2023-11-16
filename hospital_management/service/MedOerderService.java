package com.qsp.hospital_management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.qsp.hospital_management.controller.MedOrderController;
import com.qsp.hospital_management.dao.EncounterDao;
import com.qsp.hospital_management.dao.MedOrderDao;
import com.qsp.hospital_management.dto.Encounter;
import com.qsp.hospital_management.dto.MedOrder;
import com.qsp.hospital_management.exception.IdNotFoundException;
import com.qsp.hospital_management.util.ResponseStructure;
@Service
public class MedOerderService {
	@Autowired
	private MedOrderDao mDao;
	ResponseStructure<MedOrder> structure = new ResponseStructure<>();

	public ResponseEntity<ResponseStructure<MedOrder>> saveMedOrder(MedOrder medOrder, int eid) {
		structure.setMessage("Saved");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setData(mDao.saveMedOrder(medOrder, eid));
		return new ResponseEntity<ResponseStructure<MedOrder>>(structure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<MedOrder>> getMedOrderById(int id) {
		MedOrder medOrder=mDao.getMedOrderById(id);
		if(medOrder!=null) {
			
			structure.setMessage("FOund SuccessFull");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(mDao.getMedOrderById(id));
			return new ResponseEntity<ResponseStructure<MedOrder>>(structure,HttpStatus.FOUND);
		}
		throw new IdNotFoundException("Id not found for MedOrder");
		
	}

	public ResponseEntity<ResponseStructure<MedOrder>>deleteMedOrder(int id) {
		MedOrder medOrder=mDao.getMedOrderById(id);
		if(medOrder!=null) {
			
			structure.setMessage("FOund SuccessFull");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(mDao.deleteMedOrder(id));
			return new ResponseEntity<ResponseStructure<MedOrder>>(structure,HttpStatus.OK);
		}
		throw new IdNotFoundException("Id not found for MedOrder");
	}

	public ResponseEntity<ResponseStructure<MedOrder>> updateMedOrder(MedOrder medOrder, int id) {
		// TODO Auto-generated method stub
		MedOrder dbmedOrder=mDao.getMedOrderById(id);
		
		medOrder.setEncounter(dbmedOrder.getEncounter());
		
//		MedOrder daoMedOrder = mDao.updateMedOrder(id, medOrder);
		 	
			structure.setMessage("FOund SuccessFull");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(mDao.updateMedOrder(id,medOrder));
			
			
			return new ResponseEntity<ResponseStructure<MedOrder>>(structure, HttpStatus.OK);
		
	}

	public MedOrder FindByDoctor(String doctor) {
		// TODO Auto-generated method stub
		return mDao.FindByDoctor(doctor);
	}


}
