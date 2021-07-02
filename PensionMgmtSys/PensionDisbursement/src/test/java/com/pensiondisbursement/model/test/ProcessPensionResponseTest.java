package com.pensiondisbursement.model.test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import com.pensionmanagement.pensiondisbursement.model.ProcessPensionResponse;
@ExtendWith(MockitoExtension.class)
@ContextConfiguration
public class ProcessPensionResponseTest {

	@Mock 
	ProcessPensionResponse response;

	@Test
	public void SetterAndGettertest() {
		final Integer code = Integer.valueOf(10);
		response = new ProcessPensionResponse();
		response.setProcessPensionStatusCode(code);
		assertEquals(10,response.getProcessPensionStatusCode());
	}


	@Test
	public void ProcessPensionResponsetest() {
		response = new ProcessPensionResponse();
		assertNotNull(response);
	}

}

