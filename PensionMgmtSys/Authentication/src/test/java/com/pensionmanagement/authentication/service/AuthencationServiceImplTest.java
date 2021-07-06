package com.pensionmanagement.authentication.service;

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
public class AuthencationServiceImplTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Mock
	private JwtUtil jwtUtil;
	
	@Mock
	private MyUserDetailsService myUserDetailsService;
	
	@InjectMocks
	private AuthenticationService authenticationService = new AuthenticationServiceImpl();
	
	
	private AuthResponse authResponse;
	
	
	@Test
	public void testValidToken() {
		
		when(jwtUtil.validateToken("testToken")).thenReturn(true);
		
		when(jwtUtil.extractUsername("testToken")).thenReturn("admin");
		
		assertEquals(authenticationService.getValidity("bearer testToken").getBody().getUid(), "admin");
		assertEquals(authenticationService.getValidity("bearer testToken").getBody().isValid(), true);

	}
	
	@Test
	public void testInvalidToken() {
		
		when(jwtUtil.validateToken("testToken")).thenReturn(false);
		
		assertEquals(authenticationService.getValidity("testToken").getBody().getUid(), null);
		assertEquals(authenticationService.getValidity("testToken").getBody().isValid(), false);

	}
	
	@Test
	public void testLoginSuccess() throws UserException {
		
		UserLoginCredential userLoginCredential = new UserLoginCredential("admin", "admin", null);
		
		UserDetails userDetails = new User(userLoginCredential.getUid(), userLoginCredential.getPassword(), new ArrayList<>());
		
		when(myUserDetailsService.loadUserByUsername("admin")).thenReturn(userDetails);
		
		UserDetails userDetailsLoaded = myUserDetailsService.loadUserByUsername("admin");
			
		assertEquals( true , authenticationService.login(userLoginCredential).getBody().isSuccess() );
		
	}
	
	@Test
	public void testLoginFailed() throws UserException {
		
		UserLoginCredential userLoginCredential = new UserLoginCredential("admin", "admin", null);
		
		UserDetails userDetails = new User(userLoginCredential.getUid(), "admin1", new ArrayList<>());
		
		when(myUserDetailsService.loadUserByUsername("admin")).thenReturn(userDetails);
		
		UserDetails userDetailsLoaded = myUserDetailsService.loadUserByUsername("admin");
			
		assertThrows( UserException.class , () -> { authenticationService.login(userLoginCredential);} );
	
	}
	
}
