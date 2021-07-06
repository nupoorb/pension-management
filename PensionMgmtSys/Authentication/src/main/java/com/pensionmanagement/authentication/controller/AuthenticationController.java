package com.pensionmanagement.authentication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.pensionmanagement.common.exception.UserException;
import com.pensionmanagement.common.model.ServiceResponse;
import com.pensionmanagement.authentication.model.AuthResponse;
import com.pensionmanagement.authentication.model.UserLoginCredential;
import com.pensionmanagement.authentication.service.AuthenticationService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class AuthenticationController {

	@Autowired
	public AuthenticationService authenticationService;
	
	/**
	 * Testing
	 * @return
	 */
	@GetMapping("/health-check")
	public ResponseEntity<String> healthCheck() {
		return new ResponseEntity<>("Ok", HttpStatus.OK);
	}
	
	/**
	 * Login 
	 * @param userlogincredentials
	 * @return ResponseEntity<ServiceResponse<UserLoginCredential>>
	 * @throws UserException
	 */
	@PostMapping(value = "/login")
	public ResponseEntity<ServiceResponse<UserLoginCredential>> login(@RequestBody UserLoginCredential userlogincredentials) throws UserException {
		
		log.debug("Start : {}", "login");
			
		return authenticationService.login(userlogincredentials);
			
	}

	/**
	 * Validate username and password 
	 * @param header
	 * @return
	 */
	@GetMapping(value = "/validate")
	public ResponseEntity<AuthResponse> getValidity(@RequestHeader("Authorization") String header) {
		log.debug("Start : {}", "getValidity");
		
		return authenticationService.getValidity(header);
		
	}

}
