package com.pensionmanagement.portal.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.pensionmanagement.portal.exception.TokenInvalidException;
import com.pensionmanagement.portal.model.UserLoginCredential;

@FeignClient(name = "authorization-service", url = "${auth.valid}")
public interface AuthServiceClient {

	@PostMapping("/login")
	ResponseEntity<UserLoginCredential> authenticateUserAndGetDetails(@RequestBody UserLoginCredential login);

	@PostMapping("/validate")
	public boolean validateToken(@RequestHeader("Authorization") String token)throws TokenInvalidException;

}