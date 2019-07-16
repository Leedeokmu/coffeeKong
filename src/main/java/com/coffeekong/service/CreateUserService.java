package com.coffeekong.service;

import com.coffeekong.model.User;
import com.coffeekong.repository.UserDatabaseClientRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Slf4j
@RequiredArgsConstructor
@Service
public class CreateUserService {
    private final UserDatabaseClientRepository userDatabaseClientRepository;

    public Mono<Void> register(User user) {
        return userDatabaseClientRepository.save(user);
    }

    public Mono<Void> update(Long userId, User updatedUser) {
        updatedUser.setId(userId);
        return userDatabaseClientRepository.update(updatedUser);
    }

}
