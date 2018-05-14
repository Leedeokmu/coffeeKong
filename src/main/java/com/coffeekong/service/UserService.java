package com.coffeekong.service;

import com.coffeekong.domain.SearchCriteria;
import com.coffeekong.domain.UserVO;
import com.coffeekong.dto.LoginDTO;
import com.coffeekong.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Slf4j
@Service
public class UserService {

	@Autowired
	private UserMapper userMapper;
	
	public UserVO login(LoginDTO dto) {
		return userMapper.login(dto);
	}

	public UserVO getUserWithSessionKey(String key) {
		return userMapper.getUserWithSessionKey(key);
	}

	public void rmbLogin(String email, String sess_id, Date limit) {
		userMapper.rmbLogin(email, sess_id, limit);
	}

	public String checkDuplicate(String email) {
		return userMapper.checkId(email);
	}

	public void register(UserVO uvo) {
		userMapper.register(uvo);
	}

	public void update(UserVO uvo) {
		userMapper.update(uvo);
	}

	public String checkUserPw(UserVO uvo) {
		return userMapper.checkUserPw(uvo);
	}

	public void deleteUser(String email) {
		userMapper.delete(email);
		
	}

	public List<UserVO> list(SearchCriteria cri) {
		return userMapper.list(cri);
	}

	public int listCount(SearchCriteria cri) {
		return userMapper.listCount(cri);
	}

	public UserVO detail(String email) {
		return userMapper.detail(email);
	}

}
