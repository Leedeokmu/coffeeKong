package com.coffeekong.domain;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class OrderVO {
	private int o_id;
	private String u_email;
	private Double o_price;
	private String o_rfname;
	private String o_rlname;
	private String o_phone;
	private String o_postcode;
	private String o_addr;
	private String o_state;
	private Date o_date;
	private List<OrderProdVO> opvo;
}
