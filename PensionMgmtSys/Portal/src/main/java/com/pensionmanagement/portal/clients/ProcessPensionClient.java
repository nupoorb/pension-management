package com.pensionmanagement.portal.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.pensionmanagement.common.exception.PensionerDetailsNotFound;
import com.pensionmanagement.common.exception.TokenException;
import com.pensionmanagement.portal.model.PensionDetail;
import com.pensionmanagement.portal.model.PensionerInput;
import com.pensionmanagement.portal.model.ProcessPensionInput;
import com.pensionmanagement.portal.model.ProcessPensionResponse;

@FeignClient(name = "processpension")
public interface ProcessPensionClient {
	
	@PostMapping("/pensiondetail")
	public ResponseEntity<PensionDetail> getPensionDetail(@RequestBody PensionerInput pensionerInput,@RequestHeader(name="Authorization") String header) throws  TokenException, PensionerDetailsNotFound;
	
	@PostMapping("/processpension")
	public ProcessPensionResponse processPension(@RequestHeader("Authorization") String header,@RequestBody ProcessPensionInput pensionInput ) throws TokenException, PensionerDetailsNotFound;
	
	@GetMapping("/viewdetailpension")
	public List<PensionDetail> viewdetails(@RequestHeader("Authorization") String header) throws TokenException;

}
