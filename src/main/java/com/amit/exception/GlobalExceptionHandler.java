package com.amit.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

	
	@ExceptionHandler(StudentNotFoundException.class)
	public ResponseEntity<ErrorBean> throwStudentNotFoundException(StudentNotFoundException sne, WebRequest request){
		ErrorBean error = new ErrorBean(); 
		error.setMessage(sne.getMessage());
		error.setLocalDateTime(LocalDateTime.now());
		error.setDetails(request.getDescription(false));
		return new ResponseEntity<ErrorBean>(error, HttpStatus.BAD_REQUEST); 
	}
	
	
	@ExceptionHandler(DatabaseEmptyException.class)
	public ResponseEntity<ErrorBean> throwStudentNotFoundException(DatabaseEmptyException dbe, WebRequest request){
		ErrorBean error = new ErrorBean(); 
		error.setMessage(dbe.getMessage());
		error.setLocalDateTime(LocalDateTime.now());
		error.setDetails(request.getDescription(false));
		return new ResponseEntity<ErrorBean>(error, HttpStatus.BAD_REQUEST); 
	}
	
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorBean> throwStudentNotFoundException(Exception e, WebRequest request){
		ErrorBean error = new ErrorBean(); 
		error.setMessage(e.getMessage());
		error.setLocalDateTime(LocalDateTime.now());
		error.setDetails(request.getDescription(false));
		return new ResponseEntity<ErrorBean>(error, HttpStatus.BAD_REQUEST); 
	}
	
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<ErrorBean> throwStudentNotFoundException(NoHandlerFoundException nhe, WebRequest request){
		ErrorBean error = new ErrorBean(); 
		error.setMessage(nhe.getMessage());
		error.setLocalDateTime(LocalDateTime.now());
		error.setDetails(request.getDescription(false));
		return new ResponseEntity<ErrorBean>(error, HttpStatus.BAD_REQUEST); 
	}
	
}
