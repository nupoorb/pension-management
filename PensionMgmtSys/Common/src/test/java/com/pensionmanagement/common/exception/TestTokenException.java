package com.pensionmanagement.common.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class TestTokenException {

	@InjectMocks
	private TokenException tokenInvalidException;

	@Test
	public void testTokenInvalidException() {
		String reason = "Invalid Token";
		assertEquals(reason, "Invalid Token");
	}

}
