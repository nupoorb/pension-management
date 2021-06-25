package com.cognizant.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(InvalidPensionerDetails.class)
	
		public ResponseEntity<String> invalidAdhaarNumber(InvalidPensionerDetails ex)
		{
			return new ResponseEntity<>(ex.toString(),HttpStatus.NOT_ACCEPTABLE);
		}
	 @ExceptionHandler(TokenInvalidException.class)
		public ResponseEntity<String> invalidPensionerDetails(TokenInvalidException ex)
		{
			return new ResponseEntity<>(ex.toString(),HttpStatus.UNAUTHORIZED);
		}
	}


