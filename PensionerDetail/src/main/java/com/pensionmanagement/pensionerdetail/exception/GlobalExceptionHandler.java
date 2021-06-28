package com.pensionmanagement.pensionerdetail.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(NotFoundException.class)
	
		public ResponseEntity<String> invalidAdhaarNumber(NotFoundException ex)
		{
			return new ResponseEntity<>(ex.toString(),HttpStatus.NOT_ACCEPTABLE);
		}
	 @ExceptionHandler(InvalidTokenException.class)
		public ResponseEntity<String> invalidPensionerDetails(InvalidTokenException ex)
		{
			return new ResponseEntity<>(ex.toString(),HttpStatus.UNAUTHORIZED);
		}
	}


