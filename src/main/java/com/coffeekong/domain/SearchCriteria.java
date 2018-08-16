package com.coffeekong.domain;

import lombok.Data;
import org.springframework.data.domain.PageRequest;

import java.awt.print.Pageable;

@Data
public class SearchCriteria extends PageRequest {

	private String searchType;
	private String keyword;

}
