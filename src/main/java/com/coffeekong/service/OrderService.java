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
	public void insOrder(OrderVO vo, List<CartVO> list) throws Exception;
	public List<OrderVO> listByEmail(SearchCriteria cri, String email) throws Exception;
	public int listCountByEmail(SearchCriteria cri, String email) throws Exception;
	public List<OrderVO> list(SearchCriteria cri) throws Exception;
	public int listCount(SearchCriteria cri) throws Exception;
	
	public OrderVO getByOid(int Oid) throws Exception;
	public void update(OrderVO ovo) throws Exception;
	public void delete(int oid) throws Exception;
	public void updateState(int oid, String state) throws Exception;
}

