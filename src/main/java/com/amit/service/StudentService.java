package com.amit.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.amit.entity.Student;

public interface StudentService {

	public ResponseEntity<Student> saveStudent(Student student);
	
	public ResponseEntity<Student> getStudentById(Integer id); 
	public ResponseEntity<List<Student>> getAllStudents(); 
	
	public ResponseEntity<Student> updateStudent(Integer id, Student student);
	
	public ResponseEntity<String> deleteStudent(Integer id);
	
	
}
