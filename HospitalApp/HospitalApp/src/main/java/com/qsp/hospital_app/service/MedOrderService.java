package com.qsp.hospital_app.service;

import java.sql.Struct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.qsp.hospital_app.dao.MedOrderDao;
import com.qsp.hospital_app.dto.MedOrder;
import com.qsp.hospital_app.exception.IdNotFoundException;
import com.qsp.hospital_app.util.ResponseStructure;

@Service
public class MedOrderService {
	
	@Autowired
	private MedOrderDao dao;
	
	ResponseStructure<MedOrder> structure=new ResponseStructure<MedOrder>();
	
	public ResponseEntity<ResponseStructure<MedOrder>> saveMedOrder(MedOrder medOrder,int eid)
	{
		structure.setMessage("Saved");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setData(dao.saveMedOrder(medOrder,eid));
		
		return new ResponseEntity<ResponseStructure<MedOrder>>(structure,HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<MedOrder>> updateMedOrder(int id,MedOrder medOrder)
	{
		MedOrder medOrder2=dao.getMedOrderById(id);
		if(medOrder2!=null)
		{
			medOrder.setEncounter(medOrder2.getEncounter());
			structure.setMessage("Updated");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(dao.updateMedOrder(id, medOrder));
			
			return new ResponseEntity<ResponseStructure<MedOrder>>(structure,HttpStatus.OK);
		}
		else
		{
			throw new IdNotFoundException("Id Not Present!!!");
		}
		
	}
	
	public ResponseEntity<ResponseStructure<MedOrder>> getMedOrderById(int id)
	{
		MedOrder medOrder=dao.getMedOrderById(id);
		if(medOrder!=null)
		{
			structure.setMessage("Found");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(medOrder);
			
			return new ResponseEntity<ResponseStructure<MedOrder>>(structure,HttpStatus.FOUND);
		}
		else
		{
			throw new IdNotFoundException("Id Not Present!!!");
		}
	}
	
	public ResponseEntity<ResponseStructure<MedOrder>> deleteMedOrder(int id)
	{
		MedOrder medOrder=dao.getMedOrderById(id);
		if(medOrder!=null)
		{
			structure.setMessage("Deleted");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(medOrder);
			
			return new ResponseEntity<ResponseStructure<MedOrder>>(structure,HttpStatus.OK);
		}
		else
		{
			throw new IdNotFoundException("Id Not Present!!!");
		}
	}
	

}
