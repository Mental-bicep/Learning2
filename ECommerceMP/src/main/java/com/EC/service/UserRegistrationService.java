package com.EC.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.EC.repository.UserRepository;
import com.EC.requests.SignUpRequest;

@Service
public class UserRegistrationService {

	@Autowired
	UserRepository userRepository;
	
	public String registration(SignUpRequest signUpRequest) {
		System.out.println("inside service layer for signUp request");
		
		return userRepository.saveUser(signUpRequest);
		
		
	}
	
}
