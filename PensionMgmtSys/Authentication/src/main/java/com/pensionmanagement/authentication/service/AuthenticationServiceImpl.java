package com.pensionmanagement.authentication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.pensionmanagement.authentication.model.AuthResponse;
import com.pensionmanagement.authentication.model.UserLoginCredential;
import com.pensionmanagement.common.exception.UserException;
import com.pensionmanagement.common.handler.ResponseHandler;
import com.pensionmanagement.common.model.ServiceResponse;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AuthenticationServiceImpl implements AuthenticationService{

	
	@Autowired
	private JwtUtil jwtutil;
	@Autowired
	private MyUserDetailsService custdetailservice;
	
	
	/**
	 * Login 
	 * @param userlogincredentials
	 * @return ResponseEntity<ServiceResponse<UserLoginCredential>>
	 * @throws UserException
	 */	
	@Override
	public ResponseEntity<ServiceResponse<UserLoginCredential>> login(UserLoginCredential userlogincredentials)
			throws UserException {
		// TODO Auto-generated method stub
		
		final UserDetails userdetails = custdetailservice.loadUserByUsername(userlogincredentials.getUid());
		
		if (userdetails.getPassword().equals(userlogincredentials.getPassword())) {
			
			log.debug("End : {}", "login");
			
			UserLoginCredential userLoginCredential = new UserLoginCredential(userlogincredentials.getUid(), null,
					jwtutil.generateToken(userdetails));
			
			return new ResponseHandler<UserLoginCredential>().defaultResponse(userLoginCredential);
		} 
		else {
			log.debug("Access Denied : {}", "login");
			throw new UserException("Invalid Username/Password");
		}
		
	}

	/**
	 * Validate username and password 
	 * @param header
	 * @return
	 */
	@Override
	public ResponseEntity<AuthResponse> getValidity(String header) {
		// TODO Auto-generated method stub
		
		String token = header.substring(7);
		AuthResponse res = new AuthResponse();
		if (jwtutil.validateToken(token)) {
			res.setUid(jwtutil.extractUsername(token));
			res.setValid(true);
		} else {
			res.setValid(false);
		}
		log.debug("End : {}", "getValidity");
		return new ResponseEntity<>(res, HttpStatus.OK);
		
	}

}
