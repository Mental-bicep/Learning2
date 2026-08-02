package com.profiles;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.irctc", "com.profiles"})
public class IrctcBookingApplication {

	public static void main(String[] args) {
		SpringApplication.run(IrctcBookingApplication.class, args);
	}

}
