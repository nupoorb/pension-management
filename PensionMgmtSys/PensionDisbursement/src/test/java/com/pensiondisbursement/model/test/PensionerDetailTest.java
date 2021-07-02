package com.pensiondisbursement.model.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import com.pensionmanagement.pensiondisbursement.model.PensionerDetail;


@ContextConfiguration
@ExtendWith(MockitoExtension.class)
public class PensionerDetailTest {
		
	@InjectMocks
	PensionerDetail pension;
	

	@Test
	public void constructerMenuItemTest()
		{
		PensionerDetail pensiondetailNoArg = new PensionerDetail();
		assertNotNull(pensiondetailNoArg);
		PensionerDetail pensiondetailAllArg = new PensionerDetail(203456716542L, "nikky",null, "CQEPB2341", 69000, 8970,"self", "HDFC", 67645343, "private");
		assertNotNull(pensiondetailAllArg);
		}

	@Test
	public void testgettersetterPensionerDetail() {
		Date date = new Date();
		 
		PensionerDetail  pensiondetail = new PensionerDetail();
		pensiondetail.setAadharNumber(213456716542L);
		pensiondetail.setName("piyush");
		pensiondetail.setDateOfBirth(date);
		pensiondetail.setPan("PCASB6781");
		pensiondetail.setSalaryEarned(98700.10);
		pensiondetail.setAllowances(7890);
		pensiondetail.setPensionType("self");
		pensiondetail.setBankName("HDFC Bank");
		pensiondetail.setAccountNumber(217535211);
		pensiondetail.setBankType("private");
		assertEquals(213456716542L,pensiondetail.getAadharNumber());
		assertEquals("piyush",pensiondetail.getName());
		assertEquals(date,pensiondetail.getDateOfBirth());
		assertEquals("CQEPB6781",pensiondetail.getPan());
		assertEquals(98700.10,pensiondetail.getSalaryEarned());
		assertEquals(7890,pensiondetail.getAllowances());
		assertEquals("self",pensiondetail.getPensionType());
		assertEquals("HDFC Bank",pensiondetail.getBankName());
		assertEquals(217535211,pensiondetail.getAccountNumber());
		assertEquals("private",pensiondetail.getBankType());
		
		
	}
		


}