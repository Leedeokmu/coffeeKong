package com.coffeekong.domain;

import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Data
public class SearchCriteria extends Criteria{
	private static final Logger logger = LoggerFactory.getLogger(SearchCriteria.class);
	
	private String searchType;
	private String keyword;

}
