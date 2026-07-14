package com.amazon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amazon.request.OtpRequest;
import com.amazon.request.OtpResponse;
import com.amazon.request.VerifyOtpRequest;
import com.amazon.service.OtpService;

@RestController  // controller + reponsebody 
@RequestMapping("/otp")
public class OtpController {

	@Autowired
	OtpService otpService;
	
	@PostMapping("/generate" )
	public OtpResponse generateOtp(@RequestBody OtpRequest optRequest) {
		String name = optRequest.getName();
		String mobile = optRequest.getMobile();
		
		OtpResponse res = otpService.saveOtp(name, mobile);
		return res;
		
	}
	
	@PostMapping("/verify")
	public ResponseEntity<?> verifyOtp(@RequestBody VerifyOtpRequest verifyOtpRequest) {
		return otpService.checkValidOtp(verifyOtpRequest);
	}
	
}
