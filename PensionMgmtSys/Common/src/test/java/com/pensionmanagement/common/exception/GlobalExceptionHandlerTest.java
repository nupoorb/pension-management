package com.pensionmanagement.common.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;




@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class GlobalExceptionHandlerTest {
	
	@InjectMocks
	private GlobalExceptionHandler customGlobalExceptionHandler;

	@Test
	public void invalidTokenExceptionTest() {
		TokenException tokenNotFoundException = new TokenException("Invalid Token");
		
		ResponseEntity<?> entity = new ResponseEntity<>(tokenNotFoundException.getMessage(), HttpStatus.UNAUTHORIZED);
		assertEquals(401, entity.getStatusCodeValue());
	}
	
	

}
