package com.coffeekong.service;

import com.coffeekong.domain.Criteria;
import com.coffeekong.domain.ProductVO;
import com.coffeekong.domain.ReviewVO;
import com.coffeekong.domain.SearchCriteria;

import java.util.List;

public interface ProductService {
	List<ProductVO> listByCategory(String category) throws Exception;
	ProductVO getByPid(int pid) throws Exception;
	List<ProductVO> list(SearchCriteria cri) throws Exception;
	int listCount(SearchCriteria cri) throws Exception;
	void delete(int pid) throws Exception;
	void update(ProductVO pvo) throws Exception;
	void insert(ProductVO pvo) throws Exception;
	List<ReviewVO> listReview(int pid, Criteria cri) throws Exception;
	int listReviewCount(int pid) throws Exception;
	void addReview(ReviewVO rvo) throws Exception;
	void deleteReview(int rid) throws Exception;
}
