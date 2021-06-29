package com.pensionmanagement.pensiondisbursement.service;


import com.pensionmanagement.pensiondisbursement.exception.PensionerDetailsException;
import com.pensionmanagement.pensiondisbursement.model.PensionerDetail;
import com.pensionmanagement.pensiondisbursement.model.ProcessPensionInput;
import com.pensionmanagement.pensiondisbursement.model.ProcessPensionResponse;

import org.springframework.stereotype.Service;



@Service
public interface PensionDisbursementService {

	public ProcessPensionResponse checkBankServiceChargeAndPension(String token, ProcessPensionInput processPensionInput) throws PensionerDetailsException;

	public PensionerDetail getPensionDetail(String token, long aadharNumber) throws PensionerDetailsException;

	}
