package com.pensionmanagement.processpension.service;

import java.util.List;

import com.pensionmanagement.common.exception.PensionerDetailsNotFound;
import com.pensionmanagement.processpension.model.PensionDetail;
import com.pensionmanagement.processpension.model.PensionerDetailPojo;
import com.pensionmanagement.processpension.model.PensionerInput;
import com.pensionmanagement.processpension.model.ProcessPensionInput;
import com.pensionmanagement.processpension.model.ProcessPensionResponse;

public interface ProcessPensionService {
	
	/**
	 * This method is used to check the validity of entered details. If the data
	 * gets matched then pension amount is calculated and servive charge is
	 * deducted.
	 * 
	 * @param obj1, obj2
	 * @throws PensionerDetailsNotFound
	 * @return PensionDetail
	 */	
	PensionDetail checkAndCalculate(PensionerInput pensionerInput, PensionerDetailPojo pensionerDetail) throws PensionerDetailsNotFound;
	/**
	 * This method is used to get the details from the csv file using aadhar number
	 * and passing on the details to checkAndCalculate method to calculate pension
	 * amount and returns the data with calculated pension amount.
	 * 
	 * @param header, pensionerInput
	 * @throws PensionerDetailsNotFound
	 * @return PensionDetail
	 */
	PensionDetail getPensionDetail(String header, PensionerInput pensionerInput) throws PensionerDetailsNotFound;
	/**
	 * This method adds data to database and returns response code
	 * 
	 * @param header, pensionInput
	 * @return ProcessPensionResponse
	 */
	ProcessPensionResponse processPensionInput(String header, ProcessPensionInput pensionInput);
	/**
	 * This method is used to retrieve data from the database
	 * 
	 * @param header, pensionInput
	 * @return List<PensionDetail>
	 */
	public List<PensionDetail> viewing();
	
	
}
