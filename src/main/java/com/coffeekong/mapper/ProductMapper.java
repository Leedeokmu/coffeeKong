package com.coffeekong.mapper;

import com.coffeekong.annotation.mapper.CoffeekongMapper;
import com.coffeekong.domain.Criteria;
import com.coffeekong.domain.ProductVO;
import com.coffeekong.domain.ReviewVO;
import com.coffeekong.domain.SearchCriteria;
import org.apache.ibatis.annotations.Param;
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

	ProductVO getByPid(int productId);

	List<ProductVO> list(SearchCriteria cri);

	int listCount(SearchCriteria cri);

	void delete(int productId);

	void update(ProductVO pvo);

	void insert(ProductVO pvo);

	List<ReviewVO> listReview(@Param("productId") Integer productId, @Param("cri") Criteria cri);

	int listReviewCount(int productId);
	void addReview(@Param("rvo") ReviewVO rvo) ;
	void deleteReview(int reviewId) ;

	
}