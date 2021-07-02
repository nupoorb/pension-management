package com.pensionmanagement.pensionerdetail.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import com.pensionmanagement.pensionerdetail.clients.AuthorizationServiceClient;
import com.pensionmanagement.common.exception.TokenException;
import com.pensionmanagement.common.exception.NotFoundException;
import com.pensionmanagement.pensionerdetail.model.AuthResponse;
import com.pensionmanagement.pensionerdetail.model.PensionerDetail;
import com.pensionmanagement.pensionerdetail.service.PensionerDetailServiceImpl;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class PensionerDetailControllerTest {
	@Mock
	private AuthorizationServiceClient feignWithAuth;
	
	@Mock
	private PensionerDetailServiceImpl service;
	
	@InjectMocks
	private PensionerDetailController controller;
	
	@Mock
	private AuthResponse response;
	List<PensionerDetail> pensiondetail;
	ResponseEntity<AuthResponse> responseentity;
	
	
	@Test
	public void testGetByIdNotNull() throws NumberFormatException, IOException, ParseException, NotFoundException,TokenException {
		Date date=new Date();
		PensionerDetail pensiondetail= new PensionerDetail(1238786L, "puja",date, "CQEPB2341", 69000, 8970,"self", "HDFC", 67645343, "private");
		Mockito.when(feignWithAuth.validate("token")).thenReturn(responseentity);
		Mockito.when(service.getById(1238786L)).thenReturn((pensiondetail));	
		PensionerDetail response = controller.findById("token",1238786L);
		assertNotNull(response);
	}
	
	
	@Test
	public void testGetByIdPass() throws NumberFormatException, IOException, ParseException, NotFoundException,TokenException {
		Date date=new Date();
		PensionerDetail pensiondetail= new PensionerDetail(1238786L, "puja",date, "CQEPB2341", 69000, 8970,"self", "HDFC", 67645343, "private");
		Mockito.when(feignWithAuth.validate("token")).thenReturn(responseentity);
		Mockito.when(service.getById(1238786L)).thenReturn((pensiondetail));	
		PensionerDetail response = controller.findById("token",1238786L);
		assertEquals(pensiondetail,response);
	}
	

	
	
	
	
	@Test
	public void getByIdNotFoundTest() throws NumberFormatException, IOException, ParseException, NotFoundException, TokenException {
		Mockito.when(feignWithAuth.validate("token")).thenReturn(responseentity);
		Mockito.when(service.getById(1238786L)).thenReturn(null);
		
	Exception exception = assertThrows(NotFoundException.class, () -> {
		controller.findById("token",1238786L);
    });
 
    String expectedMessage = "The Adhaar Number is Unregistered";
    String actualMessage = exception.getMessage();
 
    assertEquals(actualMessage,expectedMessage);
	}
	
	


	}
