//package com.pensionmanagement.pensionerdetail.model;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.boot.test.context.SpringBootTest;
//
//@ExtendWith(MockitoExtension.class)
//@SpringBootTest
//public class AuthResponseTest 
//{
//	AuthResponse authResponse=new AuthResponse();
//	
//	
//	@Test
//	public void testAuthResponseConstructor()
//	{
//		AuthResponse response=new AuthResponse("abc", true);
//		assertEquals(response.getUid(), "abc");
//	}
//	
//	
//	@Test
//	public void testUid()
//	{
//		authResponse.setUid("abc");
//		authResponse.setValid(true);
//		assertEquals(authResponse.getUid(), "abc");
//	}  
//
//	@Test
//	public void testIsValid()
//	{
//		authResponse.setValid(true);
//		assertEquals(authResponse.isValid(), true);
//	}
//	
//	
//	@Test
//	public void testtoString() 
//	{
//        String s = authResponse.toString();
//        assertEquals(authResponse.toString(), s);
//    }
//	
//}
