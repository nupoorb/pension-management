package com.pensionmanagement.processpension.clients;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;

import com.pensionmanagement.processpension.model.PensionDetail;

@org.springframework.cloud.openfeign.FeignClient(name="GetPortalDetails", url="portal")
public interface PortalClient {
	@GetMapping("/viewdetailpension")
	public List<PensionDetail> viewdetails();
}
