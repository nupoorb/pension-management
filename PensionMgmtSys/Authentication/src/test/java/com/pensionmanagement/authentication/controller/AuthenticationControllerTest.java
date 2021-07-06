package com.pensionmanagement.authentication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.pensionmanagement.common.exception.UserException;
import com.pensionmanagement.common.handler.ResponseHandler;
import com.pensionmanagement.common.model.ServiceResponse;
import com.pensionmanagement.authentication.model.AuthResponse;
import com.pensionmanagement.authentication.model.UserLoginCredential;
import com.pensionmanagement.authentication.service.AuthenticationService;
import com.pensionmanagement.authentication.service.JwtUtil;
import com.pensionmanagement.authentication.service.MyUserDetailsService;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;

import org.junit.Test;
//import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

//@SpringBootTest("AuthenticationController.class")


@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
public class AuthenticationControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@InjectMocks
	private AuthenticationController authenticationController;
	
	@Mock
	private JwtUtil jwtUtil;
	
	@Mock
	private MyUserDetailsService myUserDetailsService;
	
	@Mock
	private AuthenticationService authenticationService;
	
	
	private AuthResponse authResponse;
	
	@Test
	public void testHealthCheck() throws Exception {
			mockMvc.perform(MockMvcRequestBuilders
					.get("/health-check")
					.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().string(equalTo("Ok")));;
	}
	
	@Test
	public void testValidToken() {
		
		authResponse = new AuthResponse();
		authResponse.setUid("admin");
		authResponse.setValid(true);
		
		
		ResponseEntity<AuthResponse> authResponseEntity = new ResponseEntity<AuthResponse>(authResponse, HttpStatus.OK);
		
		when(authenticationService.getValidity("testToken")).thenReturn(authResponseEntity);
		
//		when(jwtUtil.validateToken("testToken")).thenReturn(true);
//		
//		when(jwtUtil.extractUsername("testToken")).thenReturn("admin");
		
		assertEquals(authenticationController.getValidity("testToken").getBody().getUid(), "admin");
		assertEquals(authenticationController.getValidity("testToken").getBody().isValid(), true);
//		
//		System.out.println(authenticationController.getValidity("testToken"));
	}
	
	@Test
	public void testInvalidToken() {
//		
//		when(jwtUtil.validateToken("testToken")).thenReturn(false);
//		
//		

		authResponse = new AuthResponse();
		authResponse.setValid(false);
		
		
		ResponseEntity<AuthResponse> authResponseEntity = new ResponseEntity<AuthResponse>(authResponse, HttpStatus.OK);
		
		when(authenticationService.getValidity("testToken")).thenReturn(authResponseEntity);
		
		assertEquals(authenticationController.getValidity("testToken").getBody().getUid(), null);
		assertEquals(authenticationController.getValidity("testToken").getBody().isValid(), false);

	}
//	
	@Test
	public void testLoginSuccess() throws UserException {
//		
//		UserLoginCredential userLoginCredential = new UserLoginCredential("admin", "admin", null);
//		
//		UserDetails userDetails = new User(userLoginCredential.getUid(), userLoginCredential.getPassword(), new ArrayList<>());
//		
//		when(myUserDetailsService.loadUserByUsername("admin")).thenReturn(userDetails);
//		
//		UserDetails userDetailsLoaded = myUserDetailsService.loadUserByUsername("admin");
//			
//		assertEquals( true , authenticationController.login(userLoginCredential).getBody().isSuccess() );
//		
		UserLoginCredential userLoginCredential = new UserLoginCredential("admin", "admin", null);
		
		when(authenticationService.login(userLoginCredential)).thenReturn(new ResponseHandler<UserLoginCredential>().defaultResponse(userLoginCredential));
		
		assertEquals( true , authenticationController.login(userLoginCredential).getBody().isSuccess() );
	}
//	
	@Test
	public void testLoginFailed() throws UserException {
//		
//		UserLoginCredential userLoginCredential = new UserLoginCredential("admin", "admin", null);
//		
//		UserDetails userDetails = new User(userLoginCredential.getUid(), "admin1", new ArrayList<>());
//		
//		when(myUserDetailsService.loadUserByUsername("admin")).thenReturn(userDetails);
//		
//		UserDetails userDetailsLoaded = myUserDetailsService.loadUserByUsername("admin");
//			
//		assertThrows( UserException.class , () -> { authenticationController.login(userLoginCredential);} );
	
		UserLoginCredential userLoginCredential = new UserLoginCredential("admin", "admin1", null);
		
		when(authenticationService.login(userLoginCredential)).thenThrow(UserException.class);
		
		assertThrows( UserException.class , () -> { authenticationController.login(userLoginCredential);} );
	
	}
	
}
