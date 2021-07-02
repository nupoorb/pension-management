package com.pensionmanagement.pensionerdetail.controller;

import java.io.IOException;
import java.text.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import com.pensionmanagement.pensionerdetail.clients.AuthorizationServiceClient;
import com.pensionmanagement.common.exception.TokenException;
import com.pensionmanagement.common.exception.NotFoundException;
import com.pensionmanagement.pensionerdetail.model.PensionerDetail;
import com.pensionmanagement.pensionerdetail.service.PensionerDetailService;
import lombok.extern.slf4j.Slf4j;


@RestController
@Slf4j
public class PensionerDetailController {
	
	@Autowired
	private PensionerDetailService service;
	
	@Autowired 
	private AuthorizationServiceClient feignWithAuth;

	@GetMapping("/pensionerdetailbyaadhaar/{aadharnumber}")
	public PensionerDetail findById(@RequestHeader(name="Authorization") String header ,@PathVariable("aadharnumber") long aadharnumber) throws TokenException , NumberFormatException, IOException, ParseException, NotFoundException {
		log.debug("findById() invoked to fetch Pensioner Details by Aadhaar Number"); 
		try{
			feignWithAuth.validate(header);
			}
		catch(Exception e)
			{	
				log.error("Validation Error");
				throw new TokenException("Invalid Token");
			}
		PensionerDetail obj =  service.getById(aadharnumber);
		if(obj == null)
		{	log.warn("Adhaar Number is not valid");
		    throw new NotFoundException("The Adhaar Number is Unregistered");
		}
		else 
			return obj;	
	}
	
}
