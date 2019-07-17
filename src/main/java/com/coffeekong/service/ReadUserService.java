package com.coffeekong.service;

import com.coffeekong.model.User;
import com.coffeekong.repository.UserDatabaseClientRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RequiredArgsConstructor
@Service
public class ReadUserService {
	private final UserDatabaseClientRepository userDatabaseClientRepository;
	private static Mono<User> error = Mono.error(new Exception("No user was found"));

	@Cacheable(value="userCache", key="#userId")
	public Mono<User> getUserById(Long userId) {
		return userDatabaseClientRepository.getById(userId).switchIfEmpty(error);
	}

	@Cacheable(value="userCache")
	public Mono<User> getUser() {
		return userDatabaseClientRepository.getById(3L);
	}

	@Cacheable(value = "userListPagingCache")
	public Flux<User> getUserList(Pageable pageable){
		return userDatabaseClientRepository.findAll(pageable).switchIfEmpty(error);
	}

	public Mono<Long> getUserTotalCount(){
		return userDatabaseClientRepository.getTotalCount();
	}

}
