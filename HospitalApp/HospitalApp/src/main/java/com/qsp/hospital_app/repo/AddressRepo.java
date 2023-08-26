package com.qsp.hospital_app.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qsp.hospital_app.dto.Address;

public interface AddressRepo extends JpaRepository<Address, Integer> {

}
