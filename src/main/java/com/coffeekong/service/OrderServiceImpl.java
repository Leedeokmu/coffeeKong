package com.coffeekong.service;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import com.coffeekong.mapper.OrderDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.coffeekong.domain.CartVO;
import com.coffeekong.domain.OrderVO;
import com.coffeekong.domain.SearchCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderServiceImpl implements OrderService{
	private static final Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);

	@Autowired
	private OrderDAO dao;
	
	@Override
	@Transactional
	public void insOrder(OrderVO vo, List<CartVO> list) throws Exception {
		ArrayList<String> category = new ArrayList<String>();
		category.add("SingleOrigins");	category.add("Blends");	category.add("Decafs");
		category.add("Light");	category.add("Medium");  category.add("Dark");	category.add("ColdBrew");
		
		dao.insOrd(vo);
		for(CartVO cvo : list){
			if(category.contains(cvo.getP_category())){
				dao.insOrdProd(cvo);
			}else{
				dao.insOrdProdTool(cvo);
			}
		}
	}

	@Override
	public List<OrderVO> listByEmail(SearchCriteria cri, String email) throws Exception {
		return dao.listByEmail(cri, email);
	}

	@Override
	public int listCountByEmail(SearchCriteria cri, String email) throws Exception {
		return dao.listCountByEmail(cri, email);
	}

	@Override
	public List<OrderVO> list(SearchCriteria cri) throws Exception {
		return dao.list(cri);
	}

	@Override
	public int listCount(SearchCriteria cri) throws Exception {
		return dao.listCount(cri);
	}

	@Override
	public OrderVO getByOid(int Oid) throws Exception {
		return dao.getByOid(Oid);
	}

	@Override
	public void update(OrderVO ovo) throws Exception {
		dao.update(ovo);
	}

	@Transactional
	@Override
	public void delete(int oid) throws Exception {
		dao.deleteOrdProd(oid);
		dao.deleteOrd(oid);
	}

	@Override
	public void updateState(int oid, String state) throws Exception {
		dao.updateState(oid, state);
	}
	
}
