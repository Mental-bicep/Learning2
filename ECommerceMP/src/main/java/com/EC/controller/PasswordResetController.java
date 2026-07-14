package com.EC.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.EC.requests.PasswordResetRequest;
import com.EC.service.PasswordResetService;

@Controller
public class PasswordResetController {
	
	@Autowired
	PasswordResetService passwordResetService;
	
	@PostMapping("/PasswordReset")
	public String passwordReset(@ModelAttribute PasswordResetRequest passwordResetRequest ) {
		System.out.println("insider the password reset controller");
		System.out.println(passwordResetRequest);
		
		passwordResetService.passwordReset(passwordResetRequest);
		return "passwordUpdate";
	}
}
