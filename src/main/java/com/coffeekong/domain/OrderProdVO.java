package com.coffeekong.domain;

import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Data
public class OrderProdVO {
	private int opId;
	private int oId;
	private int pId;
	private String pName; 		// from product
	private String pCategory; 	// from product
	private String pImg; 		// from product
	private int opQty;
	private String opSz;
	private String opType;
	private double opPrice;
}
