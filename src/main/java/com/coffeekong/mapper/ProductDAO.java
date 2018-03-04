package com.coffeekong.mapper;

import java.util.List;

import com.coffeekong.domain.Criteria;
import com.coffeekong.domain.ProductVO;
import com.coffeekong.domain.ReviewVO;
import com.coffeekong.domain.SearchCriteria;

public interface ProductDAO {
	public List<ProductVO> listByCategory(String category) throws Exception;
	public ProductVO getByPid(int pid) throws Exception;
	public List<ProductVO> list(SearchCriteria cri) throws Exception;
	public int listCount(SearchCriteria cri) throws Exception;
	public void delete(int pid) throws Exception;
	public void update(ProductVO pvo) throws Exception;
	public void insert(ProductVO pvo) throws Exception;
	public List<ReviewVO> listReview(int pid, Criteria cri) throws Exception;
	public int listReviewCount(int pid) throws Exception;
	public void addReview(ReviewVO rvo) throws Exception;
	public void deleteReview(int rid) throws Exception;
	

}

