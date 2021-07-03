package com.pensionmanagement.processpension.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class PensionerInputTest {

	@InjectMocks
	PensionerInput input;
	
	
	/**
	 * Tests for constructor
	 */
	@Test
	public void testPensionerInputStringDateStringLongString() {
		Date date = new Date();
		input = new PensionerInput("James",date,"FHGDB123KG",867589764897L,"family");
		assertNotNull(input);
	}

	@Test
	public void testPensionerInput() {
		input = new PensionerInput();
		assertNotNull(input);
	}

	/**
	 * Test for getter and setter
	 */
	@Test
	public void testGettersAndSetters()
	{
		PensionerInput input = new PensionerInput();
		Date date = new Date();
		input.setName("Ronik");
		input.setAadharNumber(1246787534L);
		input.setDateOfBirth(date);
		input.setPan("FHGDB123KG");
		input.setPensionType("self");
		
		assertEquals("Ronik",input.getName());
		assertEquals(1246787534L,input.getAadharNumber());
		assertEquals("FHGDB123KG",input.getPan());
		assertEquals("self",input.getPensionType());	
	}
	
}
