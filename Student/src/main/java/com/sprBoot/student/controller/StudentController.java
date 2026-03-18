package com.sprBoot.student.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sprBoot.student.request.CreateStudentRequest;
import com.sprBoot.student.response.StudentResponse;
import com.sprBoot.student.service.StudentService;

@RestController
@RequestMapping("/Student")
public class StudentController {
	
	@Autowired
	private StudentService StudentService;
	
	@PostMapping("/addNewStudent")
	public StudentResponse createNewStudent (@RequestBody CreateStudentRequest request){
		return StudentService.createNewStudent(request); 
	}
	
	@GetMapping("/{id}")
	public StudentResponse getStudentById (@PathVariable long id){
		return StudentService.getStudentById(id); 
	}

}
