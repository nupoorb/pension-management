package com.pensionmanagement.processpension.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(PensionerDetailsNotFound.class)
		public ResponseEntity<String> invalidPensionerDetails(PensionerDetailsNotFound ex)
		{
			return new ResponseEntity<>(ex.toString(),HttpStatus.NOT_ACCEPTABLE);
		}
	
	@ExceptionHandler(TokenException.class)
	public ResponseEntity<String> invalidToken(TokenException ex)
	{
		return new ResponseEntity<>(ex.toString(),HttpStatus.NOT_ACCEPTABLE);
	}
	
	
}
