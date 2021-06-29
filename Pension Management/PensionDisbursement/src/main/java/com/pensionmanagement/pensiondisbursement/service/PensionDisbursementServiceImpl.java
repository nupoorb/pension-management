package com.pensionmanagement.pensiondisbursement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pensionmanagement.pensiondisbursement.clients.PensionerDetailClient;
import com.pensionmanagement.pensiondisbursement.exception.PensionerDetailsException;
import com.pensionmanagement.pensiondisbursement.model.MyConstants;
import com.pensionmanagement.pensiondisbursement.model.PensionerDetail;
import com.pensionmanagement.pensiondisbursement.model.ProcessPensionInput;
import com.pensionmanagement.pensiondisbursement.model.ProcessPensionResponse;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PensionDisbursementServiceImpl implements PensionDisbursementService {
	

	@Autowired
	PensionerDetailClient pensionDetailsClient;

	@Override
	public ProcessPensionResponse checkBankServiceChargeAndPension(String token, ProcessPensionInput processPensionInput) throws PensionerDetailsException {
		log.debug("checkBankServiceChargeAndPension() method invoked inside DisbursePension Microservice to cross check pension amount and service charge"); 
		PensionerDetail pensionDetail = null;
		
			pensionDetail = getPensionDetail(token, processPensionInput.getAadharNumber());
			
			double pensionAmount;
	
		Double userBankCharge = processPensionInput.getBankCharge();
		if(pensionDetail.getPensionType().equalsIgnoreCase(MyConstants.PENSION_TYPE_SELF)) {
			pensionAmount=  pensionDetail.getSalaryEarned() * MyConstants.SELF_PERCENT +pensionDetail.getAllowances() ;
			
		} 
		else {
			pensionAmount =  pensionDetail.getSalaryEarned() * MyConstants.FAMILY_PERCENT + pensionDetail.getAllowances() ;
		}
		
		 if (processPensionInput.getPensionAmount()  ==pensionAmount - userBankCharge) 
		{
			 log.debug("entered service charge is correct");
			return new ProcessPensionResponse(MyConstants.SUCCESS);// Pension disbursement Success
		}
		
		else { 
			log.debug("entered service charge is wrong");
			return new ProcessPensionResponse(MyConstants.FAILURE); // pension disbursement failure
		}
	}

	@Override
	public PensionerDetail getPensionDetail(String token, long aadharNumber) throws PensionerDetailsException {
		log.debug("Fetching PensionerDetails  from PensionDetail Microservice");
		PensionerDetail pensioner =null;
		try {
			pensioner = pensionDetailsClient.getPensionerDetails(token, aadharNumber);
		}
		catch(Exception e)
		{
		throw new PensionerDetailsException("Not Found pensioner with given aadhar number");
		}
		return pensioner;
	
	}
}