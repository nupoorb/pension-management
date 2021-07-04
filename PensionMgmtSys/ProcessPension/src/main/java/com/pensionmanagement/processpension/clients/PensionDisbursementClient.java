package com.pensionmanagement.processpension.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import com.pensionmanagement.processpension.model.ProcessPensionInput;
import com.pensionmanagement.processpension.model.ProcessPensionResponse;

@FeignClient(name="pensiondisburse", url = "${pensiondisbursement}")
public interface PensionDisbursementClient {

	@PostMapping("/disbursepension")
	public ProcessPensionResponse evaluation(@RequestHeader(name="Authorization") String header, ProcessPensionInput processPensionInput);

	
}
