//package com.pensionmanagement.pensionerdetail.model;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//
//import java.util.Date;
//
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.boot.test.context.SpringBootTest;
//
//
//@SpringBootTest
//@ExtendWith(MockitoExtension.class)
//public class PensionerDetailTest {
//		
//	@InjectMocks
//	PensionerDetail pension;
//	
//	@Test
//	public void constructerMenuItemTest()
//		{
//		PensionerDetail pensiondetailNoArg = new PensionerDetail();
//		assertNotNull(pensiondetailNoArg);
//		PensionerDetail pensiondetailAllArg = new PensionerDetail(203456716542L, "nikky",null, "CQEPB2341", 69000, 8970,"self", "HDFC", 67645343, "private");
//		assertNotNull(pensiondetailAllArg);
//		}
//		
//		
//	
//	@Test
//	public void gettersetterPensionerDetailTest() {
//		Date date = new Date();
//		 
//		PensionerDetail  pensiondetail = new PensionerDetail();
//		pensiondetail.setAadharNumber(203456716542L);
//		pensiondetail.setName("nikky");
//		pensiondetail.setDateOfBirth(date);
//		pensiondetail.setPan("CQEPB6781");
//		pensiondetail.setSalaryEarned(78900.10);
//		pensiondetail.setAllowances(9870);
//		pensiondetail.setPensionType("self");
//		pensiondetail.setBankName("HDFC Bank");
//		pensiondetail.setAccountNumber(206535211);
//		pensiondetail.setBankType("private");
//		assertEquals(203456716542L,pensiondetail.getAadharNumber());
//		assertEquals("nikky",pensiondetail.getName());
//		assertEquals(date,pensiondetail.getDateOfBirth());
//		assertEquals("CQEPB6781",pensiondetail.getPan());
//		assertEquals(78900.10,pensiondetail.getSalaryEarned());
//		assertEquals(9870,pensiondetail.getAllowances());
//		assertEquals("self",pensiondetail.getPensionType());
//		assertEquals("HDFC Bank",pensiondetail.getBankName());
//		assertEquals(206535211,pensiondetail.getAccountNumber());
//		assertEquals("private",pensiondetail.getBankType());
//		
//		
//	}
//		
//
//
//}