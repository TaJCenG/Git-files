package com.sprBoot.student.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.sprBoot.student.response.AddressResponse;

@FeignClient(value = "ADDRESSSERVICE", path = "/address")
public interface AddressFeignClient {
	
	@GetMapping("/{id}")
	public AddressResponse getAddressById (@PathVariable long id);

}