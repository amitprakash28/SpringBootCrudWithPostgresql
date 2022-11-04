package com.amit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amit.entity.Student;
import com.amit.service.StudentService;

@RestController
@RequestMapping("/api/v1")
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	
	@PostMapping("/students")
	public ResponseEntity<Student> saveStudentHandler(@RequestBody Student student){
		return studentService.saveStudent(student);
	}
	
	
	@GetMapping("/students")
	public ResponseEntity<List<Student>> getAllStudentHandler(){
		return studentService.getAllStudents(); 
	}
	
	
	@GetMapping("/students/{id}")
	public ResponseEntity<Student> getStudentByIdHandler(@PathVariable Integer id){
		return studentService.getStudentById(id); 
	}
	
	
	@PutMapping("/students/{id}")
	public ResponseEntity<Student> updateStudentHandler(@RequestBody Student student, @PathVariable Integer id){
		return studentService.updateStudent(id, student);
	}
	
	
	@DeleteMapping("/students/{id}")
	public ResponseEntity<String> deleteStudentHandler(@PathVariable Integer id){
		return studentService.deleteStudent(id);
	}
}
