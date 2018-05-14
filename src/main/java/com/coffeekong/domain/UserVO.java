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
	private String uEmail;
	@NotEmpty
	private String uFname;
	@NotEmpty
	private String uLname;
	@NotEmpty
	@Size(min=4, message="too short")
	private String uPwd;
	private int uPoint;
	private String sessId;
	private Date sessLimit;

}
