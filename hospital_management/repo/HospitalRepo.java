package com.qsp.hospital_management.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qsp.hospital_management.dto.Hospital;

public interface HospitalRepo extends JpaRepository<Hospital, Integer> {

	Hospital findHospitalByEmail(String email);

	Hospital findHospitalByName(String name);
}
