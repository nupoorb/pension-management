package com.pensiondisbursement.model.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import com.pensionmanagement.pensiondisbursement.model.ProcessPensionInput;
@ExtendWith(MockitoExtension.class)
@ContextConfiguration
public class ProcessPensionInputTest {

	
	@Mock
	ProcessPensionInput input;

	@Test
	public void ProcessPensionInputLongDoubleDoubletest() {
		input = new ProcessPensionInput(1765437098L,40000,5000);
		assertNotNull(input);
	}

	@Test
	public void shouldProcessPensionInput() {
		input = new ProcessPensionInput();
		assertNotNull(input);
	}


	@Test
	public void GettersAndSetterstest()
	{
		input = new ProcessPensionInput();
		input.setAadharNumber(1276549873L);
		assertEquals(1276549873L,input.getAadharNumber());	
	}

}

