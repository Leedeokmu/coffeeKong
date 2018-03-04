package com.coffeekong.domain;

import java.sql.Date;

public class ProductVO {
	private int p_id;
	private String p_category;
	private String p_name;
	private String p_content;
	private Double p_price;
	private Date p_mdate;
	private Date p_rdate;
	private String p_img;

	public int getP_id() {
		return p_id;
	}

	public void setP_id(int p_id) {
		this.p_id = p_id;
	}

	public String getP_category() {
		return p_category;
	}

	public void setP_category(String p_category) {
		this.p_category = p_category;
	}

	public String getP_name() {
		return p_name;
	}

	public void setP_name(String p_name) {
		this.p_name = p_name;
	}

	public String getP_content() {
		return p_content;
	}

	public void setP_content(String p_content) {
		this.p_content = p_content;
	}

	public Double getP_price() {
		return p_price;
	}

	public void setP_price(Double p_price) {
		this.p_price = p_price;
	}

	public Date getP_mdate() {
		return p_mdate;
	}

	public void setP_mdate(Date p_mdate) {
		this.p_mdate = p_mdate;
	}

	public Date getP_rdate() {
		return p_rdate;
	}

	public void setP_rdate(Date p_rdate) {
		this.p_rdate = p_rdate;
	}

	public String getP_img() {
		return p_img;
	}

	public void setP_img(String p_img) {
		this.p_img = p_img;
	}

	@Override
	public String toString() {
		return "ProductVO [p_id=" + p_id + ", p_category=" + p_category + ", p_name=" + p_name + ", p_content="
				+ p_content + ", p_price=" + p_price + ", p_mdate=" + p_mdate + ", p_rdate=" + p_rdate + ", p_img="
				+ p_img + "]";
	}

}
