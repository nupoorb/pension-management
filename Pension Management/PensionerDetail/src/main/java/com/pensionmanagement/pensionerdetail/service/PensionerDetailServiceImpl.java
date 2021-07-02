package com.pensionmanagement.pensionerdetail.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.pensionmanagement.pensionerdetail.exception.NotFoundException;
import com.pensionmanagement.pensionerdetail.model.PensionerDetail;
import com.pensionmanagement.pensionerdetail.util.DateUtil;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PensionerDetailServiceImpl implements PensionerDetailService {

	private Map<Long, PensionerDetail> pensionDetails;
	
	public PensionerDetailServiceImpl() throws NumberFormatException, IOException, ParseException {
		String line = "";
		pensionDetails = new HashMap<>();
		BufferedReader bufferRead = new BufferedReader(
				new InputStreamReader(this.getClass().getResourceAsStream("/pensionerData.csv")));
		while ((line = bufferRead.readLine()) != null) {
			String[] persondetails = line.split(",");
			PensionerDetail pensioner = new PensionerDetail(
					Long.parseLong(persondetails[0]), 
					persondetails[1],
					DateUtil.parseDate(persondetails[2]), 
					persondetails[3], 
					Double.parseDouble(persondetails[4]),
					Double.parseDouble(persondetails[5]), 
					persondetails[6], persondetails[7],
					Long.parseLong(persondetails[8]), 
					persondetails[9]);
			pensionDetails.put(Long.parseLong(persondetails[0]), pensioner);
		}
		bufferRead.close();
	}

	@Override
	public PensionerDetail getById(long aadharnumber)
			throws NumberFormatException, IOException, ParseException, NotFoundException {
		log.info("getById method called");

		
		if (pensionDetails.containsKey(aadharnumber)) {
			return pensionDetails.get(aadharnumber);
		} else {
			throw new NotFoundException("The Adhaar Number is Unregistered");
		}

	}
}