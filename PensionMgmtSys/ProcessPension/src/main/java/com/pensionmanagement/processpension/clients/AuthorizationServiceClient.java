package com.pensionmanagement.processpension.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import com.pensionmanagement.processpension.model.AuthResponse;

@FeignClient(name="auth", url = "${auth.valid}")
public interface AuthorizationServiceClient {

	@GetMapping("/validate")
	public ResponseEntity<AuthResponse> validate(@RequestHeader(name = "Authorization") String header);

}
