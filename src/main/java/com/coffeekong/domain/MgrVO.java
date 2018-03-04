package com.coffeekong.domain;

import java.util.Date;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class MgrVO {
	private String m_email;
	private String m_fname;
	private String m_lname;
	private String m_pwd;
	private String sess_id;
	private Date sess_limit;

	public String getM_email() {
		return m_email;
	}

	public void setM_email(String m_email) {
		this.m_email = m_email;
	}

	public String getM_fname() {
		return m_fname;
	}

	public void setM_fname(String m_fname) {
		this.m_fname = m_fname;
	}

	public String getM_lname() {
		return m_lname;
	}

	public void setM_lname(String m_lname) {
		this.m_lname = m_lname;
	}

	public String getM_pwd() {
		return m_pwd;
	}

	public void setM_pwd(String m_pwd) {
		this.m_pwd = m_pwd;
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
}
