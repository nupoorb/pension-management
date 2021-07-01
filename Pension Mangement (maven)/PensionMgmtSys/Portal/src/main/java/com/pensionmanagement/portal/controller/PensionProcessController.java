package com.pensionmanagement.portal.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pensionmanagement.portal.exception.TokenException;
import com.pensionmanagement.portal.model.PensionDetail;
import com.pensionmanagement.portal.model.PensionerInput;
import com.pensionmanagement.portal.model.ProcessPensionInput;
import com.pensionmanagement.portal.service.PortalService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class PensionProcessController {

	@Autowired
	private PortalService pensionProcessService;

	@GetMapping("/view")
	public String viewing(ModelMap model,HttpSession session,HttpServletRequest request)  {
		if((session.getAttribute("token")==null)) {
			log.debug("User should login");
			
			return "redirect:/login";
			}
		log.debug("Showing  Pensioner Details ");
		String token = (String)	request.getSession().getAttribute("token");
		List<PensionDetail> a=pensionProcessService.viewdetails(token);
		if (a.isEmpty()) {
			model.put("userdetails", "No Pensioner Details");
		} else {
			model.put("listOfpension",a);
		}
		return "view";
	}
	

	@GetMapping("/submitinfo")
	public String showSubmitPensionerInfo(@ModelAttribute("pensionerInput") PensionerInput pensionerInput,HttpSession session)  {
		if((session.getAttribute("token")==null)) {
			log.debug("User should login");
			
			return "redirect:/login";
			}
		log.debug("Showing  Pensioner Details form ");
		return "pensionerdetails";
	}
	

	@PostMapping("/submitinfo")
	public String submitPensionerInfo(@ModelAttribute("pensionerInput") PensionerInput pensionerInput,Model model,HttpServletRequest request) throws TokenException {
		log.debug("Submitting Pensioner Details");
		String token = (String)	request.getSession().getAttribute("token");
		return pensionProcessService.submitPensionInput(pensionerInput,model,token);
	}

	@PostMapping("/disburse")
	public String processPensionInputpost(Model model,@RequestParam("aadhaar") long aadhaar,@RequestParam("amount") double amount,ProcessPensionInput input,HttpServletRequest request) {
		if(pensionProcessService.conditionRecalculate()) {
			model.addAttribute("message", "Sorry, maximum limit for recalculation reached.");
			return "exceeded";
		}else {
		log.debug("Showing Disburse Form");
		String token = (String)	request.getSession().getAttribute("token");
		return pensionProcessService.getBankCharge(model,token,aadhaar,amount);
	}
	}
	

	@PostMapping("/evaluate")
	public String disburseProcess(Model model,@RequestParam("aadhaar") long aadhaar,@RequestParam("amount") double amount,@RequestParam("bankcharge") double bankCharge,HttpServletRequest request) {
		log.debug("Evaluating The Disburse Form");
		String token = (String)	request.getSession().getAttribute("token");
		
		ProcessPensionInput input = new ProcessPensionInput(aadhaar,amount,bankCharge);
		return pensionProcessService.disburseProcess(input,token,model);
	}


}
