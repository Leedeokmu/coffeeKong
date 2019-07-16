package com.coffeekong.service;

import com.coffeekong.repository.UserDatabaseClientRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Slf4j
@RequiredArgsConstructor
@Service
public class DeleteUserService {
    private final UserDatabaseClientRepository userDatabaseClientRepository;

    public Mono<Void> deleteUser(Long userId){
        return userDatabaseClientRepository.deleteById(userId);
    }

}
