package com.profiles.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.profiles.entity.ProfileEntity;
import com.profiles.service.ProfileService;

@RestController
public class ProfileController {
	
	@Autowired
	ProfileService profileService;
	
	@GetMapping("/saveProfile")
	public ProfileEntity saveProfile() {
		return profileService.saveProfile();
	}
}
