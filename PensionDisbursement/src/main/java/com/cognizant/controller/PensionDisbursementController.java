package com.cognizant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.model.ProcessPensionInput;
import com.cognizant.model.ProcessPensionResponse;
import com.cognizant.service.PensionDisbursementServiceImpl;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class PensionDisbursementController {
	@Autowired
	private PensionDisbursementServiceImpl pensionDisbursementService;
	@PostMapping("/disbursepension")
	public ProcessPensionResponse getPensionDisbursement(@RequestHeader("Authorization") String token,
			@RequestBody ProcessPensionInput processPensionInput)
	{
		log.debug("DisbursePension Microservice Called To Evaluate Details ");
		return  pensionDisbursementService.checkBankServiceChargeAndPension(token, processPensionInput);
		
	}


}
