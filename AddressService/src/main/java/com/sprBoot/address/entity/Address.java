package com.sprBoot.address.entity;

import jakarta.persistence.*;
@Entity
public class Address {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Long Id;	
	private String street;
	private String city;
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
}
