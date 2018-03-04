package com.coffeekong.domain;

import java.util.Date;

public class ReviewVO {
	private int r_id;
	private int p_id;
	private String u_email;
	private String u_name;
	private String r_grade;
	private String r_content;
	private Date r_date;

	public String getU_name() {
		return u_name;
	}

	public void setU_name(String u_name) {
		this.u_name = u_name;
	}

	public String getR_grade() {
		return r_grade;
	}

	public void setR_grade(String d) {
		this.r_grade = d;
	}

	public int getR_id() {
		return r_id;
	}

	public void setR_id(int r_id) {
		this.r_id = r_id;
	}

	public int getP_id() {
		return p_id;
	}

	public void setP_id(int p_id) {
		this.p_id = p_id;
	}

	public String getU_email() {
		return u_email;
	}

	public void setU_email(String u_email) {
		this.u_email = u_email;
	}

	public String getR_content() {
		return r_content;
	}

	public void setR_content(String r_content) {
		this.r_content = r_content;
	}

	public Date getR_date() {
		return r_date;
	}

	public void setR_date(Date r_date) {
		this.r_date = r_date;
	}

	@Override
	public String toString() {
		return "ReviewVO [r_id=" + r_id + ", p_id=" + p_id + ", u_email=" + u_email + ", u_name=" + u_name
				+ ", r_grade=" + r_grade + ", r_content=" + r_content + ", r_date=" + r_date + "]";
	}

}
