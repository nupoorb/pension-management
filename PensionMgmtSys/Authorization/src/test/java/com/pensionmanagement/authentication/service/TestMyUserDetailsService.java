package com.pensionmanagement.authentication.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.pensionmanagement.model.UserLoginCredential;
import com.pensionmanagement.repository.UserRepository;
import com.pensionmanagement.service.MyUserDetailsService;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
public class TestMyUserDetailsService {
	
	
	@InjectMocks
	private MyUserDetailsService myUserDetailsService;
	
	@Mock
	private UserRepository userRepo;
	
	@Test
	public void testLoadUserByUsername() {
		
		UserLoginCredential userLoginCredential = new UserLoginCredential("admin" , "admin" ,null);
		
		when(userRepo.findById("admin")).thenReturn(Optional.of(userLoginCredential));
		
		assertEquals(myUserDetailsService.loadUserByUsername("admin").getUsername(), userLoginCredential.getUid() );
	}
}
