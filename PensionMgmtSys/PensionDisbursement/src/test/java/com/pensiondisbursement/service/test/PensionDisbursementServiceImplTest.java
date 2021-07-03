package com.pensiondisbursement.service.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
import org.springframework.test.context.ContextConfiguration;

import com.pensionmanagement.pensiondisbursement.clients.PensionerDetailClient;
import com.pensionmanagement.common.exception.PensionerDetailsException;
import com.pensionmanagement.pensiondisbursement.model.PensionerDetail;
import com.pensionmanagement.pensiondisbursement.model.ProcessPensionInput;
import com.pensionmanagement.pensiondisbursement.model.ProcessPensionResponse;
import com.pensionmanagement.pensiondisbursement.service.PensionDisbursementServiceImpl;

@ExtendWith(MockitoExtension.class)
@ContextConfiguration
class PensionDisbursementServiceImplTest {
	@InjectMocks
	private PensionDisbursementServiceImpl pensionDisbursementService;
	@Mock
	private PensionerDetailClient pensionerDetailClient;
	

	@Test
	public void testGetPensionDetail() throws PensionerDetailsException {
		String token="dummyToken";
		Calendar myCalendar = new GregorianCalendar(1998, 02, 03);
		Date dob = myCalendar.getTime();
		PensionerDetail pensionerDetail = new PensionerDetail(123456789012L, "Binisha", dob, "PCASD1234Q",25000.0, 10000, "self", "icici", 12345678, "private");
		Mockito.lenient().when(pensionerDetailClient.getPensionerDetails(token, 123456789012L)).thenReturn(pensionerDetail);
	assertEquals(pensionerDetail,pensionDisbursementService.getPensionDetail(token, 123456789012L));
	}
	

	@Test
	public void testGetPensionDisbursementSuccess() throws PensionerDetailsException {
		String token="dummyToken";
		Calendar myCalendar = new GregorianCalendar(1998, 02, 03);
		Date dob = myCalendar.getTime();
		ProcessPensionResponse processPensionResponse=new ProcessPensionResponse(10);

		PensionerDetail pensionerDetail = new PensionerDetail(123456789012L, "Binisha", dob,"PCASD1234Q",25000.0, 10000, "self", "icici", 12345678, "private");
	ProcessPensionInput ppi = new ProcessPensionInput(123456789012L,29450.0, 550.0);
	Mockito.when(pensionerDetailClient.getPensionerDetails(token, ppi.getAadharNumber())).thenReturn(pensionerDetail);
	assertEquals(processPensionResponse.toString(),pensionDisbursementService.checkBankServiceChargeAndPension(token,ppi).toString());
	}
	

	@Test
	public void testGetPensionDisbursementIncorrect() throws PensionerDetailsException {
		String token="dummyToken";
		Calendar myCalendar = new GregorianCalendar(1998, 12, 8);
		Date dob = myCalendar.getTime();
		ProcessPensionResponse processPensionResponse=new ProcessPensionResponse(21);
		PensionerDetail pensionerDetail = new PensionerDetail(546789641236L, "om", dob, "LWDSW1141", 18000.0, 111.21, "self", "Punjab National Bank", 010120120, "public");

	ProcessPensionInput ppi = new ProcessPensionInput(546789641236L,14511.21, 900.0);
	Mockito.when(pensionerDetailClient.getPensionerDetails(token, ppi.getAadharNumber())).thenReturn(pensionerDetail);
	assertEquals(pensionDisbursementService.checkBankServiceChargeAndPension(token,ppi).toString(),processPensionResponse.toString());
	}
	


	@Test
	public void testGetPensionDisbursementPublicBankSuccess() throws PensionerDetailsException {
		String token="dummyToken";
		Calendar myCalendar = new GregorianCalendar(1998, 9, 26);
		Date dob = myCalendar.getTime();
		ProcessPensionResponse processPensionResponse=new ProcessPensionResponse(10);

		PensionerDetail pensionerDetail = new PensionerDetail(12345789013L, "jane", dob, "PBNBG5678B", 25000.0, 1000.00, "family", "sbi", 13254769, "public");

	ProcessPensionInput ppi = new ProcessPensionInput(123456789013L, 13000.0, 500.0);
	Mockito.when(pensionerDetailClient.getPensionerDetails(token, ppi.getAadharNumber())).thenReturn(pensionerDetail);
	assertEquals(processPensionResponse.toString(),pensionDisbursementService.checkBankServiceChargeAndPension(token,ppi).toString()); 
	}
	

	@Test
	public void testGetPensionDisbursementPrivateBankSuccess() throws PensionerDetailsException {
		String token="dummyToken";
		Calendar myCalendar = new GregorianCalendar(1998, 03, 02);
		Date dob = myCalendar.getTime();
		ProcessPensionResponse processPensionResponse=new ProcessPensionResponse(10);

		PensionerDetail pensionerDetail = new PensionerDetail(123456789012L, "Binisha", dob,"PCASD1234Q",25000.0, 10000, "self", "icici", 12345678, "private");
	ProcessPensionInput ppi = new ProcessPensionInput(123456789012L,29450.0, 550.0);
	Mockito.when(pensionerDetailClient.getPensionerDetails(token, ppi.getAadharNumber())).thenReturn(pensionerDetail);
	assertEquals(processPensionResponse.toString(),pensionDisbursementService.checkBankServiceChargeAndPension(token,ppi).toString());
	}
	

	@Test
	public void testGetPensionDisbursementPublicBankFailure() throws PensionerDetailsException {
		String token="dummyToken";
		Calendar myCalendar = new GregorianCalendar(1995, 7, 10);
		Date dob = myCalendar.getTime();
		ProcessPensionResponse processPensionResponse=new ProcessPensionResponse(21);
		PensionerDetail pensionerDetail = new PensionerDetail(12345789013L, "jane", dob, "PBNBG5678B", 25000.0, 1000.00, "family", "sbi", 13254769, "public");

	ProcessPensionInput ppi = new ProcessPensionInput(12345789013L, 13921.21, 5250.0);
	Mockito.when(pensionerDetailClient.getPensionerDetails(token, ppi.getAadharNumber())).thenReturn(pensionerDetail);
	assertEquals(pensionDisbursementService.checkBankServiceChargeAndPension(token,ppi).toString(),processPensionResponse.toString());
	}
	

	@Test
	public void testGetPensionDisbursementPrivateBankFailure() throws PensionerDetailsException {
		String token="dummyToken";
		Calendar myCalendar = new GregorianCalendar(1995, 7, 10);
		Date dob = myCalendar.getTime();
		ProcessPensionResponse processPensionResponse=new ProcessPensionResponse(21);
		PensionerDetail pensionerDetail = new PensionerDetail(123456789012L, "Binisha", dob,"PCASD1234Q",25000.0, 10000, "self", "icici", 12345678, "private");

	ProcessPensionInput ppi = new ProcessPensionInput(123456789012L, 13921.21, 5250.0);
	Mockito.when(pensionerDetailClient.getPensionerDetails(token, ppi.getAadharNumber())).thenReturn(pensionerDetail);
	assertEquals(pensionDisbursementService.checkBankServiceChargeAndPension(token,ppi).toString(),processPensionResponse.toString());
	}

	
}

