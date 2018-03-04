package com.coffeekong.mapper;

import com.coffeekong.annotation.mapper.CoffeekongMapper;
import com.coffeekong.domain.MgrVO;
import com.coffeekong.dto.LoginDTO;

import java.util.Date;

@CoffeekongMapper
public interface MgrMapper {
	MgrVO login(LoginDTO dto) throws Exception;
	void rmbLogin(String email, String sess_id, Date limit) throws Exception;
	
}
