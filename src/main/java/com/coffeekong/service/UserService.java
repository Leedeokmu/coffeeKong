package com.coffeekong.service;

import com.coffeekong.domain.SearchCriteria;
import com.coffeekong.dto.LoginDTO;
import com.coffeekong.model.User;
import com.coffeekong.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Slf4j
@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;

	public User login(LoginDTO dto) {
		return userRepository.findByEmailAndAndPwd(dto.getEmail(), dto.getPwd());
	}

	public User getUserWithSession(String key) {
		return userRepository.findBySessIdAndAndSessLimitAfter(key, DateTime.now());
	}

	public void rmbLogin(String email, String sess_id, Date limit) {
		User user = new User();
		user.set
		userRepository.save
		userMapper.rmbLogin(email, sess_id, limit);
	}

	public String checkDuplicate(String email) {
		return userMapper.checkId(email);
	}

	public void register(User uvo) {
		userMapper.register(uvo);
	}

	public void update(User uvo) {
		userMapper.update(uvo);
	}

	public String checkUserPw(User uvo) {
		return userMapper.checkUserPw(uvo);
	}

	public void deleteUser(String email) {
		userMapper.delete(email);
		
	}

	public List<User> list(SearchCriteria cri) {
		return userMapper.list(cri);
	}

	public int listCount(SearchCriteria cri) {
		return userMapper.listCount(cri);
	}

	public User detail(String email) {
		return userMapper.detail(email);
	}

}
