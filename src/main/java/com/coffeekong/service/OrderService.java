package com.coffeekong.service;

import java.util.List;

import com.coffeekong.domain.CartVO;
import com.coffeekong.domain.OrderVO;
import com.coffeekong.domain.SearchCriteria;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.coffeekong.domain.CartVO;
import com.coffeekong.domain.OrderVO;
import com.coffeekong.domain.SearchCriteria;

public interface OrderService {
	void insOrder(OrderVO vo, List<CartVO> list) throws Exception;
	List<OrderVO> listByEmail(SearchCriteria cri, String email) throws Exception;
	int listCountByEmail(SearchCriteria cri, String email) throws Exception;
	List<OrderVO> list(SearchCriteria cri) throws Exception;
	int listCount(SearchCriteria cri) throws Exception;
	
	OrderVO getByOid(int Oid) throws Exception;
	void update(OrderVO ovo) throws Exception;
	void delete(int oid) throws Exception;
	void updateState(int oid, String state) throws Exception;
}

