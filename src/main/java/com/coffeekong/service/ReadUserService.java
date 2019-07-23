package com.coffeekong.service;

import com.coffeekong.model.Users;
import com.coffeekong.repository.UserDatabaseClientRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@Slf4j
@RequiredArgsConstructor
@Service
public class ReadUserService {
	private final UserDatabaseClientRepository userDatabaseClientRepository;
	private static Mono<Users> error = Mono.error(new Exception("No user was found"));

//	@Cacheable(value="userCache", key="#userId")
	public Mono<Users> getUserById(Long userId) {
		return userDatabaseClientRepository.getById(userId).subscribeOn(Schedulers.elastic()).switchIfEmpty(error);
	}

	@Cacheable(value="userCache")
	public Mono<Users> getUser() {
		return userDatabaseClientRepository.getById(3L);
	}

//	@Cacheable(value = "userListPagingCache")
	public Flux<Users> getUserList(Pageable pageable){
		return userDatabaseClientRepository.findAll(pageable).subscribeOn(Schedulers.elastic()).switchIfEmpty(error);
	}

	public Mono<Long> getUserTotalCount(){
		return userDatabaseClientRepository.getTotalCount();
	}

}
