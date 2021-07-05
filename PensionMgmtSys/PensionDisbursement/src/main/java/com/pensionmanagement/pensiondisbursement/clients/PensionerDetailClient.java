	package com.pensionmanagement.pensiondisbursement.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import com.pensionmanagement.pensiondisbursement.model.PensionerDetail;

@FeignClient(name = "pensionerdetail")
public interface PensionerDetailClient {


	@GetMapping("/pensionerdetailbyaadhaar/{aadharno}")
	PensionerDetail getPensionerDetails(@RequestHeader("Authorization") String token,
			@PathVariable("aadharno") long aadharno);
	
	
}
