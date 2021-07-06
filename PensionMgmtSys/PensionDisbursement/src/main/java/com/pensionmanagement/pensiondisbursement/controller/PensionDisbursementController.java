package com.pensionmanagement.pensiondisbursement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import com.pensionmanagement.common.exception.PensionerDetailsException;
import com.pensionmanagement.common.exception.TokenException;
import com.pensionmanagement.pensiondisbursement.model.ProcessPensionInput;
import com.pensionmanagement.pensiondisbursement.model.ProcessPensionResponse;
import com.pensionmanagement.pensiondisbursement.service.PensionDisbursementServiceImpl;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class PensionDisbursementController {

	@Autowired
	private PensionDisbursementServiceImpl pensionDisbursementService;
	
	/**
	 * Disburse Pension
	 * @param token
	 * @param processPensionInput
	 * @return
	 * @throws TokenException
	 * @throws PensionerDetailsException
	 */
	@PostMapping("/disbursepension")
	public ProcessPensionResponse getPensionDisbursement(@RequestHeader("Authorization") String token,
			@RequestBody ProcessPensionInput processPensionInput) throws TokenException, PensionerDetailsException
	{
		log.debug("DisbursePension Microservice Called To Evaluate Details ");
		return  pensionDisbursementService.checkBankServiceChargeAndPension(token, processPensionInput);
	}
}
