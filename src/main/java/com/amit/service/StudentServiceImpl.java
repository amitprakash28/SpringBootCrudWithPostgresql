package com.amit.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.amit.entity.Student;
import com.amit.exception.DatabaseEmptyException;
import com.amit.exception.StudentNotFoundException;
import com.amit.repository.StudentDao;

@Service
public class StudentServiceImpl implements StudentService{
	
	
	@Autowired
	private StudentDao sDao; 
	
	
	@Override
	public ResponseEntity<Student> saveStudent(Student student) {
		Student saved = sDao.save(student);
		return new ResponseEntity<Student>(saved, HttpStatus.OK);
	}

	
	@Override
	public ResponseEntity<Student> getStudentById(Integer id) {
		Optional<Student> stdOpt =sDao.findBySid(id); 
		if(stdOpt.isPresent()) {
			Student foundStudent = stdOpt.get();
			return new ResponseEntity<Student>(foundStudent, HttpStatus.OK);
		}
		else {
			throw new StudentNotFoundException("No Student found with id " + id);
		}
		
	}

	
	@Override
	public ResponseEntity<List<Student>> getAllStudents() {
		if(sDao.findAll().size() != 0) {
			return new ResponseEntity<List<Student>>(sDao.findAll(), HttpStatus.FOUND);			
		}
		else {
			throw new DatabaseEmptyException("Database is empty right now");
		}
	}
	
	

	@Override
	public ResponseEntity<Student> updateStudent(Integer id, Student student) {
	Optional<Student> stdOpt = sDao.findBySid(id);
	 if(stdOpt.isPresent()) {
		 Student foundStudent = stdOpt.get(); 
		 foundStudent.setFirstName(foundStudent.getFirstName());
		 foundStudent.setLastName(student.getLastName());
		 foundStudent.setMarks(student.getMarks());
		 return new ResponseEntity<Student>(sDao.save(foundStudent), HttpStatus.OK);
	 }
	 else {
		 throw new StudentNotFoundException("No Student found with id " + id);
	 }
		
	}

	
	
	@Override
	public ResponseEntity<String> deleteStudent(Integer id) {
		Optional<Student> stdOpt = sDao.findBySid(id);
		if(stdOpt.isPresent()) {
			sDao.delete(stdOpt.get());
			String message = "Deleted Successfully";
			return new ResponseEntity<String>(message, HttpStatus.OK); 
		}
		else {
			throw new StudentNotFoundException("No Student found with id " + id);
		}
	}

}
