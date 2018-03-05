package com.coffeekong.domain;

import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Criteria {
	private static final Logger logger = LoggerFactory.getLogger(Criteria.class);
	
	private int page;
	private int perPageNum;
	
	public Criteria(){
		this.page = 1;
		this.perPageNum = 10;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		if(page <=0){
			this.page =1;
			return;
		}
		this.page = page;
	}

	public int getPerPageNum() {
		return perPageNum;
	}

	public void setPerPageNum(int perPageNum) {
		if(perPageNum <= 0 || perPageNum >100){
			this.perPageNum = 10;
		}
		this.perPageNum = perPageNum;
	}
	
	public int getPageStart(){ // 시작 로우 넘버
		return (this.page-1)*perPageNum;
	}

	@Override
	public String toString() {
		return "Criteria [page = " + page + ", perPageNum=" + perPageNum + "]";
	}
}
