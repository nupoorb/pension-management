package com.pensionmanagement.portal.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;

import com.pensionmanagement.common.exception.PensionerDetailsNotFound;
import com.pensionmanagement.common.exception.TokenException;
import com.pensionmanagement.common.exception.UserException;
import com.pensionmanagement.portal.model.PensionDetail;
import com.pensionmanagement.portal.model.PensionerInput;
import com.pensionmanagement.portal.model.ProcessPensionInput;
import com.pensionmanagement.portal.model.UserLoginCredential;
import com.pensionmanagement.portal.model.UserToken;

public interface PortalService {

	UserLoginCredential getPensionerPage(UserLoginCredential login) throws UserException;

	String getToken(ResponseEntity<UserToken> response);

	String getBankCharge(Model model,String token, long aadhaar, double amount);

	String disburseProcess(ProcessPensionInput processPensionInput, String token,Model model) throws TokenException, PensionerDetailsNotFound;

	String submitPensionInput(PensionerInput pensionerInput, Model model,String token) throws TokenException, PensionerDetailsNotFound;

	List<PensionDetail> viewdetails(String token) throws TokenException;
	public boolean conditionRecalculate();
}
