package com.pensionmanagement.portal.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.pensionmanagement.portal.clients.AuthServiceClient;
import com.pensionmanagement.portal.clients.ProcessPensionClient;
import com.pensionmanagement.common.exception.PensionerDetailsNotFound;
import com.pensionmanagement.common.exception.TokenException;
import com.pensionmanagement.common.exception.UserException;
import com.pensionmanagement.portal.model.MyConstants;
import com.pensionmanagement.portal.model.PensionDetail;
import com.pensionmanagement.portal.model.PensionerInput;
import com.pensionmanagement.portal.model.ProcessPensionInput;
import com.pensionmanagement.portal.model.ProcessPensionResponse;
import com.pensionmanagement.portal.model.UserLoginCredential;
import com.pensionmanagement.portal.model.UserToken;

import feign.FeignException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PortalServiceImpl implements PortalService {
	private int count; //to tract re-calculation  count.
	ProcessPensionResponse response=new ProcessPensionResponse();
	@Autowired
	private AuthServiceClient authServiceClient;
	
	@Autowired
	private ProcessPensionClient processPensionClient;


	@Override
	public UserLoginCredential getPensionerPage(UserLoginCredential login) throws UserException{
		
		log.debug("getPensionerPage() method invoked. Inside Portalservice ");
		ResponseEntity<UserLoginCredential> response = null;
		try{
			response = authServiceClient.login(login);
			if (response.getStatusCode().equals(HttpStatus.OK) && response.getBody() != null) {
				return response.getBody();	
			}
			}
		catch(FeignException e)
		{
			return null;
		}
		
		return null;
	}
	

	@Override
	public String getToken(ResponseEntity<UserToken> response) {
		log.debug("Fetching Token from the returned user object ");
		return response.getBody().getToken();
	}
	

	@Override
	public String submitPensionInput(PensionerInput pensionerInput, Model model,String token) throws TokenException, PensionerDetailsNotFound {
		log.debug("submitPensionInput() method inside PortalService invoked");
		List<PensionDetail> pensionDetails=this.viewdetails(token);
		for(PensionDetail p: pensionDetails) {
			
			if(p.getAadharNumber()==pensionerInput.getAadharNumber()) {
				log.error("Pension disbursed already");
				model.addAttribute("invaliddetails", "Pension disbursed already");
				return "pensionerdetails";
			}
		}			PensionDetail pensionDetail = null;
				pensionDetail = (PensionDetail) processPensionClient.getPensionDetail(pensionerInput,token ).getBody();
				if (pensionDetail == null)
					{
					log.error("PensionerDetails Did not Match");
					model.addAttribute("invaliddetails", "Pensioner Details did not Match.");
					return "pensionerdetails";
					}
				else {
					log.debug("PensionerDetails Matched Successfully");
					model.addAttribute("pensionType", pensionDetail.getPensionType());
					model.addAttribute("aadharno", pensionDetail.getAadharNumber());	
					model.addAttribute("name", pensionDetail.getName());
					model.addAttribute("pan", pensionDetail.getPan());
					//DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
					//String dateobj = pensionDetail.getDateOfBirth();
					model.addAttribute("dob", pensionDetail.getDateOfBirth());
					model.addAttribute("pensionAmount", pensionDetail.getPensionAmount());
					return "verified";
				}
				

	}
	

	@Override
	public String disburseProcess(ProcessPensionInput processPensionInput, String token,Model model) throws TokenException, PensionerDetailsNotFound {
		log.debug("disburseProcess() Method inside Portal Service invoked To Verify Disburse Form");	
		response = processPensionClient.processPension(token, processPensionInput);
				int code = response.getProcessPensionStatusCode();
				if (code == MyConstants.SUCCESS) {
					model.addAttribute("message","Pension Disbursed Successfully!");
					return "message";
				}
				else 
					model.addAttribute("message","Sorry, Disbursion Failed!\nWrong Bank Charge.");
					model.addAttribute("aadharno", processPensionInput.getAadharNumber());
					model.addAttribute("pensionAmount", processPensionInput.getPensionAmount());
					return "failed";
	}

	@Override
	public String getBankCharge(Model model,String token, long aadhaar, double amount) {
		model.addAttribute("aadhaar", aadhaar);
		model.addAttribute("amount", amount);
		model.addAttribute("bankcharge",0);
		return "evaluate";
	
	}


	@Override
	public List<PensionDetail> viewdetails(String token) throws TokenException {
		log.info("Portalseviceimple viewdetails");
		return processPensionClient.viewdetails(token);
		
	}

	@Override
	public boolean conditionRecalculate() {
		this.count++;
		if(count==4) {
			count=0;
			return true;
		}
		return false;
	}

}
