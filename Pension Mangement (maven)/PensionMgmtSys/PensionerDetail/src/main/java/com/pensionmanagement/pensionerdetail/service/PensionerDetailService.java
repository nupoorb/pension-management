package com.pensionmanagement.pensionerdetail.service;

import java.io.IOException;
import java.text.ParseException;
import org.springframework.stereotype.Service;
import com.pensionmanagement.pensionerdetail.exception.NotFoundException;
import com.pensionmanagement.pensionerdetail.model.PensionerDetail;


@Service

public interface PensionerDetailService {

	public PensionerDetail getById(long aadharnumber) throws NumberFormatException, IOException, ParseException, NotFoundException;
			

		}
	
	
