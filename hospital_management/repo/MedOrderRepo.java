package com.qsp.hospital_management.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qsp.hospital_management.dto.MedOrder;

public interface MedOrderRepo extends JpaRepository<MedOrder, Integer>{

	MedOrder findMedOrderByDoctor(String doctor);

}
