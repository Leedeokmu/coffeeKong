package com.coffeekong.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SearchCriteria extends Criteria{
	private static final Logger logger = LoggerFactory.getLogger(SearchCriteria.class);
	
	private String searchType;
	private String keyword;
	
	public String getSearchType() {
		return searchType;
	}
	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	@Override
	public String toString() {		
		return super.toString() + "SearchCriteria >>>"
				+ "[searchType=" + searchType
				+", keyword=" + keyword + "]";
	}
	
}
