package com.qsp.hospital_management.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.hospital_management.dto.Address;
import com.qsp.hospital_management.dto.Hospital;
import com.qsp.hospital_management.repo.AddressRepo;
@Repository
public class AddressDao {
	@Autowired
	private AddressRepo addressRepo;

	public Address saveAddress(Address address) {
		// TODO Auto-generated method stub
		return addressRepo.save(address);
	}
	public Address getAddress(int id) {
		Optional<Address>optional=addressRepo.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	public Address updateAddress(int id, Address address) {
		Optional<Address>optional=addressRepo.findById(id);
		if(optional.isPresent()) {
			address.setId(id);
			addressRepo.save(address);
		}
		return address;
	}

	public Address deleteAddress(int id) {
		Optional<Address>optional=addressRepo.findById(id);
		if(optional.isPresent()) {
			Address address=optional.get();
			addressRepo.delete(address);
			return address;
		}
		return null;
	}

	public List<Address> getAddress() {
		// TODO Auto-generated method stub
		return addressRepo.findAll();
	}

	public Address getByPincode(int pincode) {
		// TODO Auto-generated method stub
		return addressRepo.findAddressByPincode(pincode);
	}

}
