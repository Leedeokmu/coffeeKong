package com.coffeekong.domain;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

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

	public String getU_email() {
		return u_email;
	}

	public void setU_email(String u_email) {
		this.u_email = u_email;
	}

	public String getU_fname() {
		return u_fname;
	}

	public void setU_fname(String u_fname) {
		this.u_fname = u_fname;
	}

	public String getU_lname() {
		return u_lname;
	}

	public void setU_lname(String u_lname) {
		this.u_lname = u_lname;
	}

	public String getU_pwd() {
		return u_pwd;
	}

	public void setU_pwd(String u_pwd) {
		this.u_pwd = u_pwd;
	}

	public int getU_point() {
		return u_point;
	}

	public void setU_point(int u_point) {
		this.u_point = u_point;
	}

	public String getSess_id() {
		return sess_id;
	}

	public void setSess_id(String sess_id) {
		this.sess_id = sess_id;
	}

	public Date getSess_limit() {
		return sess_limit;
	}

	public void setSess_limit(Date sess_limit) {
		this.sess_limit = sess_limit;
	}

	@Override
	public String toString() {
		return "UserVO [u_email=" + u_email + ", u_fname=" + u_fname + ", u_lname=" + u_lname + ", u_pwd=" + u_pwd
				+ ", u_point=" + u_point + "]";
	}

}
