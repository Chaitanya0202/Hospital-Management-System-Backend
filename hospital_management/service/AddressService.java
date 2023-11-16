package com.qsp.hospital_management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qsp.hospital_management.dao.AddressDao;
import com.qsp.hospital_management.dto.Address;
@Service
public class AddressService {
	@Autowired
	private AddressDao addressDao;

	public Address saveAddress(Address address) {
		// TODO Auto-generated method stub
		return addressDao.saveAddress(address);
	}

	public Address updateAddress(int id, Address address) {
		// TODO Auto-generated method stub
		return addressDao.updateAddress(id,address);
	}

	public Address deleteAddress(int id) {
		// TODO Auto-generated method stub
		return addressDao.deleteAddress(id);
	}

	public List<Address> getAddress() {
		// TODO Auto-generated method stub
		return addressDao.getAddress();
	}

	public Address getByPincode(int pincode) {
		// TODO Auto-generated method stub
		return addressDao.getByPincode(pincode);
	}

}
