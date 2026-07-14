package com.amazon.service;

import java.security.SecureRandom;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.amazon.entity.OtpEntity;
import com.amazon.repository.OtpRepository;
import com.amazon.request.OtpResponse;
import com.amazon.request.VerifyOtpRequest;

@Service
public class OtpService {
	
	
	final OtpRepository otpRepository;

	OtpService(OtpRepository otpRepository) {
		this.otpRepository = otpRepository;
	}
	
	public OtpResponse saveOtp(String name, String mobile) {
		
		int otp = generateOtp();
		
		OtpEntity ent = new OtpEntity();;
		ent.setMobile(mobile);
		ent.setName(name);
		ent.setStatus("Active");
		ent.setOtp(otp);
		
		OtpEntity savedEnt = otpRepository.save(ent);
		
		if(savedEnt.getId() > 0 ) System.out.println("Otp generated successfully");
		else System.out.println("Otp could not be genrated");
		
		OtpResponse res = new OtpResponse();
		res.setOtp(otp);;
		res.setStatus(savedEnt.getStatus());
		res.setValid("valid for 5mins");
		
		return res;
		
	}
	
	private int generateOtp() {
		SecureRandom random = new SecureRandom();
		int otp = 100000 + random.nextInt(900000); // Generates 100000 to 999999
		System.out.println(" Generated OTP :::: " + otp);
		return otp;
	}
	
	public ResponseEntity<?> checkValidOtp(VerifyOtpRequest req) {
		
		List<OtpEntity> entitites = otpRepository.findByMobile(req.getMobile());
		for(OtpEntity ent: entitites) 
			if(ent.getOtp() == req.getOtp()) return ResponseEntity.ok(Map.of("message","valid-otp"));
		return ResponseEntity.ok(Map.of("message","invalid-otp"));
	}
	
}
