package com.coffeekong.mapper;

import com.coffeekong.annotation.mapper.CoffeekongMapper;
import com.coffeekong.domain.CartVO;
import com.coffeekong.domain.OrderVO;
import com.coffeekong.domain.SearchCriteria;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@CoffeekongMapper
public interface OrderMapper{

	 void insOrd(OrderVO vo);
	 void insOrdProd(CartVO vo, Integer orderId);

	 void insOrdProdTool(CartVO vo, Integer orderId);
	 List<OrderVO> listByEmail(SearchCriteria cri, String email);
	 int listCountByEmail(SearchCriteria cri, String email);
	
	 List<OrderVO> list(SearchCriteria cri);
	 int listCount(SearchCriteria cri);
	 OrderVO getByOid(int orderId);
	 void update(OrderVO ovo);
	 void deleteOrd(int orderId);
	 void deleteOrdProd(int orderId);
	 void updateState(int orderId, String state);
}
