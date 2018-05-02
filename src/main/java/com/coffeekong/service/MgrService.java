package com.coffeekong.service;

import java.util.Date;

import com.coffeekong.domain.MgrVO;
import com.coffeekong.dto.LoginDTO;
import com.coffeekong.domain.MgrVO;
import com.coffeekong.dto.LoginDTO;

public interface MgrService {
	MgrVO login(LoginDTO dto) throws Exception;
	void rmbLogin(String email, String sess_id, Date limit) throws Exception;
}
