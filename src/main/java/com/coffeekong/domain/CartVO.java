package com.coffeekong.domain;

import lombok.Data;

@Data
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

}
