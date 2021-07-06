//package com.pensionmanagement.pensionerdetail.service;
//
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.boot.test.context.SpringBootTest;
//import com.pensionmanagement.common.exception.NotFoundException;
//import com.pensionmanagement.pensionerdetail.model.PensionerDetail;
//import com.pensionmanagement.pensionerdetail.util.DateUtil;
//import static org.junit.jupiter.api.Assertions.*;
//import java.io.IOException;
//import java.text.ParseException;
//
//@SpringBootTest
//@ExtendWith(MockitoExtension.class)
//public class PensionerDetailServiceImplTest {
//
//		@InjectMocks
//		private PensionerDetailServiceImpl pds;
//
//
//		@Test 
//		public void testNotNullPensionDetailServiceObject() {
//			assertNotNull(pds);
//		}
//		
//		
//		@Test
//		public void testCorrectDetailsReturnedFromServiceWithCorrectAadharNumber()  throws NumberFormatException, IOException, ParseException, NotFoundException {
//
//			PensionerDetail pensionerDetail = new PensionerDetail(123456789012L,"Binisha", DateUtil.parseDate("03-02-1998"), "PCASD1234Q",
//					25000, 10000, "self", "icici", 12345678, "private");
//			assertEquals(pds.getById(123456789012L).toString(), pensionerDetail.toString());
//		}
//		
//		@Test
//		public void testForIncorrectAadharNumber()
//				throws NumberFormatException, IOException, NotFoundException, ParseException {
//			Exception exception = assertThrows(NotFoundException.class, () -> {
//				pds.getById(123878686543L);
//		    });
//		 
//		    String expectedMessage = "The Adhaar Number is Unregistered";
//		    String actualMessage = exception.getMessage();
//		 
//		    assertEquals(actualMessage,expectedMessage);
//			
//		}
//  
//}