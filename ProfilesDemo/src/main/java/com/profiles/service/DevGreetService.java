package com.profiles.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("dev")
public class DevGreetService implements GreetService{
	@Override
	public String greet() {
		return "Welcome this is DEV Env";
	}
}
