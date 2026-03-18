package com.sprBoot.student.response;

import com.sprBoot.student.entity.Student;

public class StudentResponse {
	
	private Long Id;	
	private String firstName;
	private String lastName;
	private String email;
	
	private AddressResponse addressResponse;
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public StudentResponse(Student student) {
		super();
		this.Id = student.getId();
		this.firstName = student.getFirstName();
		this.lastName = student.getLastName();
		this.email = student.getEmail();
	}
	public AddressResponse getAddressResponse() {
		return addressResponse;
	}
	public void setAddressResponse(AddressResponse addressResponse) {
		this.addressResponse = addressResponse;
	}
	

}
