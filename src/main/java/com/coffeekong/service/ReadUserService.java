package com.coffeekong.service;

import com.coffeekong.model.User;
import com.coffeekong.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class ReadUserService {
	private final UserRepository userRepository;

	public User getUserOne(String email) { return userRepository.getOne(email); }





}
