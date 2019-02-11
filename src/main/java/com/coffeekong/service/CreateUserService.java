package com.coffeekong.service;

import com.coffeekong.model.User;
import com.coffeekong.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class CreateUserService {
    private final UserRepository userRepository;

    public User register(User user) {
        return userRepository.save(user);
    }

    public User update(Long userId, User updatedUser) {
        updatedUser.setId(userId);
        return userRepository.save(updatedUser);
    }

}
