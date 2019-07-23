package com.coffeekong.service;

import com.coffeekong.model.Users;
import com.coffeekong.repository.UserDatabaseClientRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@Slf4j
@RequiredArgsConstructor
@Service
public class CreateUserService {
    private final UserDatabaseClientRepository userDatabaseClientRepository;

    public Mono<Void> register(Users users) {
        return userDatabaseClientRepository.save(users).subscribeOn(Schedulers.elastic());
    }

    public Mono<Void> update(Long userId, Users updatedUsers) {
        updatedUsers.setId(userId);
        return userDatabaseClientRepository.update(updatedUsers).subscribeOn(Schedulers.elastic());
    }

}
