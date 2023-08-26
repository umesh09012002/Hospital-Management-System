package com.qsp.hospital_app.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qsp.hospital_app.dto.MedItems;

public interface MedItemsRepo extends JpaRepository<MedItems, Integer> {

}
