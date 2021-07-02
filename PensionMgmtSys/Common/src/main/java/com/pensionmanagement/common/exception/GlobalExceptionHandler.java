package com.pensionmanagement.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(UserException.class)
		public ResponseEntity<String> invalidPensionerDetails(UserException ex)
		{
			return new ResponseEntity<>(ex.toString(),HttpStatus.NOT_ACCEPTABLE);
		}
	
	@ExceptionHandler(TokenException.class)
	public ResponseEntity<String> invalidTokenDetails(TokenException ex)
	{
		return new ResponseEntity<>(ex.toString(),HttpStatus.FORBIDDEN);
	}
}
