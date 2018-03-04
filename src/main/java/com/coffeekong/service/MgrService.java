package com.coffeekong.service;

import java.util.Date;

import com.coffeekong.domain.MgrVO;
import com.coffeekong.dto.LoginDTO;
import com.coffeekong.domain.MgrVO;
import com.coffeekong.dto.LoginDTO;

public interface MgrService {
	public MgrVO login(LoginDTO dto) throws Exception;
	public void rmbLogin(String email, String sess_id, Date limit) throws Exception;
}
