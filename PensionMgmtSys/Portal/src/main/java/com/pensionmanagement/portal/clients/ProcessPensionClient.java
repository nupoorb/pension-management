package com.pensionmanagement.portal.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.pensionmanagement.common.exception.TokenException;
import com.pensionmanagement.portal.model.PensionDetail;
import com.pensionmanagement.portal.model.PensionerInput;
import com.pensionmanagement.portal.model.ProcessPensionInput;
import com.pensionmanagement.portal.model.ProcessPensionResponse;

@FeignClient(name = "process-pension", url = "${process-pension}")
public interface ProcessPensionClient {
	
	@PostMapping("/pensiondetail")
	public PensionDetail getPensionDetail(
			@RequestBody PensionerInput pensionerInput,@RequestHeader("Authorization") String token) throws TokenException;

	@PostMapping("/processpension")
	public ProcessPensionResponse getDisbursementCode(@RequestHeader("Authorization") String token,
			@RequestBody ProcessPensionInput processPensionInput);
	
	@GetMapping("/viewdetailpension")
	public List<PensionDetail> viewdetails(@RequestHeader("Authorization") String token);

}
