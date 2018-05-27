package com.coffeekong.service;

import com.coffeekong.domain.Criteria;
import com.coffeekong.domain.ProductVO;
import com.coffeekong.domain.ReviewVO;
import com.coffeekong.domain.SearchCriteria;
import com.coffeekong.mapper.ProductMapper;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductService {
	private static final Logger logger = LoggerFactory.getLogger(ProductService.class);

	@Autowired
	private ProductMapper productMapper;
	
	public List<ProductVO> listByCategory(String category) {
		return productMapper.listByCategory(category);
	}
	public ProductVO getByPid(int pid) {
		return productMapper.getByPid(pid);
	}
	public List<ProductVO> list(SearchCriteria cri) {
		return productMapper.list(cri);
	}
	public int listCount(SearchCriteria cri) {
		return productMapper.listCount(cri);
	}
	
	@Transactional
	public void delete(int pid) {
		productMapper.delete(pid);
	}
	public void update(ProductVO pvo) {
		productMapper.update(pvo);
	}
	public void insert(ProductVO pvo) {
		productMapper.insert(pvo);
	}
	public List<ReviewVO> listReview(Integer pid, Criteria cri) {
	    Integer startIndex = (cri.getPage()-1) * cri.getPerPageNum();
		return productMapper.listReview(pid, startIndex, cri.getPerPageNum());
	}
	public int listReviewCount(int pid) {
		return productMapper.listReviewCount(pid);
	}
	public void addReview(ReviewVO rvo) {
		productMapper.addReview(rvo);
	}
	public void deleteReview(int rid) {
		productMapper.deleteReview(rid);
	}
	
}
