package com.pensionmanagement.processpension.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.pensionmanagement.processpension.clients.AuthorizationServiceClient;
import com.pensionmanagement.common.exception.PensionerDetailsNotFound;
import com.pensionmanagement.common.exception.TokenException;
import com.pensionmanagement.processpension.model.AuthResponse;
import com.pensionmanagement.processpension.model.PensionDetail;
import com.pensionmanagement.processpension.model.PensionerInput;
import com.pensionmanagement.processpension.model.ProcessPensionInput;
import com.pensionmanagement.processpension.model.ProcessPensionResponse;
import com.pensionmanagement.processpension.service.ProcessPensionServiceImpl;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class ProcessPensionControllerTest {

	@InjectMocks
	ProcessPensionController processPensionController;
	@Mock
	private ProcessPensionServiceImpl pensionDetailService;
	
	@Mock
	private AuthorizationServiceClient authClient;
	
	@Test
	public void testGetPensionDetail() throws PensionerDetailsNotFound, TokenException {
		String token = "dummyToken";
		Calendar myCalendar = new GregorianCalendar(1998, 12, 8);
		Date dob = myCalendar.getTime();
		AuthResponse authResponse =new AuthResponse("dummyuser",true);
		ResponseEntity<AuthResponse> auth=new ResponseEntity<AuthResponse>(authResponse,HttpStatus.OK);
		PensionerInput input = new PensionerInput("Sanjay Guleria", dob, "AAA12569CC", 546789641236L,"self");
		PensionDetail pensionDetail = new PensionDetail(546789641236L,"Sanjay Guleria", dob, "AAA12569CC", "self",15600.0);
	 
		 Mockito.lenient().when(authClient.validate(token)).thenReturn(auth);
		Mockito.lenient().when(pensionDetailService.getPensionDetail(token, input)).thenReturn(pensionDetail);
		
		
	assertNotNull(processPensionController.getPensionDetail(input,token));
	

	}

	@Test
	public void testGetDisbursementCodeSuccess() throws PensionerDetailsNotFound, TokenException {
		String token = "dummyToken";
		ProcessPensionInput ppi = new ProcessPensionInput(546789641236L, 15600.0, 550.0);
		ProcessPensionResponse processPensionResponse = new ProcessPensionResponse(10);
		Mockito.lenient().when(pensionDetailService.processPensionInput(token, ppi)).thenReturn(processPensionResponse);
		assertEquals(processPensionController.processPension(token, ppi), processPensionResponse);
	}
	
	@Test
	public void testGetDisbursementCodeServiceIncorrect() throws PensionerDetailsNotFound, TokenException {
		String token = "dummyToken";
		ProcessPensionInput ppi2 = new ProcessPensionInput(546789641236L, 15600.0, 7);
		ProcessPensionResponse processPensionResponse = new ProcessPensionResponse(21);

		Mockito.when(pensionDetailService.processPensionInput(token, ppi2)).thenReturn(processPensionResponse);
		assertEquals(processPensionController.processPension(token, ppi2), processPensionResponse);
	}
	
	@Test
	public void testGetDisbursementDifferentBankCharge() throws PensionerDetailsNotFound, TokenException {
		String token = "dummyToken";
		ProcessPensionInput ppi3 = new ProcessPensionInput(546789641236L, 15600.0, 500.0);
		ProcessPensionResponse processPensionResponse = new ProcessPensionResponse(21);

		Mockito.when(pensionDetailService.processPensionInput(token, ppi3)).thenReturn(processPensionResponse);
		assertEquals(processPensionController.processPension(token, ppi3), processPensionResponse);
	}


	

}
