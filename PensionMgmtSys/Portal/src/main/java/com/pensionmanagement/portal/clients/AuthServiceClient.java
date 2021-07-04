package com.pensionmanagement.portal.clients;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.pensionmanagement.common.exception.TokenException;
import com.pensionmanagement.portal.model.UserLoginCredential;

@FeignClient(name="authorization-app", url = "${auth.valid}")
//@RibbonClient(name="authorization-app")
public interface AuthServiceClient {

	@PostMapping("/login")
	ResponseEntity<UserLoginCredential> authenticateUserAndGetDetails(@RequestBody UserLoginCredential login);

	@PostMapping("/validate")
	public boolean validateToken(@RequestHeader("Authorization") String token)throws TokenException;

}