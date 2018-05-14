package com.coffeekong.domain;

import lombok.Data;

import java.util.Date;

@Data
public class ReviewVO {
	private int rId;
	private int pId;
	private String uEmail;
	private String uName;
	private String rGrade;
	private String rContent;
	private Date rDate;

}
