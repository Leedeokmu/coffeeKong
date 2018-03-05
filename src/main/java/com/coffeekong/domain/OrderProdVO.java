package com.coffeekong.domain;

import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Data
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
}
