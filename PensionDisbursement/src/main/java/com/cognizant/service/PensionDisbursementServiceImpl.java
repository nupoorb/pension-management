package com.pensionmanagement.pensiondisbursement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pensionmanagement.pensiondisbursement.clients.PensionerDetailClient;
import com.pensionmanagement.pensiondisbursement.exception.InvalidPensionerDetails;
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
	/**
	 * This method is used to check whether user entered bank service charge is
	 * right or not accordingly sends the processpension response code.
	 * 
	 * @param token, processPensionInput
	 * @throws PensionerDetailException
	 * @return ProcessPensionResponse
	 */
	@Override
	public ProcessPensionResponse checkBankServiceChargeAndPension(String token, ProcessPensionInput processPensionInput) throws InvalidPensionerDetails {
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
	/**
	 * This method is used to fetch pensionerDetails from PensionDetail
	 * microservice.
	 * 
	 * @param token, aadharNumber
	 * @throws PensionerDetailException
	 * @return PensionerDetail
	 */
	@Override
	public PensionerDetail getPensionDetail(String token, long aadharNumber) throws InvalidPensionerDetails {
		log.debug("Fetching PensionerDetails  from PensionDetail Microservice");
		PensionerDetail pensioner =null;
		try {
			pensioner = pensionDetailsClient.getPensionerDetails(token, aadharNumber);
		}
		catch(Exception e)
		{
		throw new InvalidPensionerDetails("Not Found pensioner with given aadhar number");
		}
		return pensioner;
	
	}
}