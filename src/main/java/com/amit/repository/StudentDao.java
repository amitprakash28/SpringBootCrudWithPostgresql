package com.amit.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amit.entity.Student;

public interface StudentDao extends JpaRepository<Student, Integer> {

	public Optional<Student> findBySid(Integer id); 
}
