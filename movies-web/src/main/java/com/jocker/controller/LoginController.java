package com.jocker.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.movie.model.Customer;
import com.movie.model.Login;
import com.movie.service.ILoginService;

@Controller
public class LoginController {
	
	@Autowired
	private ILoginService loginService;
	
	@GetMapping("/oauth")
	public String showLoginPage(Model model){
		return "login";
	}
	
	
	@GetMapping("/cregister")
	public String showCustomerRegistrationPage(Model model){
		return "register";
	}
	
	@PostMapping("/cregister")
	public String saveCustomer(@ModelAttribute Customer customer,Model model){
		String result=loginService.saveCustomer(customer);
		model.addAttribute("message", "Hey ! you have been succesfully registered into the application!");
		return "register";
	}
	

	@GetMapping("/logout")
	public String logout(Model model,HttpSession session) {
		//below will invalidate the current user session data
		session.invalidate();
		model.addAttribute("message", "Hey ! you have been succesfully logout from the application!");
		return "login";
	}
	
	
	
	
	@PostMapping("/oauth")
	public String loginPageSubmit(@ModelAttribute Login login,HttpSession session,Model model){
		Login dlogin=loginService.authUser(login);
		if(dlogin.getLid()==0){
			model.addAttribute("message", "Sorry! your username and password are not valid!");
			return "login";
		}else{
			//I am going to create session for user once he is authenticated
			session.setAttribute("USER_SESSION_DATA", dlogin);
			return "redirect:/movies"; ///movies	
		}
	}

}
