package com.cognizant.service;

import org.springframework.stereotype.Service;
import com.cognizant.model.ProcessPensionInput;
import com.cognizant.model.ProcessPensionResponse;

@Service
public interface PensionDisbursementService {

	public ProcessPensionResponse checkBankServiceChargeAndPension(String token,
			ProcessPensionInput processPensionInput);
}
