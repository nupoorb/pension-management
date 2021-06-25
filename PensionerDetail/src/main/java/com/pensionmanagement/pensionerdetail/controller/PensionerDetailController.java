package com.pensionmanagement.pensionerdetail.controller;

import java.io.IOException;
import java.text.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.pensionmanagement.pensionerdetail.exception.InvalidTokenException;
import com.pensionmanagement.pensionerdetail.exception.NotFoundException;
import com.pensionmanagement.pensionerdetail.model.PensionerDetail;
import com.pensionmanagement.pensionerdetail.service.PensionerDetailService;



@RestController

public class PensionerDetailController {
	
	@Autowired
	private PensionerDetailService service;
	
	
	
	@GetMapping("/pensionerdetailbyaadhaar/{aadharnumber}")
	public PensionerDetail findById(String header ,@PathVariable("aadharnumber") long aadharnumber) throws InvalidTokenException , NumberFormatException, IOException, ParseException, NotFoundException {
		return null;
	}
	
		
	
}
