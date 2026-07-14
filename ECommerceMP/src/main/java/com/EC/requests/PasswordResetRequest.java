package com.EC.requests;

public class PasswordResetRequest {
	String email;
	String password;
	String confirmPassword;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	@Override
	public String toString() {
		return "PasswordResetRequest [email=" + email + ", password=" + password + ", confirmPassword="
				+ confirmPassword + "]";
	}
	
	
}
