package com.qsp.hospital_management.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qsp.hospital_management.dto.Address;

public interface AddressRepo extends JpaRepository<Address, Integer>{

	

	Address findAddressByPincode(int pincode);

}
