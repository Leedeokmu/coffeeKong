package com.coffeekong.domain;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class OrderVO {
	private int oId;
	private String uEmail;
	private Double oPrice;
	private String oRfname;
	private String oRlname;
	private String oPhone;
	private String oPostcode;
	private String oAddr;
	private String oState;
	private Date oDate;
	private List<OrderProdVO> opvo;
}
