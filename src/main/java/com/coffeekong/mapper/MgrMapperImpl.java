package com.coffeekong.mapper;

import com.coffeekong.domain.MgrVO;
import com.coffeekong.dto.LoginDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Repository
public class MgrMapperImpl implements MgrMapper {
	
	@Autowired
	private SqlSession sql;
	
	private static String namespace = "com.coffeekong.mapper.MgrMapper";
	
	@Override
	public MgrVO login(LoginDTO dto) throws Exception {
		return sql.selectOne(namespace+".login", dto);
	}

	@Override
	public void rmbLogin(String email, String sess_id, Date limit) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("email", email);
		map.put("sess_id", sess_id);
		map.put("limit", limit);
		
		sql.update(namespace+".rmbLogin", map);
	}
	
}
