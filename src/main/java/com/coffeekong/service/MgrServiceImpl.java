package com.coffeekong.service;

import java.util.Date;

import javax.inject.Inject;

import com.coffeekong.domain.MgrVO;
import com.coffeekong.dto.LoginDTO;
import com.coffeekong.mapper.MgrMapper;
import org.springframework.stereotype.Service;

@Service
public class MgrServiceImpl implements MgrService{

	@Autowired
	private MgrMapper dao;
	
	@Override
	public MgrVO login(LoginDTO dto) throws Exception {
		return dao.login(dto);
	}
	@Override
	public void rmbLogin(String email, String sess_id, Date limit) throws Exception {
		
	}
	
}
