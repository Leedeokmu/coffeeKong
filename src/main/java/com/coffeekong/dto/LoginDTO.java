package com.coffeekong.dto;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class LoginDTO {
	@NotEmpty
	@Email
	private String email;
	@NotEmpty
	private String pw;
	@NotNull
	private boolean useCookie;

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public boolean isUseCookie() {
		return useCookie;
	}
	public void setUseCookie(boolean useCookie) {
		this.useCookie = useCookie;
	}
	
	@Override
	public String toString() {
		return "LoginDTO [email=" + email + ", pw=" + pw + ", useCookie=" + useCookie + "]";
	}
}
