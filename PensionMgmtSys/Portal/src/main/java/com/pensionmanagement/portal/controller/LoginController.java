package com.pensionmanagement.portal.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.pensionmanagement.common.exception.UserException;
import com.pensionmanagement.portal.model.UserLoginCredential;
import com.pensionmanagement.portal.service.PortalService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class LoginController {

	@Autowired
	private PortalService portalService;

	/**
	 * Display main page
	 * @param session
	 * @return
	 */
	@GetMapping("/")
	public String homePage(HttpSession session) {
		if((session.getAttribute("token")==null)) {
			log.debug("Fetching The index Page");
			return "index";
		}
		
		return "home";
	}

	/**
	 * Display home page
	 * @param session
	 * @return
	 */
	@GetMapping("/home")
	public String home(HttpSession session) {
		if((session.getAttribute("token")==null)) {
			return "index";
		}
		
		return "home";
	}
	
	/**
	 * Display login page
	 * @param session
	 * @return
	 */
	@GetMapping("/login")
	public String displayLoginPage(Model model,HttpSession session,UserLoginCredential login) {
		if((session.getAttribute("token")==null)) {
			log.debug("Fetching the login Page");
			model.addAttribute("login", login);
			return "login";
		}
		else {
			log.debug("User is logged in already");
			return "redirect:/home";
		}
	}
	
	/**
	 * Logout and display login page
	 * @param session
	 * @return
	 */
	@GetMapping("/logout")
	public String logout(HttpSession session,Model model)
	{
		log.debug("Logging Out");
		session.invalidate();
		model.addAttribute("login", new UserLoginCredential()); 
		return "login";
	}
	
	/**
	 * Login
	 * @param login
	 * @param request
	 * @param model
	 * @return
	 * @throws UserException
	 */
	@PostMapping("/login")
	public String parseLoginPage(@ModelAttribute("login") UserLoginCredential login,HttpServletRequest request,Model model) throws UserException {
		log.debug("Submitting login Information");
		UserLoginCredential token = portalService.getPensionerPage(login);
		if(token!=null)
		{
			log.debug("User Successfully authenticated");
			log.debug("Fetching PensionerDetails Form");
			request.getSession().setAttribute("token", token.getToken());
			request.getSession().setAttribute("uid", token.getUid());
			return "home";
		}
			model.addAttribute("loginerror", "Invalid Username/Password");
			return "login";
	
	}
}
