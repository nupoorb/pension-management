package com.pensionmanagement.processpension.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class ProcessPensionResponseTest {

	@InjectMocks 
	ProcessPensionResponse response;
	/**
	 * Test for getter and setter
	 */
	@Test
	public void testSetterAndGetter() {
		final Integer code = Integer.valueOf(10);
		response = new ProcessPensionResponse();
		response.setProcessPensionStatusCode(code);
		assertEquals(10,response.getProcessPensionStatusCode());
	}

	/**
	 * Test for contructor
	 */
	@Test
	public void testProcessPensionResponse() {
		response = new ProcessPensionResponse();
		assertNotNull(response);
	}

}
