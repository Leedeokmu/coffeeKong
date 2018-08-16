package com.coffeekong.domain;

import java.util.Date;

import javax.validation.constraints.Size;

import lombok.Data;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Data
public class MgrVO {
	private String email;
	private String fname;
	private String lname;
	private String pwd;
	private String sessId;
	private Date sessLimit;
}
