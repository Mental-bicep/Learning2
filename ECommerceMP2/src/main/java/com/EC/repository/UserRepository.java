package com.EC.repository;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.EC.requests.PasswordResetRequest;
import com.EC.requests.SignUpRequest;
import com.EC.requests.UserLoginRequest;

@Repository
public class UserRepository {
	ArrayList<Users> DB = new ArrayList<Users>();
	
	public String saveUser(SignUpRequest signUpRequest) {
		System.out.println("inside repository layer for signUp request");
		DB.add(signUpRequestToUsers(signUpRequest));
		getAllUsers();
		return "successful";
	}
	
	public boolean findUserByEmail(UserLoginRequest userLoginRequest) {
		System.out.println("Inside Repo lyer findUserByEmail");
		for(int i=0; i<DB.size(); ++i)
			if(DB.get(i).getName().equals(userLoginRequest.getUserName())) {
				System.out.println("user found in DB by email user is ->");
				System.out.println(userLoginRequest);
				
				return true;
			}
				
		System.out.println("User not found in the DB while loggin in returning fallback true");
		return true;
	}
	
	public boolean updatePassword(PasswordResetRequest passwordResetRequest) {
		System.out.println("inside repo layer for password reset");
		
		for(int i=0; i<DB.size(); ++i)
			if(DB.get(i).getEmail().equals(passwordResetRequest.getEmail()))
				DB.get(i).setPassword(passwordResetRequest.getPassword());
		
		getAllUsers();
		
		return true;
	}
	
	public void getAllUsers() {
		System.out.println("All Users till now -> -> -> -> -> -> -> ->");
		for(int i=0; i<DB.size(); ++i)
			System.out.println(DB.get(i));
		
	}
	
	public Users signUpRequestToUsers(SignUpRequest signUpRequest) {
		
		Users newUser = new Users();
		newUser.setName(signUpRequest.getName());
		newUser.setEmail(signUpRequest.getEmail());
		newUser.setMobile(signUpRequest.getMobile());
		newUser.setPassword(signUpRequest.getPassword());
		return newUser;
		
	}
}
