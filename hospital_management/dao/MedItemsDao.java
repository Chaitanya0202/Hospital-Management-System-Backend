package com.qsp.hospital_management.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.qsp.hospital_management.dto.MedItems;
import com.qsp.hospital_management.dto.MedOrder;
import com.qsp.hospital_management.repo.MedItemsRepo;
import com.qsp.hospital_management.util.ResponseStructure;

@Repository
public class MedItemsDao {
	@Autowired
	private MedItemsRepo itemsRepo;
	@Autowired
	private MedOrderDao mDao;


	public MedItems saveItems(MedItems items, int mid) {
		MedOrder medOrder=mDao.getMedOrderById(mid);
		items.setMedOrder(medOrder);
		return itemsRepo.save(items);
	}


	public MedItems getItemsById(int id) {
		// TODO Auto-generated method stub
		Optional<MedItems>optional= itemsRepo.findById(id);
		if(optional!=null) {
			 MedItems items=optional.get();
			 return items;
		}
		return null;
	}


	public MedItems deleteItemsById(int id) {
		// TODO Auto-generated method stub
		if (itemsRepo.findById(id).isPresent()) {
			MedItems medItems = itemsRepo.findById(id).get();
			itemsRepo.deleteById(id);
			return medItems;
		} else {
			return null;
		}
	}
	

}
