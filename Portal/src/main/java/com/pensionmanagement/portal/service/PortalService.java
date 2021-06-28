package com.pensionmanagement.portal.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;

import com.pensionmanagement.portal.exception.TokenInvalidException;
import com.pensionmanagement.portal.model.PensionDetail;
import com.pensionmanagement.portal.model.PensionerInput;
import com.pensionmanagement.portal.model.ProcessPensionInput;
import com.pensionmanagement.portal.model.UserLoginCredential;
import com.pensionmanagement.portal.model.UserToken;

public interface PortalService {
	
	UserLoginCredential getPensionerPage(PensionerInput pensionerInput, UserLoginCredential login);
	
	String getToken(ResponseEntity<UserToken> response);
	
	String getBankCharge(Model model,String token, long aadhaar, double amount);
	
	String disburseProcess(ProcessPensionInput processPensionInput, String token,Model model);
	
	String submitPensionInput(PensionerInput pensionerInput, Model model,String token) throws TokenInvalidException;
	
	List<PensionDetail> viewdetails(String token);
	public boolean conditionRecalculate();
}
