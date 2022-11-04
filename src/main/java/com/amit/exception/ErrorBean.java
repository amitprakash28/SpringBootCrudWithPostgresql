package com.amit.exception;

import java.time.LocalDateTime;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class ErrorBean {

	private String message;
	private LocalDateTime localDateTime;
	private String details;
	
	
}
