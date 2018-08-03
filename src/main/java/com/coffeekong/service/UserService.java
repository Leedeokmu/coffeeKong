package com.coffeekong.service;

import com.coffeekong.domain.SearchCriteria;
import com.coffeekong.dto.LoginDTO;
import com.coffeekong.model.User;
import com.coffeekong.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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

	public User rmbLogin(String email, String sess_id, DateTime limit) {
		User user = userRepository.getOne(email);
		user.setSessId(sess_id);
		user.setSessLimit(limit);
		return userRepository.save(user);
	}

	public User checkDuplicate(String email) {
		return userRepository.getOne(email);
	}

	public User register(User user) {
		return userRepository.save(user);
	}

	public User update(User updatedUser) {
		return userRepository.save(updatedUser);
	}

	public User checkUserPw(User user) {
		return userRepository.getOne(user.getEmail());
	}

	public void deleteUser(String email) {
		userRepository.delete(email);
	}

	public User detail(String email) { return userRepository.getOne(email); }

	public Page<User> list(SearchCriteria cri) { return userRepository.findAllBySearchTypeAndKeyword(cri.getSearchType(), cri.getKeyword(), cri); }
}
