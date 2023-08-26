package com.qsp.hospital_app.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.hospital_app.dto.Hospital;
import com.qsp.hospital_app.repo.HospitalRepo;

@Repository
public class HospitalDao {
	
	@Autowired
	private HospitalRepo hospitalRepo;
	
	public Hospital saveHospital(Hospital hospital)
	{
		return hospitalRepo.save(hospital);
	}
	
	public Hospital getHospitalById(int id)
	{
		return hospitalRepo.findById(id).get();
	}
	
	public Hospital getHospitalByEmail(String email)
	{
		return hospitalRepo.findByEmail(email);
	}
	
	public List<Hospital> getAllHospitals()
	{
		return hospitalRepo.findAll();
	}
	
	public Hospital deleteHospital(int id)
	{
		if(getHospitalById(id)!=null)
		{
			Hospital hospital=getHospitalById(id);
			hospitalRepo.deleteById(id);
			return hospital;
		}
		return null;
	}
	
	public Hospital updateHospital(int id,Hospital hospital)
	{
		if(getHospitalById(id)!=null)
		{
			hospital.setId(id);
			return hospitalRepo.save(hospital);
		}
		return null;
	}

}
