package com.pensionmanagement.authentication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.pensionmanagement.authentication.exception.UserException;
import com.pensionmanagement.authentication.model.AuthResponse;
import com.pensionmanagement.authentication.model.UserLoginCredential;
import com.pensionmanagement.authentication.service.JwtUtil;
import com.pensionmanagement.authentication.service.MyUserDetailsService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class AuthenticationController {

	@Autowired
	private JwtUtil jwtutil;
	@Autowired
	private MyUserDetailsService custdetailservice;
	
	/**
	 * This method is used to check for validity of user login credentials
	 * 
	 * @param userlogincredentials
	 * @throws UserException
	 * @return ResponseEntity<UserLoginCredential>
	 */
	@PostMapping(value = "/login")
	public ResponseEntity<UserLoginCredential> login(@RequestBody UserLoginCredential userlogincredentials) throws UserException {
		log.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%Start : {}", "login");
		try{
		final UserDetails userdetails = custdetailservice.loadUserByUsername(userlogincredentials.getUid());
		if (userdetails.getPassword().equals(userlogincredentials.getPassword())) {
			log.debug("End : {}", "login");
			return new ResponseEntity<>(new UserLoginCredential(userlogincredentials.getUid(),null,jwtutil.generateToken(userdetails)),HttpStatus.OK ); 
		} else {
			log.debug("Access Denied : {}", "login");
			throw new UserException("Invalid Username/Password");
		}
		}
		catch(Exception e)
		{
			throw new UserException("Invalid Username/Password");
		}
	}
	@GetMapping("/health-check")
	public ResponseEntity<String> healthCheck() {
	return new ResponseEntity<>("Ok", HttpStatus.OK);
	}
	/**
	 * This method is used to check for validity of token
	 * 
	 * @param header
	 * @return ResponseEntity<AuthResponse>
	 */
	@GetMapping(value = "/validate")
	public ResponseEntity<AuthResponse> getValidity(@RequestHeader("Authorization") String header) {
		log.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%Start : {}", "getValidity");
		String token = header.substring(7);
		AuthResponse res = new AuthResponse();
		if (jwtutil.validateToken(token)) {
			res.setUid(jwtutil.extractUsername(token));
			res.setValid(true);
		} else
			{
			res.setValid(false);
			}
		log.debug("End : {}", "getValidity");
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

}
