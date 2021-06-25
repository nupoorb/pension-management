package com.pensionmanagement.portal.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.pensionmanagement.portal.model.PensionerInput;
import com.pensionmanagement.portal.model.UserLoginCredential;
import com.pensionmanagement.portal.service.PortalService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class LoginController {

	@Autowired
	private PortalService portalService;

	
	@GetMapping("/")
	public String homePage(HttpSession session) {
		if((session.getAttribute("token")==null)) {
		log.debug("Fetching The index Page");
		return "index";
	}
		return "home";
	}
	
	
	
	@GetMapping("/home")
	public String home(HttpSession session) {
		return null;
	}
	
	
	@GetMapping("/login")
	public String displayLoginPage(Model model, UserLoginCredential login,HttpSession session) {
		return null;
	}
	

	@GetMapping("/logout")
	public String logout(HttpSession session,Model model)
	{
		log.debug("Logging Out");
		return "login";
	}
	
	
	@PostMapping("/login")
	public String parseLoginPage(@Valid @ModelAttribute("pensionerInput") PensionerInput pensionerInput ,@ModelAttribute("login") UserLoginCredential login,HttpServletRequest request,Model model) {
		log.debug("Submitting login Information");
		//UserLoginCredential token = portalService.getPensionerPage(pensionerInput,login);
		return null;
	}
}
