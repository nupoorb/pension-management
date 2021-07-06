package com.pensionmanagement.portal.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.pensionmanagement.common.exception.TokenException;
import com.pensionmanagement.common.exception.UserException;
import com.pensionmanagement.common.model.ServiceResponse;
import com.pensionmanagement.portal.model.UserLoginCredential;

@FeignClient(name = "auth")
public interface AuthServiceClient {

	@PostMapping(value = "/login")
	public ResponseEntity<ServiceResponse<UserLoginCredential>> login( UserLoginCredential userlogincredentials) throws UserException;

	@PostMapping("/validate")
	public boolean validateToken(@RequestHeader("Authorization") String token)throws TokenException;

}