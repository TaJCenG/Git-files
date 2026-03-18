package com.sprBoot.student.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sprBoot.student.entity.Student;
import com.sprBoot.student.repo.StudentRepo;
import com.sprBoot.student.request.CreateStudentRequest;
import com.sprBoot.student.response.AddressResponse;
import com.sprBoot.student.response.StudentResponse;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepo studentRepo;
	
	@Autowired
	AddressFeignClient addressFeignClient;
	
	@Autowired CommonService commonService;

	public StudentResponse createNewStudent(CreateStudentRequest request) {
		Student student = new Student();
		student.setFirstName(request.getFirstName());
		student.setLastName(request.getLastName());
		student.setEmail(request.getEmail());
		student.setAddressId(request.getAddressId());
		student = studentRepo.save(student);
		StudentResponse response = new StudentResponse(student);
		response.setAddressResponse(commonService.getAddressById(student.getAddressId()));
		
		return response;
	}

	public StudentResponse getStudentById(long id) {
		Student student = studentRepo.findById(id).get();
		StudentResponse response = new StudentResponse(student);
		response.setAddressResponse(commonService.getAddressById(student.getAddressId()));
		return response;
	}
	
}
