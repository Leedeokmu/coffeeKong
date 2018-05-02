package com.coffeekong.mapper;

import java.util.List;

import com.coffeekong.domain.CartVO;
import com.coffeekong.domain.OrderVO;
import com.coffeekong.domain.SearchCriteria;

public interface OrderDAO {
	void insOrd(OrderVO vo) throws Exception;
	void insOrdProd(CartVO vo) throws Exception;
	void insOrdProdTool(CartVO vo) throws Exception;
	List<OrderVO> listByEmail(SearchCriteria cri,String email) throws Exception;
	int listCountByEmail(SearchCriteria cri, String email) throws Exception;
	List<OrderVO> list(SearchCriteria cri) throws Exception;
	int listCount(SearchCriteria cri) throws Exception;
	
	OrderVO getByOid(int Oid) throws Exception;
	void update(OrderVO ovo) throws Exception;
	void deleteOrd(int oid) throws Exception;
	void deleteOrdProd(int oid) throws Exception;
	void updateState(int oid, String state) throws Exception;
}


