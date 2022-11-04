package com.amit.exception;

public class DatabaseEmptyException extends RuntimeException{

	public DatabaseEmptyException() {}
	
	public DatabaseEmptyException(String message) {
		super(message);
	}
}
