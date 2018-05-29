package com.coffeekong.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class LoginDTO {
	@NotEmpty
	@Email
	private String email;
	@NotEmpty
	private String pwd;
	@NotNull
	private boolean useCookie;
}
