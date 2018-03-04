package com.coffeekong.domain;

public class CartVO {
	private String c_num;
	private int p_id;
	private String p_name;
	private String p_category;
	private String p_img;
	private Double p_price;
	private Double sub_price;
	private int qty;
	private String type;
	private String sz;

	public Double getSub_price() {
		return sub_price;
	}

	public void setSub_price(Double sub_price) {
		this.sub_price = sub_price;
	}

	public String getC_num() {
		return c_num;
	}

	public void setC_num(String c_num) {
		this.c_num = c_num;
	}

	public String getP_name() {
		return p_name;
	}

	public void setP_name(String p_name) {
		this.p_name = p_name;
	}

	public String getP_img() {
		return p_img;
	}

	public String getP_category() {
		return p_category;
	}

	public void setP_category(String p_category) {
		this.p_category = p_category;
	}

	public void setP_img(String p_img) {
		this.p_img = p_img;
	}

	public Double getP_price() {
		return p_price;
	}

	public void setP_price(Double p_price) {
		this.p_price = p_price;
	}

	public String getSz() {
		return sz;
	}

	public void setSz(String sz) {
		this.sz = sz;
	}

	public int getP_id() {
		return p_id;
	}

	public void setP_id(int p_id) {
		this.p_id = p_id;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "CartVO [c_num=" + c_num + ", p_id=" + p_id + ", p_name=" + p_name + ", p_category=" + p_category
				+ ", p_img=" + p_img + ", p_price=" + p_price + ", sub_price=" + sub_price + ", qty=" + qty + ", type="
				+ type + ", sz=" + sz + "]";
	}
}
