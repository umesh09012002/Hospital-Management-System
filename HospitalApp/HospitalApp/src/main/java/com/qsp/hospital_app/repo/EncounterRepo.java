package com.qsp.hospital_app.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qsp.hospital_app.dto.Encounter;

public interface EncounterRepo extends JpaRepository<Encounter, Integer>{

}
