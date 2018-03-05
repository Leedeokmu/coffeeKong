package com.coffeekong.domain;

import java.util.Date;

import javax.validation.constraints.Size;

import lombok.Data;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Data
public class MgrVO {
	private String m_email;
	private String m_fname;
	private String m_lname;
	private String m_pwd;
	private String sess_id;
	private Date sess_limit;
}
