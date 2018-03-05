package com.coffeekong.dto;

import javax.validation.constraints.NotNull;

import lombok.Data;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Data
public class LoginDTO {
	@NotEmpty
	@Email
	private String email;
	@NotEmpty
	private String pw;
	@NotNull
	private boolean useCookie;
}
