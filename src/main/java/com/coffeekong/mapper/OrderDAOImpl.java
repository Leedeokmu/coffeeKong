package com.coffeekong.mapper;

import com.coffeekong.domain.CartVO;
import com.coffeekong.domain.OrderVO;
import com.coffeekong.domain.SearchCriteria;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public class OrderDAOImpl implements OrderDAO{
	private static final Logger logger = LoggerFactory.getLogger(OrderDAOImpl.class);
	
	@Autowired
	private SqlSession sql;
	
	private static String namespace = "com.coffeekong.mapper.OrderMapper";

	@Override
	public void insOrd(OrderVO vo) throws Exception {
		sql.insert(namespace+".insOrd", vo);
	}
	@Override
	public void insOrdProd(CartVO vo) throws Exception {
		sql.insert(namespace+".insOrdProd", vo);
	}

	@Override
	public void insOrdProdTool(CartVO vo) throws Exception {
		sql.insert(namespace+".insOrdProdTool", vo);
	}
	@Override
	public List<OrderVO> listByEmail(SearchCriteria cri, String email) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("cri", cri);
		map.put("email",email);
		return sql.selectList(namespace+".listByEmail", map);
	}
	@Override
	public int listCountByEmail(SearchCriteria cri, String email) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("cri", cri);
		map.put("email",email);
		return sql.selectOne(namespace+".listCountByEmail", map);
	}
	
	@Override
	public List<OrderVO> list(SearchCriteria cri) throws Exception {
		return sql.selectList(namespace+".list", cri);
	}
	@Override
	public int listCount(SearchCriteria cri) throws Exception {
		return sql.selectOne(namespace+".listCount", cri);
	}
	@Override
	public OrderVO getByOid(int Oid) throws Exception {
		return sql.selectOne(namespace+".getByOid", Oid);
	}
	@Override
	public void update(OrderVO ovo) throws Exception {
		sql.update(namespace+".update", ovo);
	}

	@Override
	public void deleteOrd(int oid) throws Exception {
		sql.delete(namespace+".deleteOrd", oid);
		
	}
	@Override
	public void deleteOrdProd(int oid) throws Exception {
		sql.delete(namespace+".deleteOrdProd", oid);
	}
	@Override
	public void updateState(int oid, String state) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("oid", oid);
		map.put("state", state);
		
		sql.update(namespace+".updateState", map);
	}
	

}
