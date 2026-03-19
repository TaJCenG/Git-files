package com.sprBoot.address.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sprBoot.address.request.CreateAdddressRequest;
import com.sprBoot.address.response.AddressResponse;
import com.sprBoot.address.service.AddressService;

@RestController
@RequestMapping("/address")
public class AddressController {
	
	@Autowired
	private AddressService addressService;
	
	@PostMapping("/addNewAddress")
	public AddressResponse createNewAddress (@RequestBody CreateAdddressRequest request){
		return addressService.createNewAddress(request); 
	}
	
	@GetMapping("/{id}")
	public AddressResponse getAddressById (@PathVariable long id){
		return addressService.getAddressById(id); 
	}

}
