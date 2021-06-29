package com.pensionmanagement.processpension.clients;


import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import com.pensionmanagement.processpension.exception.PensionerDetailsNotFound;
import com.pensionmanagement.processpension.model.PensionerDetailPojo;

@org.springframework.cloud.openfeign.FeignClient(name="GetPensionerDetails", url="${pension-detail}")
public interface PensionerDetailClient {

	@GetMapping("/pensionerdetailbyaadhaar/{aadharno}")
	public PensionerDetailPojo getDetails(@RequestHeader(name="Authorization")String header,@PathVariable("aadharno") long aadharno) throws PensionerDetailsNotFound ;
}