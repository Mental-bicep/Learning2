package com.rapido.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller 
public class LoginController {

	@GetMapping("/doLogin")
	public String login() {
		System.out.println("inside the controller and llgin method");
		return "login-page";
	}
}
