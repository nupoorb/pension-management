package com.cts.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.cts.auth.domain.aggregate.UserCredentials;
import com.cts.auth.domain.aggregate.UserLoginCredential;
import com.cts.auth.exception.UserNameNumericException;
import com.cts.auth.exception.UserNotFoundException;
import com.cts.auth.service.UserDetailsServiceImpl;
import com.cts.auth.util.JwtUtil;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class AuthorizationController {
	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private UserDetailsServiceImpl userDetailsService;
	
	@GetMapping("/health-check")
	public ResponseEntity<String> healthCheck() {
		return new ResponseEntity<String>("Ok", HttpStatus.OK);
	}
	
	@GetMapping("/validate")
	public ResponseEntity<Boolean> validate(@RequestHeader(name = "Authorization") String token1) {
		String token = token1.substring(7);
		try {
			UserDetails user = userDetailsService.loadUserByUsername(jwtUtil.extractUsername(token));
			
			if (jwtUtil.validateToken(token, user)) {
				
				System.out.println("=================Inside Validate==================");
				
				return new ResponseEntity<Boolean>(true, HttpStatus.OK);
			} else {
				
				return new ResponseEntity<Boolean>(false, HttpStatus.FORBIDDEN);
			
			}
		} catch (Exception e) {
			
			return new ResponseEntity<Boolean>(false, HttpStatus.FORBIDDEN);
		}
	}
	
	@PostMapping("/login")
	public ResponseEntity<UserLoginCredential>  login(@RequestBody UserLoginCredential userLoginCredential) {

		if (userLoginCredential.getUid() == null || userLoginCredential.getPassword() == null
				|| userLoginCredential.getUid().trim().isEmpty() || userLoginCredential.getPassword().trim().isEmpty()) {
			log.debug("Login unsuccessful --> User name or password is empty");
			throw new UserNotFoundException("User name or password cannot be Null or Empty");
		}

		else if (jwtUtil.isNumeric(userLoginCredential.getUid())) {
			log.debug("Login unsuccessful --> User name is numeric");
			throw new UserNameNumericException("User name is numeric");
		}

		else {
			try {
				UserDetails user = userDetailsService.loadUserByUsername(userLoginCredential.getUid());
				if (user.getPassword().equals(userLoginCredential.getPassword())) {
					
					String token = jwtUtil.generateToken(user.getUsername());
					
					userLoginCredential.setToken(token);
					
					log.debug("Login successful");
					return new ResponseEntity<UserLoginCredential>(userLoginCredential,HttpStatus.OK);
					//return token;
				} else {
					log.debug("Login unsuccessful --> Invalid password");
					throw new UserNotFoundException("Password is wrong");
				}
			} catch (Exception e) {
				log.debug("Login unsuccessful --> Invalid Credential");
				throw new UserNotFoundException("Invalid Credential");
			}
		}
	}

}