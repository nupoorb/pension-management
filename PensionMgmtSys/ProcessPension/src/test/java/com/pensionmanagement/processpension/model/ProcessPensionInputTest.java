package com.pensionmanagement.processpension.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author Nikitha
 *
 */
@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class ProcessPensionInputTest {

	
	@InjectMocks
	ProcessPensionInput input;
	
	/**
	 * Tests for constructor
	 */
	@Test
	public void testProcessPensionInputLongDoubleDouble() {
		input = new ProcessPensionInput(1765437098L,40000,5000);
		assertNotNull(input);
	}

	@Test
	public void testProcessPensionInput() {
		input = new ProcessPensionInput();
		assertNotNull(input);
	}

	/**
	 * Tests for getters and setters
	 */
	@Test
	public void testGettersAndSetters()
	{
		input = new ProcessPensionInput();
		input.setAadharNumber(1276549873L);
		assertEquals(1276549873L,input.getAadharNumber());	
	}

}





