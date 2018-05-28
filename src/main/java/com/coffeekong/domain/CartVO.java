package com.coffeekong.domain;

import lombok.Data;

@Data
public class CartVO {
	private String uuid;
	private int productId;
	private String name;
	private String category;
	private String img;
	private Double price;
	private Double subPrice;
	private int qty;
	private String type;
	private String sz;

}
