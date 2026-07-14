package com.EC.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.EC.requests.SignUpRequest;
import com.EC.service.UserRegistrationService;

@Controller
public class UserRegistrationController {
	
	@Autowired
	UserRegistrationService userRegistrationService;
	
	@PostMapping("/UserRegistration")
	public String userRegistration(@ModelAttribute SignUpRequest signUpRequest ) {
		System.out.println("inside the userRegistration COntroller");
		System.out.println(signUpRequest);
		
		userRegistrationService.registration(signUpRequest);
		
		return "success";
	}
}
