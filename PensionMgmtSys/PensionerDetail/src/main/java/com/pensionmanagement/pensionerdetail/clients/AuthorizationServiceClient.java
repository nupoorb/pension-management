package com.pensionmanagement.pensionerdetail.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import com.pensionmanagement.pensionerdetail.model.AuthResponse;

@org.springframework.cloud.openfeign.FeignClient(name="GetValidation", url="${auth.valid}")
//@FeignClient("auth")
public interface AuthorizationServiceClient {

	@GetMapping("/validate")
	public ResponseEntity<AuthResponse> validate(@RequestHeader(name="Authorization") String header);

}