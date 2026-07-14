package com.EC.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.EC.requests.UserLoginRequest;
import com.EC.service.UserLoginService;

@Controller
public class UserLoginController {
	
	@Autowired
	UserLoginService userLoginService;
	
	@PostMapping("/UserLogin")
	public String userLogin(@ModelAttribute UserLoginRequest userLoginRequest) {
		System.out.println("inside the user login controller");
		System.out.println(userLoginRequest);
		String returnPage = userLoginService.login(userLoginRequest);
		return returnPage;
	}
}
