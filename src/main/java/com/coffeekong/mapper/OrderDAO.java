package com.coffeekong.mapper;

import java.util.List;

import com.coffeekong.domain.CartVO;
import com.coffeekong.domain.OrderVO;
import com.coffeekong.domain.SearchCriteria;

public interface OrderDAO {
	public void insOrd(OrderVO vo) throws Exception;
	public void insOrdProd(CartVO vo) throws Exception;
	public void insOrdProdTool(CartVO vo) throws Exception;
	public List<OrderVO> listByEmail(SearchCriteria cri,String email) throws Exception;
	public int listCountByEmail(SearchCriteria cri, String email) throws Exception;
	public List<OrderVO> list(SearchCriteria cri) throws Exception;
	public int listCount(SearchCriteria cri) throws Exception;
	
	public OrderVO getByOid(int Oid) throws Exception;
	public void update(OrderVO ovo) throws Exception;
	public void deleteOrd(int oid) throws Exception;
	public void deleteOrdProd(int oid) throws Exception;
	public void updateState(int oid, String state) throws Exception;
}


