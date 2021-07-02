package com.pensionmanagement.processpension.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pensionmanagement.processpension.clients.PensionDisbursementClient;
import com.pensionmanagement.processpension.clients.PensionerDetailClient;
import com.pensionmanagement.common.exception.PensionerDetailsNotFound;
import com.pensionmanagement.processpension.model.MyConstants;
import com.pensionmanagement.processpension.model.PensionDetail;
import com.pensionmanagement.processpension.model.PensionerDetailPojo;
import com.pensionmanagement.processpension.model.PensionerInput;
import com.pensionmanagement.processpension.model.ProcessPensionInput;
import com.pensionmanagement.processpension.model.ProcessPensionResponse;
import com.pensionmanagement.processpension.repository.ProcessPensionRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProcessPensionServiceImpl implements ProcessPensionService{
	 PensionerDetailPojo pensionerDetail=new PensionerDetailPojo();

	@Autowired 
	ProcessPensionRepository repo;
	
	@Autowired
	private PensionerDetailClient feignWithPensionerDetail;
	
	@Autowired
	private PensionDisbursementClient feignWithDisbursement;
	
	/**
	 * This method is used to check the validity of entered details. If the data
	 * gets matched then pension amount is calculated and servive charge is
	 * deducted.
	 * 
	 * @param obj1, obj2
	 * @throws PensionerDetailsNotFound
	 * @return PensionDetail
	 */
	@Override
	public PensionDetail checkAndCalculate(PensionerInput pensionerInput, PensionerDetailPojo pensionerDetailPojo) throws PensionerDetailsNotFound {
		double pensionAmount;
		if (pensionerInput.getName().equalsIgnoreCase(pensionerDetailPojo.getName()) && pensionerInput.getDateOfBirth().equals(pensionerDetailPojo.getDateOfBirth())  && pensionerInput.getPan().equals(pensionerDetailPojo.getPan()) && pensionerInput.getPensionType().equals(pensionerDetailPojo.getPensionType()))
		{
			log.debug("Calculating Pension Amount");
			if(pensionerDetailPojo.getPensionType().equalsIgnoreCase(MyConstants.PENSION_TYPE_SELF))
					pensionAmount = (pensionerDetailPojo.getSalaryEarned() * MyConstants.SELF_PERCENT)  + pensionerDetailPojo.getAllowances();
			else
				pensionAmount = ( pensionerDetailPojo.getSalaryEarned() * MyConstants.FAMILY_PERCENT) + pensionerDetailPojo.getAllowances();
			
			if(pensionerDetailPojo.getBankType().equalsIgnoreCase(MyConstants.BANK_TYPE_PRIVATE))
				pensionAmount-=MyConstants.BANK_CHARGE_PRIVATE;
			else
				pensionAmount-=MyConstants.BANK_CHARGE_PUBLIC;
			
			return new PensionDetail(pensionerDetailPojo.getAadharNumber(),pensionerDetailPojo.getName(),
					pensionerDetailPojo.getDateOfBirth(),pensionerDetailPojo.getPan(),pensionerDetailPojo.getPensionType(),pensionAmount);
		}
		else {
			log.error("Validation Error");
			return  null;
		}
		
	}
	
	/**
	 * This method is used to get the details from the csv file using aadhar number
	 * and passing on the details to checkAndCalculate method to calculate pension
	 * amount and returns the data with calculated pension amount.
	 * 
	 * @param header, pensionerInput
	 * @throws PensionerDetailsNotFound
	 * @return PensionDetail
	 */
	@Override
	public PensionDetail getPensionDetail(String header,PensionerInput pensionerInput) throws PensionerDetailsNotFound {
		 
		pensionerDetail = null;
		PensionDetail pensionDetail = null;
		 try {
		 pensionerDetail = feignWithPensionerDetail.getDetails(header,pensionerInput.getAadharNumber());
		 log.error("Checking.... ");
		 pensionDetail=checkAndCalculate(pensionerInput,pensionerDetail);
		 }
		 catch(Exception e)
		 {
			 log.error("Details Incorrect");
			 return null;
		 }
		return pensionDetail; 
	}
	
	/**
	 * This method adds data to database and returns response code
	 * 
	 * @param header, pensionInput
	 * @return ProcessPensionResponse
	 */
	@Override
	public ProcessPensionResponse processPensionInput(String header, ProcessPensionInput pensionInput) {
		ProcessPensionResponse responsecode=null;
		responsecode = feignWithDisbursement.evaluation(header,pensionInput);
		
		if(responsecode==null)
			return responsecode;
		if(responsecode.getProcessPensionStatusCode()==MyConstants.SUCCESS)
		{
			PensionDetail pensionDetail = new PensionDetail(pensionerDetail.getAadharNumber(),pensionerDetail.getName(),pensionerDetail.getDateOfBirth(),
					pensionerDetail.getPan(),pensionerDetail.getPensionType(),pensionInput.getPensionAmount());
			repo.save(pensionDetail);
		}
		return responsecode;
		
	}
	
	/**
	 * This method is used to retrieve data from the database
	 * 
	 * @param header, pensionInput
	 * @return List<PensionDetail>
	 */	
	public List<PensionDetail> viewing() {
		List<PensionDetail> data=repo.findAll();
		return data;
		
	}

}
