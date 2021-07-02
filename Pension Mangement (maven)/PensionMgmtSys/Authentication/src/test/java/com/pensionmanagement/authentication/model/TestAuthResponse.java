package com.pensionmanagement.authentication.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
public class TestAuthResponse {

	@InjectMocks
	private AuthResponse authResponse;
	
	@Test
	public void testAuthResponseConstructor()
	{
		authResponse=new AuthResponse("abc", true);
		
		assertEquals(authResponse.getUid(), "abc");
		assertEquals(authResponse.isValid(), true);
		
	}
	
	@Test
	public void testUid()
	{
		String uid = "abc";
				
		authResponse.setUid(uid);
		
		assertEquals(authResponse.getUid(), uid);
	}
	
	@Test
	public void testIsValid()
	{
		
		boolean valid = true;
		
		authResponse.setValid(valid);
		
		assertEquals(authResponse.isValid(), valid);
	}
	
}
