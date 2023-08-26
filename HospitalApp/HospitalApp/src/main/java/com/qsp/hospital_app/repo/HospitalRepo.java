package com.qsp.hospital_app.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qsp.hospital_app.dto.Hospital;

public interface HospitalRepo extends JpaRepository<Hospital, Integer> {
	
	public Hospital findByEmail(String email);

}
