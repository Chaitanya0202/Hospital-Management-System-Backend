package com.qsp.hospital_management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qsp.hospital_management.dto.Address;

import com.qsp.hospital_management.service.AddressService;

@RestController
@RequestMapping("/address")
public class AddressController {
	@Autowired
	private AddressService addressService;
	
	@PostMapping
	public Address saveAddress(@RequestBody Address address) {
		return addressService.saveAddress(address);
	}
	
	@PutMapping
	public Address updateAddress(@RequestParam int id,@RequestBody Address address) {
		return addressService.updateAddress(id,address);
	}
	@DeleteMapping
	public Address deleteAddress(@RequestParam int id) {
		return addressService.deleteAddress(id);
	}
	@GetMapping
	public List<Address> getAddress() {
		return addressService.getAddress();
	}
	@GetMapping("/getAddByPincode")
	public Address getByPincode(@RequestParam int pincode) {
		return addressService.getByPincode(pincode);
	}
	
	
	
}
