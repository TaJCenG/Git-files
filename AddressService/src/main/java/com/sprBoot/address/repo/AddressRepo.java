package com.sprBoot.address.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sprBoot.address.entity.Address;

@Repository
public interface AddressRepo extends JpaRepository<Address, Long> {
	
}

	