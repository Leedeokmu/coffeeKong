package com.coffeekong.service;

import com.coffeekong.dto.LoginDTO;
import com.coffeekong.model.Manager;
import com.coffeekong.repository.ManagerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@Slf4j
public class MgrService {

	@Autowired
	private ManagerRepository managerRepository;
	
	public Manager login(LoginDTO dto) {
		return managerRepository.findByEmailAndPwd(dto.getEmail(), dto.getPwd());
	}

	public Manager rmbLogin(String email, String sess_id, Date limit) {
		Manager manager = managerRepository.getOne(email);
		manager.setSessId(sess_id);
		manager.setSessLimit(limit);
		return managerRepository.save(manager);
	}
	
}
