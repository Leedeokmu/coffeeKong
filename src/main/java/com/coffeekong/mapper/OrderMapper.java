package com.coffeekong.mapper;

import com.coffeekong.annotation.mapper.CoffeekongMapper;
import com.coffeekong.domain.CartVO;
import com.coffeekong.domain.OrderVO;
import com.coffeekong.domain.SearchCriteria;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@CoffeekongMapper
public interface OrderMapper{

	 Integer insOrd(@Param("vo") OrderVO vo);
     Integer insOrdProd(@Param("vo") CartVO vo, @Param("orderId") Integer orderId);

	 void insOrdProdTool(@Param("vo") CartVO vo, @Param("orderId") Integer orderId);
	 List<OrderVO> listByEmail(@Param("cri") SearchCriteria cri, @Param("email") String email);
	 int listCountByEmail(@Param("cri") SearchCriteria cri, @Param("email") String email);
	
	 List<OrderVO> list(@Param("cri") SearchCriteria cri);
	 int listCount(@Param("cri") SearchCriteria cri);
	 OrderVO getByOid(@Param("orderId") int orderId);
	 void update(@Param("ovo") OrderVO ovo);
	 void deleteOrd(@Param("orderId") Integer orderId);
	 void deleteOrdProd(@Param("orderId") Integer orderId);
	 void updateState(@Param("orderId") int orderId, @Param("state") String state);
}
