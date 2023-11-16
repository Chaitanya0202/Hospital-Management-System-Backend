package com.qsp.hospital_management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.qsp.hospital_management.dto.MedItems;
import com.qsp.hospital_management.service.MedItemsService;
import com.qsp.hospital_management.util.ResponseStructure;

@RestController
@RequestMapping("/items")
public class MedItemsController {
	@Autowired
	private MedItemsService itemsService;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<MedItems>> saveItems(@RequestBody MedItems items,@RequestParam int mid) {
		return itemsService.saveItems(items,mid);
	}
	
	@GetMapping
	public ResponseEntity<ResponseStructure<MedItems>> getItemsById(@RequestParam int id) {
	
		return itemsService.getItemsById(id);
	}
	
	@DeleteMapping
	public MedItems deleteItemsById(@RequestParam int id) {
	
		return itemsService.deleteItemsById(id);
	}
	
	
	
	
	
}
