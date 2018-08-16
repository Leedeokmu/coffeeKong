package com.coffeekong.domain;

import lombok.Data;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;
import java.util.Date;

@Data
public class UserVO {
	@NotEmpty
	@Email
	private String email;
	@NotEmpty
	private String fname;
	@NotEmpty
	private String lname;
	@NotEmpty
	@Size(min=4, message="too short")
	private String pwd;
	private int point;
	private String sessId;
	private Date sessLimit;

}
