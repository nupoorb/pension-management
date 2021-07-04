package com.pensionmanagement.authentication.service;

import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.junit4.SpringRunner;

import com.pensionmanagement.service.JwtUtil;

import io.jsonwebtoken.Jwts;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
public class TestJwtUtil {

	@InjectMocks
	private JwtUtil jwtUtil;
	
	@Test
	public void testGenerateToken() {
		
		UserDetails userDetails = new User("admin", "admin", new ArrayList<>());
		
		assertNotNull(jwtUtil.generateToken(userDetails));
	}
	
	@Test
	public void testValidateTokenTrue() {
		
		UserDetails userDetails = new User("admin", "admin", new ArrayList<>());
		
		String token = jwtUtil.generateToken(userDetails);
		
		assertTrue(jwtUtil.validateToken(token));
	}
	
	@Test
	public void testValidateTokenFalse() {
		
		UserDetails userDetails = new User("admin", "admin", new ArrayList<>());
		
		String token = jwtUtil.generateToken(userDetails);

		assertFalse(jwtUtil.validateToken("wrong" + token) );
	}
	
}
