package com.profiles.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("preprod" )
public class PreProdGreetService implements GreetService {
	
	@Override
	public String greet() {
		return "Welcome to PreProd Env";
	}
}
