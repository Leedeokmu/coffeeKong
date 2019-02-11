package com.coffeekong.service;

import com.coffeekong.model.User;
import com.coffeekong.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class ReadUserService {
	private final UserRepository userRepository;

	public User getUserById(Long userId) {
		return userRepository.getById(userId);
	}

	public Page<User> getUserList(Pageable pageable){
		return userRepository.findAll(pageable);
	}

}
