package com.coffeekong.mapper;

import java.util.Date;
import java.util.List;

import com.coffeekong.domain.SearchCriteria;
import com.coffeekong.domain.UserVO;
import com.coffeekong.dto.LoginDTO;

public interface UserDAO {
	UserVO login(LoginDTO dto) throws Exception;
	void rmbLogin(String email, String sess_id, Date limit) throws Exception;
	UserVO getUserWithSessionKey(String key) throws Exception;
	String checkId(String email) throws Exception;
	void register(UserVO uvo) throws Exception;
	void update(UserVO uvo) throws Exception;
	String checkUserPw(UserVO uvo) throws Exception;
	void delete(String email) throws Exception;
	List<UserVO> list(SearchCriteria cri) throws Exception;
	int listCount(SearchCriteria cri) throws Exception;
	UserVO detail(String email) throws Exception;
}
