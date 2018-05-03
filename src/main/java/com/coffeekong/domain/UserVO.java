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
	private String u_email;
	@NotEmpty
	private String u_fname;
	@NotEmpty
	private String u_lname;
	@NotEmpty
	@Size(min=4, message="too short")
	private String u_pwd;
	private int u_point;
	private String sess_id;
	private Date sess_limit;

}
