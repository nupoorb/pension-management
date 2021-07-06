package com.pensionmanagement.authentication.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;

import com.pensionmanagement.authentication.model.AuthResponse;
import com.pensionmanagement.authentication.model.UserLoginCredential;
import com.pensionmanagement.common.exception.UserException;
import com.pensionmanagement.common.model.ServiceResponse;

public interface AuthenticationService {
	
	public ResponseEntity<ServiceResponse<UserLoginCredential>> login(UserLoginCredential userlogincredentials) throws UserException;
	
	public ResponseEntity<AuthResponse> getValidity(@RequestHeader("Authorization") String header);
}
