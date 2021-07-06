package com.pensionmanagement.pensionerdetail.service;

import java.io.IOException;
import java.text.ParseException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import com.pensionmanagement.common.exception.NotFoundException;
import com.pensionmanagement.common.exception.TokenException;
import com.pensionmanagement.pensionerdetail.model.PensionerDetail;


@Service

public interface PensionerDetailService {

	public PensionerDetail getById(long aadharnumber) throws NumberFormatException, IOException, ParseException, NotFoundException;
			
	public PensionerDetail findById(@RequestHeader(name="Authorization") String header ,@PathVariable("aadharnumber") long aadharnumber) throws TokenException , NumberFormatException, IOException, ParseException, NotFoundException;
}
	
	
