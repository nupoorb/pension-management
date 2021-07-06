package com.pensionmanagement.authentication.model;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
public class UserLoginCredentialTest {

	@InjectMocks
	private UserLoginCredential userLoginCredential;
	
	@Test
	public void testUserLoginCreditalAllContructor() {
		
		userLoginCredential = new UserLoginCredential("abc", "def", "ghi");
		
		assertEquals(userLoginCredential.getUid(), "abc");
		assertEquals(userLoginCredential.getPassword(), "def");
		assertEquals(userLoginCredential.getToken(), "ghi");
		
	}
	
	@Test
	public void testUid() {
		
		userLoginCredential.setUid("abc");;
		
		assertEquals(userLoginCredential.getUid(), "abc");
		
		
	}
	
	@Test
	public void testPassword() {
		
		userLoginCredential.setPassword("abc");;
		
		assertEquals(userLoginCredential.getPassword(), "abc");
		
		
	}
	
	@Test
	public void testToken() {
		
		userLoginCredential.setToken("abc");;
		
		assertEquals(userLoginCredential.getToken(), "abc");
		
	}
	
	@Test
	public void testToString() {
		
		userLoginCredential = new UserLoginCredential("abc", "def", "ghi");
		
		String toStringValue = userLoginCredential.toString();
		
		assertTrue(toStringValue.contains(userLoginCredential.getUid()));
		assertTrue(toStringValue.contains(userLoginCredential.getPassword()));
		assertTrue(toStringValue.contains(userLoginCredential.getToken()));
		
	}
	
	
}
