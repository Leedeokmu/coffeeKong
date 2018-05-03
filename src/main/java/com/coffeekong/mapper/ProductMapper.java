package com.coffeekong.mapper;

import com.coffeekong.annotation.mapper.CoffeekongMapper;
import com.coffeekong.domain.Criteria;
import com.coffeekong.domain.ProductVO;
import com.coffeekong.domain.ReviewVO;
import com.coffeekong.domain.SearchCriteria;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CoffeekongMapper
public interface ProductMapper {

	List<ProductVO> listByCategory(String category);

	ProductVO getByPid(int pid);

	List<ProductVO> list(SearchCriteria cri);

	int listCount(SearchCriteria cri);

	void delete(int pid);

	void update(ProductVO pvo);

	void insert(ProductVO pvo);

	List<ReviewVO> listReview(int pid, Criteria cri);

	int listReviewCount(int pid);
	void addReview(ReviewVO rvo) ;
	void deleteReview(int rid) ;

	
}