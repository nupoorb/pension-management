package com.pensionmanagement.processpension.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.pensionmanagement.processpension.model.PensionDetail;

@FeignClient(name = "portal", url = "${portal}")
public interface PortalClient {
	@GetMapping("/viewdetailpension")
	public List<PensionDetail> viewdetails();
}
