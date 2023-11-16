package com.qsp.hospital_management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.qsp.hospital_management.dao.MedItemsDao;
import com.qsp.hospital_management.dto.MedItems;
import com.qsp.hospital_management.util.ResponseStructure;

import net.bytebuddy.asm.Advice.Return;

@Service
public class MedItemsService {
	@Autowired
	private MedItemsDao iDao;
	
	ResponseStructure<MedItems> structure = new ResponseStructure<>();

	public ResponseEntity<ResponseStructure<MedItems>> saveItems(MedItems items, int mid) {
		
		structure.setMessage("Data Insertd Successfull");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setData(iDao.saveItems(items, mid));
		return new ResponseEntity<ResponseStructure<MedItems>>(structure,HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<MedItems>> getItemsById(int id) {
		// TODO Auto-generated method stub
		structure.setMessage("Found Success");
		structure.setStatus(HttpStatus.FOUND.value());
		structure.setData(iDao.getItemsById(id));
		return new ResponseEntity<ResponseStructure<MedItems>>(structure,HttpStatus.FOUND);
	}

	public MedItems deleteItemsById(int id) {
		// TODO Auto-generated method stub
		return iDao.deleteItemsById(id);
	}
	

}
