//package com.pensionmanagement.processpension.model;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//
//import java.util.Date;
//
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.boot.test.context.SpringBootTest;
//
//@ExtendWith(MockitoExtension.class)
//@SpringBootTest
//class PensionDetailTest {
//
//	/**
//	 * Tests for constructor
//	 */
//	@Test
//	void testPensionDetailLongStringDateStringStringDouble() {
//
//		PensionDetail pensiondetailAllArg = new PensionDetail(203456716542L, "puja",null, "CQEPB2341","self", 67645343);
//		assertNotNull(pensiondetailAllArg);
//	}
//
//	@Test
//	void testPensionDetail() {
//		
//		PensionDetail pensiondetailNoArg = new PensionDetail();
//		assertNotNull(pensiondetailNoArg);
//	}
//
//	/**
//	 * Test for getter and setter
//	 */
//	@Test
//	void testGettersAndSetters() {
//		
//		Date date  = new Date();
//		PensionDetail  pensiondetail = new PensionDetail();
//		pensiondetail.setAadharNumber(203456716542L);
//		pensiondetail.setName("puja");
//		pensiondetail.setDateOfBirth(date);
//		pensiondetail.setPan("CQEPB6781");
//		pensiondetail.setPensionType("self");
//		pensiondetail.setPensionAmount(4000);
//		
//		assertEquals(203456716542L,pensiondetail.getAadharNumber());
//		assertEquals("puja",pensiondetail.getName());
//		assertEquals(date,pensiondetail.getDateOfBirth());
//		assertEquals("CQEPB6781",pensiondetail.getPan());
//		assertEquals("self",pensiondetail.getPensionType());
//		assertEquals(4000,pensiondetail.getPensionAmount());
//		
//		
//	}
//
//}
