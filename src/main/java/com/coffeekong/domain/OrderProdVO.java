package com.coffeekong.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OrderProdVO {
	private int op_id;
	private int o_id;
	private int p_id;
	private String p_name; 		// from product
	private String p_category; 	// from product
	private String p_img; 		// from product
	private int op_qty;
	private String op_sz;
	private String op_type;
	private double op_price;

	public int getOp_id() {
		return op_id;
	}

	public void setOp_id(int op_id) {
		this.op_id = op_id;
	}

	public int getO_id() {
		return o_id;
	}

	public void setO_id(int o_id) {
		this.o_id = o_id;
	}

	public int getP_id() {
		return p_id;
	}

	public void setP_id(int p_id) {
		this.p_id = p_id;
	}

	public int getOp_qty() {
		return op_qty;
	}

	public void setOp_qty(int op_qty) {
		this.op_qty = op_qty;
	}

	public String getOp_sz() {
		return op_sz;
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

	public String getP_img() {
		return p_img;
	}

	public void setP_img(String p_img) {
		this.p_img = p_img;
	}

	public void setOp_sz(String op_sz) {
		this.op_sz = op_sz;
	}

	public String getOp_type() {
		return op_type;
	}

	public void setOp_type(String op_type) {
		this.op_type = op_type;
	}

	public double getOp_price() {
		return op_price;
	}

	public void setOp_price(double op_price) {
		this.op_price = op_price;
	}
}
