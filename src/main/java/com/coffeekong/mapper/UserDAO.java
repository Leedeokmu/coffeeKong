package com.coffeekong.mapper;

import java.util.Date;
import java.util.List;

import com.coffeekong.domain.SearchCriteria;
import com.coffeekong.domain.UserVO;
import com.coffeekong.dto.LoginDTO;

public interface UserDAO {
	public UserVO login(LoginDTO dto) throws Exception;
	public void rmbLogin(String email, String sess_id, Date limit) throws Exception;
	public UserVO getUserWithSessionKey(String key) throws Exception;
	public String checkId(String email) throws Exception;
	public void register(UserVO uvo) throws Exception;
	public void update(UserVO uvo) throws Exception;
	public String checkUserPw(UserVO uvo) throws Exception;
	public void delete(String email) throws Exception;
	public List<UserVO> list(SearchCriteria cri) throws Exception;
	public int listCount(SearchCriteria cri) throws Exception;
	public UserVO detail(String email) throws Exception;
}
