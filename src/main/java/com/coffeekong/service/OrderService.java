package com.coffeekong.service;

import com.coffeekong.domain.CartVO;
import com.coffeekong.domain.OrderVO;
import com.coffeekong.domain.SearchCriteria;
import com.coffeekong.mapper.OrderMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService{
	private static final Logger logger = LoggerFactory.getLogger(OrderService.class);

	@Autowired
	private OrderMapper orderMapper;
	
	@Transactional
	public void insOrder(OrderVO vo, List<CartVO> list) {
		ArrayList<String> category = new ArrayList<String>();
		category.add("SingleOrigins");	category.add("Blends");	category.add("Decafs");
		category.add("Light");	category.add("Medium");  category.add("Dark");	category.add("ColdBrew");
		
		orderMapper.insOrd(vo);
		for(CartVO cvo : list){
			if(category.contains(cvo.getPCategory())){
				orderMapper.insOrdProd(cvo, vo.getOId());
			}else{
				orderMapper.insOrdProdTool(cvo, vo.getOId());
			}
		}
	}

	public List<OrderVO> listByEmail(SearchCriteria cri, String email) {
		return orderMapper.listByEmail(cri, email);
	}

	public int listCountByEmail(SearchCriteria cri, String email)  {
		return orderMapper.listCountByEmail(cri, email);
	}

	public List<OrderVO> list(SearchCriteria cri) {
		return orderMapper.list(cri);
	}

	public int listCount(SearchCriteria cri) {
		return orderMapper.listCount(cri);
	}

	public OrderVO getByOid(int Oid) {
		return orderMapper.getByOid(Oid);
	}

	public void update(OrderVO ovo) {
		orderMapper.update(ovo);
	}

	@Transactional
	public void delete(int oid) {
		orderMapper.deleteOrdProd(oid);
		orderMapper.deleteOrd(oid);
	}

	public void updateState(int oid, String state) {
		orderMapper.updateState(oid, state);
	}
	
}
