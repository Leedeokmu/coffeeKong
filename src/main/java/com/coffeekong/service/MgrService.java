package com.coffeekong.service;

import com.coffeekong.domain.MgrVO;
import com.coffeekong.dto.LoginDTO;
import com.coffeekong.mapper.MgrMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class MgrService {

	@Autowired
	private MgrMapper mgrMapper;
	
	public MgrVO login(LoginDTO dto) {
		return mgrMapper.login(dto);
	}

	public void rmbLogin(String email, String sess_id, Date limit) {
		mgrMapper.rmbLogin(email, sess_id, limit);
	}
	
}
