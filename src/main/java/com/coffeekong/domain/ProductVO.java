package com.coffeekong.domain;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.sql.Date;

@Data
@Slf4j
public class ProductVO {

	private Integer pId;
	private String pCategory;
	private String pName;
	private String pContent;
	private Double pPrice;
	private Date pMdate;
	private Date pRdate;
	private String pImg;

}
