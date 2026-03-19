package com.sprBoot.address.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprBoot.address.entity.Address;
import com.sprBoot.address.repo.AddressRepo;
import com.sprBoot.address.request.CreateAdddressRequest;
import com.sprBoot.address.response.AddressResponse;

@Service
public class AddressService {
	
	@Autowired
	private AddressRepo addressRepo;

	public AddressResponse createNewAddress(CreateAdddressRequest request) {
		Address address = new Address();
		address.setStreet(request.getStreet());
		address.setCity(request.getCity());
		addressRepo.save(address);
		return new AddressResponse(address);
	}

	public AddressResponse getAddressById(long id) {
		System.out.println("Inside getAddressById" + id);
		Address address = addressRepo.findById(id).get();
		
		return new AddressResponse(address);
	}

}
