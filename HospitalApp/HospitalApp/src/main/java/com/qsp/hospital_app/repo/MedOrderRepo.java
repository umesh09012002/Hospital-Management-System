package com.qsp.hospital_app.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qsp.hospital_app.dto.MedOrder;

public interface MedOrderRepo extends JpaRepository<MedOrder, Integer> {

}
