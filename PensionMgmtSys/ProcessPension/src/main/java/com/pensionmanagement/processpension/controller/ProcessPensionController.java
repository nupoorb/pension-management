package com.pensionmanagement.processpension.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.pensionmanagement.processpension.clients.AuthorizationServiceClient;
import com.pensionmanagement.common.exception.PensionerDetailsNotFound;
import com.pensionmanagement.common.exception.TokenException;
import com.pensionmanagement.processpension.model.PensionDetail;
import com.pensionmanagement.processpension.model.PensionerInput;
import com.pensionmanagement.processpension.model.ProcessPensionInput;
import com.pensionmanagement.processpension.model.ProcessPensionResponse;
import com.pensionmanagement.processpension.service.ProcessPensionService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j 
public class ProcessPensionController {

	@Autowired
	private AuthorizationServiceClient feignWithAuth;
	
	@Autowired
	private ProcessPensionService service;

	/**
	 * This method validates the token and returns the ResponseEntity.
	 * @param pensionerInput,  header
	 * @throws  TokenException, InvalidPensionerDetails
	 * @return ResponseEntity<?>
	 */	
	@PostMapping("/pensiondetail")
	public ResponseEntity<?> getPensionDetail(@RequestBody PensionerInput pensionerInput,@RequestHeader(name="Authorization") String header) throws  TokenException, PensionerDetailsNotFound
	{
		log.info("Inside getPensionDetail() method of processPension Microservice");
		try{
			feignWithAuth.validate(header);
			}
		catch(Exception e)
			{	
				log.error("Validation Error");
				throw new TokenException("Invalid Token");
			}
		
		return new ResponseEntity<>(service.getPensionDetail(header,pensionerInput),HttpStatus.OK);
	
	}
	
	/**
	 * This method first validates the header and then returns the pension status code
	 * @param header, pensionInput 
	 * @throws  TokenException, InvalidPensionerDetails
	 * @return ProcessPensionResponse
	 */	
	@PostMapping("/processpension")
	public ProcessPensionResponse processPension(@RequestHeader("Authorization") String header,@RequestBody ProcessPensionInput pensionInput ) throws TokenException, PensionerDetailsNotFound
	{
		log.info("Inside getPensionDetail() method of processPension Microservice");
		
		
		try{
			feignWithAuth.validate(header);
			}
		catch(Exception e)
			{	
				log.error("Validation Error");
				throw new TokenException("Invalid Token");
			}
		log.info("Returning Status Code");
		return service.processPensionInput(header,pensionInput);			
	}
	
	/**
	 * This method first validates the header and then is used to return List of PensionDetails
	 * @param header
	 * @throws  TokenException
	 * @return  List<PensionDetail>
	 */	
	@GetMapping("/viewdetailpension")
	public List<PensionDetail> viewdetails(@RequestHeader("Authorization") String header) throws TokenException{
		
		
		try{
			feignWithAuth.validate(header);
			}
		catch(Exception e)
			{	
				log.error("Validation Error");
				throw new TokenException("Invalid Token");
			}
		log.info("Returning Details");
		return service.viewing();
	
	
}
}