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

	List<ProductVO> listByCategory(@Param("category")String category);

	ProductVO getByPid(@Param("productId")int productId);

	List<ProductVO> list(@Param("cri")SearchCriteria cri);

	int listCount(@Param("cri")SearchCriteria cri);

	void delete(@Param("productId")int productId);

	void update(@Param("pvo")ProductVO pvo);

	void insert(@Param("pvo")ProductVO pvo);

	List<ReviewVO> listReview(@Param("productId") Integer productId, @Param("cri") Criteria cri);

	int listReviewCount(@Param("productId")int productId);
	void addReview(@Param("rvo") ReviewVO rvo) ;
	void deleteReview(@Param("reviewId")int reviewId) ;

	
}