package com.EC.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.EC.repository.UserRepository;
import com.EC.requests.UserLoginRequest;

@Service
public class UserLoginService {
	
	@Autowired
	UserRepository userRepository;
	
	public String login(UserLoginRequest userLoginRequest) {
		System.out.println("insider Service Layer for Login Service");
		userRepository.findUserByEmail(userLoginRequest);
		return "welcome";
	}
}
