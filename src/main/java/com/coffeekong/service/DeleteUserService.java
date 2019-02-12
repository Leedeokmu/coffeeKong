package com.coffeekong.service;

import com.coffeekong.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@RequiredArgsConstructor
@Service
public class DeleteUserService {
    private final UserRepository userRepository;

    @Transactional
    public void deleteUser(Long userId){
        userRepository.deleteById(userId);
    }

}
