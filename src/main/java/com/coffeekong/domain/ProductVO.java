package com.coffeekong.domain;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.sql.Date;

@Data
@Slf4j
public class ProductVO {

	private int p_id;
	private String p_category;
	private String p_name;
	private String p_content;
	private Double p_price;
	private Date p_mdate;
	private Date p_rdate;
	private String p_img;

}
