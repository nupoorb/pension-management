package com.pensionmanagement.processpension.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

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

import com.pensionmanagement.processpension.clients.PensionDisbursementClient;
import com.pensionmanagement.processpension.clients.PensionerDetailClient;
import com.pensionmanagement.common.exception.PensionerDetailsNotFound;
import com.pensionmanagement.common.exception.TokenException;
import com.pensionmanagement.processpension.model.PensionDetail;
import com.pensionmanagement.processpension.model.PensionerDetailPojo;
import com.pensionmanagement.processpension.model.PensionerInput;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class ProcessPensionServiceImplTest {
	
	@InjectMocks
	private ProcessPensionServiceImpl pensionDetailService;
	@Mock
	private PensionerDetailClient pensionerDetailClient;
	@Mock
	private PensionDisbursementClient pensionDisbursementClient;
	

	
	@Test
	public void testCalculatePensionAmountIsSelfPension() throws PensionerDetailsNotFound {
		Calendar myCalendar = new GregorianCalendar(1998, 12, 8);
		Date dob = myCalendar.getTime();
		PensionerInput pensionerInput = new PensionerInput("om", dob, "LWDSW1141", 546789641236L,"self");
		PensionerDetailPojo pensionerDetail = new PensionerDetailPojo(546789641236L, "om", dob, "LWDSW1141",18000.0, 1200.0, "self", "Punjab National Bank", 010120120, "public");
		PensionDetail pensionDetail = new PensionDetail(546789641236L,"om", dob, "LWDSW1141", "self",15600.0);
		assertEquals(pensionDetailService.checkAndCalculate(pensionerInput,pensionerDetail).getAadharNumber(), pensionDetail.getAadharNumber());
	}

	
	@Test
	public void testCalculatePensionAmountIsFamilyPension() throws PensionerDetailsNotFound {
		Calendar myCalendar = new GregorianCalendar(1998, 12, 8);
		Date dob = myCalendar.getTime();
		PensionerInput pensionerInput = new PensionerInput("om", dob, "LWDSW1141", 546789641236L,"family");
		PensionerDetailPojo pensionerDetail = new PensionerDetailPojo(546789641236L, "om", dob, "LWDSW1141",18000.0, 1200.0, "family", "Punjab National Bank", 010120120, "public");
		PensionDetail pensionDetail = new PensionDetail(546789641236L,"om", dob, "LWDSW1141", "family",15600.0);
		assertEquals(pensionDetailService.checkAndCalculate(pensionerInput,pensionerDetail).getAadharNumber(), pensionDetail.getAadharNumber());
	}

	
	@Test
	public void testGetPensionDetail() throws PensionerDetailsNotFound, TokenException {
		String token = "dummyToken";
		Calendar myCalendar = new GregorianCalendar(1998, 12, 8);
		Date dob = myCalendar.getTime();
		PensionerDetailPojo pensionerDetail = new PensionerDetailPojo(546789641236L, "om", dob, "LWDSW1141",18000.0, 1200.0, "family", "Punjab National Bank", 010120120, "public");
		PensionerInput pensionerInput = new PensionerInput("om", dob, "LWDSW1141", 546789641236L,"family");
		Mockito.when(pensionerDetailClient.getDetails(token, pensionerInput.getAadharNumber()))
				.thenReturn(pensionerDetail);
		assertEquals(pensionDetailService.getPensionDetail(token, pensionerInput).getAadharNumber(), pensionerDetail.getAadharNumber());
	}
	
	
	@Test
	public void testGetPensionDetailValidInput() throws PensionerDetailsNotFound {
		Calendar myCalendar = new GregorianCalendar(1998, 12, 8);
		Date dob = myCalendar.getTime();
		PensionerDetailPojo pensionerDetail = new PensionerDetailPojo(546789641236L, "om", dob, "LWDSW1141",18000.0, 1200.0, "family", "Punjab National Bank", 010120120, "public");
		PensionerInput pensionerInput = new PensionerInput("om", dob, "LWDSW1141", 546789641236L,"family");
		assertEquals(pensionerInput.getName(), pensionerDetail.getName());
		assertEquals(pensionerInput.getDateOfBirth(), pensionerDetail.getDateOfBirth());
		assertEquals(pensionerInput.getPan(), pensionerDetail.getPan());
		assertEquals(pensionerInput.getPensionType(), pensionerDetail.getPensionType());
	}
	
	
	@Test
	public void testGetPensionDetailInValidInput() throws PensionerDetailsNotFound, TokenException {
		Calendar myCalendar1 = new GregorianCalendar(1988, 12, 8);
		Date dob1 = myCalendar1.getTime();
		Calendar myCalendar = new GregorianCalendar(1998, 12, 8);
		Date dob = myCalendar.getTime();
		PensionerDetailPojo pensionerDetail = new PensionerDetailPojo(546789641236L, "om", dob, "LWDSW1141",18000.0, 1200.0, "family", "Punjab National Bank", 010120120, "public");

		PensionerInput pensionerInput = new PensionerInput("soni", dob1, "LWDSW18441", 956789641236L,"self");
		assertNotEquals(pensionerInput.getName(), pensionerDetail.getName());
		assertNotEquals(pensionerInput.getDateOfBirth(), pensionerDetail.getDateOfBirth());
		assertNotEquals(pensionerInput.getPan(), pensionerDetail.getPan());
		assertNotEquals(pensionerInput.getPensionType(), pensionerDetail.getPensionType());
	}
	
		
		@Test
		public void testGetPensionDetailInValidInputName() throws PensionerDetailsNotFound, TokenException {
			Calendar myCalendar = new GregorianCalendar(1998, 12, 8);
			Date dob = myCalendar.getTime();
			PensionerDetailPojo pensionerDetail = new PensionerDetailPojo(546789641236L, "om", dob, "LWDSW1141",18000.0, 1200.0, "family", "Punjab National Bank", 010120120, "public");
			Calendar myCalendar1 = new GregorianCalendar(1978, 12, 8);
			Date dob1 = myCalendar1.getTime();
			PensionerInput input = new PensionerInput("Sanjay Guleria", dob1, "AAA12569CC", 546789641236L,"family");
			assertNotEquals(pensionerDetail.getName(), input.getName());
			
		}
		/**
		 * Test for valid name.
		 * @throws InvalidPensionerDetails
		 */
		@Test
		public void testGetPensionDetailValidInputName() throws PensionerDetailsNotFound {
			Calendar myCalendar = new GregorianCalendar(1998, 12, 8);
			Date dob = myCalendar.getTime();
			PensionerDetailPojo pensionerDetail = new PensionerDetailPojo(546789641236L, "om", dob, "LWDSW1141",18000.0, 1200.0, "family", "Punjab National Bank", 010120120, "public");
			Calendar myCalendar1 = new GregorianCalendar(1998, 12, 8);
			Date dob1 = myCalendar1.getTime();
			PensionerInput input = new PensionerInput("om", dob1, "LWDSW1141", 546789641236L,"family");
			assertEquals(pensionerDetail.getName(), input.getName());
			assertEquals(pensionerDetail.getPensionType(), input.getPensionType());
		}
	
		@Test
		public void testGetPensionDetailInValidInputDob() throws PensionerDetailsNotFound, TokenException {
			Calendar myCalendar = new GregorianCalendar(1998, 12, 8);
			Date dob = myCalendar.getTime();
			PensionerDetailPojo pensionerDetail = new PensionerDetailPojo(546789641236L, "om", dob, "LWDSW1141",18000.0, 1200.0, "family", "Punjab National Bank", 010120120, "public");
			Calendar myCalendar1 = new GregorianCalendar(1978, 12, 8);
			Date dob1 = myCalendar1.getTime();
			PensionerInput input = new PensionerInput("om", dob1, "LWDSW1141", 546789641236L,"family");
			assertNotEquals(pensionerDetail.getDateOfBirth(), input.getDateOfBirth());
		}
		
		@Test
		public void testGetPensionDetailValidInputDob() throws PensionerDetailsNotFound {
			Calendar myCalendar = new GregorianCalendar(1998, 12, 8);
			Date dob = myCalendar.getTime();
			PensionerDetailPojo pensionerDetail = new PensionerDetailPojo(546789641236L, "om", dob, "LWDSW1141",18000.0, 1200.0, "family", "Punjab National Bank", 010120120, "public");
			Calendar myCalendar1 = new GregorianCalendar(1998, 12, 8);
			Date dob1 = myCalendar1.getTime();
			PensionerInput input = new PensionerInput("om", dob1, "LWDSW1141", 546789641236L,"family");
			assertEquals(pensionerDetail.getDateOfBirth(), input.getDateOfBirth());
			assertEquals(pensionerDetail.getPensionType(), input.getPensionType());
		}
		
		@Test
		public void testGetPensionDetailInValidInputPan() throws PensionerDetailsNotFound, TokenException {
			Calendar myCalendar = new GregorianCalendar(1998, 12, 8);
			Date dob = myCalendar.getTime();
			PensionerDetailPojo pensionerDetail = new PensionerDetailPojo(546789641236L, "om", dob, "LWDSW1141",18000.0, 1200.0, "family", "Punjab National Bank", 010120120, "public");
			Calendar myCalendar1 = new GregorianCalendar(1998, 12, 8);
			Date dob1 = myCalendar1.getTime();
			PensionerInput input = new PensionerInput("om", dob1, "MKWDSW1141", 546789641236L,"family");
			assertNotEquals(input.getPan(), pensionerDetail.getPan());
		
		}
		
		@Test
		public void testGetPensionDetailValidInputPan() throws PensionerDetailsNotFound {
			Calendar myCalendar = new GregorianCalendar(1998, 12, 8);
			Date dob = myCalendar.getTime();
			PensionerDetailPojo pensionerDetail = new PensionerDetailPojo(546789641236L, "om", dob, "LWDSW1141",18000.0, 1200.0, "family", "Punjab National Bank", 010120120, "public");
			Calendar myCalendar1 = new GregorianCalendar(1998, 12, 8);
			Date dob1 = myCalendar1.getTime();
			PensionerInput input = new PensionerInput("om", dob1, "LWDSW1141", 546789641236L,"family");
			assertEquals(input.getPan(), pensionerDetail.getPan());
		}
		
		@Test
		public void testGetPensionDetailInValidInputisSelf() throws PensionerDetailsNotFound, TokenException {
			Calendar myCalendar = new GregorianCalendar(1998, 12, 8);
			Date dob = myCalendar.getTime();
			PensionerDetailPojo pensionerDetail = new PensionerDetailPojo(546789641236L, "om", dob, "LWDSW1141",18000.0, 1200.0, "self", "Punjab National Bank", 010120120, "public");
			Calendar myCalendar1 = new GregorianCalendar(1998, 12, 8);
			Date dob1 = myCalendar1.getTime();
			PensionerInput input = new PensionerInput("om", dob1, "LWDSW1141", 546789641236L,"family");
			assertNotEquals(input.getPensionType(), pensionerDetail.getPensionType());
		
		}
		
		@Test
		public void testGetPensionDetailValidInputSelf() throws PensionerDetailsNotFound {
			Calendar myCalendar = new GregorianCalendar(1998, 12, 8);
			Date dob = myCalendar.getTime();
			PensionerDetailPojo pensionerDetail = new PensionerDetailPojo(546789641236L, "om", dob, "LWDSW1141",18000.0, 1200.0, "family", "Punjab National Bank", 010120120, "public");
			Calendar myCalendar1 = new GregorianCalendar(1998, 12, 8);
			Date dob1 = myCalendar1.getTime();
			PensionerInput input = new PensionerInput("om", dob1, "LWDSW1141", 546789641236L,"family");
			assertEquals(input.getPensionType(), pensionerDetail.getPensionType());
		}

}