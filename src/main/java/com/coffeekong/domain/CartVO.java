package com.coffeekong.domain;

import lombok.Data;

@Data
public class CartVO {
	private String cNum;
	private int pId;
	private String pName;
	private String pCategory;
	private String pImg;
	private Double pPrice;
	private Double subPrice;
	private int qty;
	private String type;
	private String sz;

}
