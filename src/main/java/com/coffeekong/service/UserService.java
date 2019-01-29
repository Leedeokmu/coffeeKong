package com.coffeekong.service;

import com.coffeekong.model.User;
import com.coffeekong.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;

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

	public User detail(String email) { return userRepository.getOne(email); }

}
