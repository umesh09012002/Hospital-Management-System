package com.qsp.hospital_app.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qsp.hospital_app.dto.Person;

public interface PersonRepo extends JpaRepository<Person, Integer>{
	
	

}
