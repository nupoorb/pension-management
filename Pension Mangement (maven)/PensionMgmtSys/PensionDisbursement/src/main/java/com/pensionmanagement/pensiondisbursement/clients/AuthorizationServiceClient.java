package com.pensionmanagement.pensiondisbursement.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import com.pensionmanagement.pensiondisbursement.exception.TokenException;

@FeignClient(name = "authorization-service", url = "${auth-valid}")
public interface AuthorizationServiceClient {

	@PostMapping("/validate")
	public boolean validateAndReturnUser(@RequestHeader("Authorization") String token) throws TokenException;

}