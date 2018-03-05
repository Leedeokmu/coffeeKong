package com.coffeekong.domain;

import lombok.Data;

import java.util.Date;

@Data
public class ReviewVO {
	private int r_id;
	private int p_id;
	private String u_email;
	private String u_name;
	private String r_grade;
	private String r_content;
	private Date r_date;

}
