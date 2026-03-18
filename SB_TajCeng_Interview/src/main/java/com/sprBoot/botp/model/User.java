package com.sprBoot.botp.model;

import jakarta.persistence.*;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "User_entries") // Use plural form for table name
public class User {

//    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
    private ObjectId id;
	private String name;
	private String email;
	private String address;
	private LocalDateTime date;





	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}
}