package com.EC.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.EC.repository.UserRepository;
import com.EC.requests.PasswordResetRequest;

@Service
public class PasswordResetService {
	
	@Autowired
	UserRepository userRepository;
	
	public boolean passwordReset(PasswordResetRequest passwordResetRequest) {
		System.out.println("inside service layer for password reset");
		
		return userRepository.updatePassword(passwordResetRequest);
		
	}
}
