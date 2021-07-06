package com.pensionmanagement.processpension.service;

import java.util.List;

import com.pensionmanagement.common.exception.PensionerDetailsNotFound;
import com.pensionmanagement.processpension.model.PensionDetail;
import com.pensionmanagement.processpension.model.PensionerDetailPojo;
import com.pensionmanagement.processpension.model.PensionerInput;
import com.pensionmanagement.processpension.model.ProcessPensionInput;
import com.pensionmanagement.processpension.model.ProcessPensionResponse;

public interface ProcessPensionService {
	
	
	PensionDetail checkAndCalculate(PensionerInput pensionerInput, PensionerDetailPojo pensionerDetail) throws PensionerDetailsNotFound;

	PensionDetail getPensionDetail(String header, PensionerInput pensionerInput) throws PensionerDetailsNotFound;
	
	ProcessPensionResponse processPensionInput(String header, ProcessPensionInput pensionInput);
	
	public List<PensionDetail> viewing();
	
	
}
