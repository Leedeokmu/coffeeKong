package com.coffeekong.repository;

import com.coffeekong.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.r2dbc.core.DatabaseClient;
import org.springframework.data.r2dbc.query.Criteria;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Repository
public class UserDatabaseClientRepository {
    private final DatabaseClient databaseClient;

    public Mono<Void> save(User user){
        return databaseClient.insert()
                .into(User.class)
                .using(user)
                .then();
    }

    public Mono<Void> update(User user){
        return databaseClient.update()
                .table(User.class)
                .using(user)
                .then();
    }

    public Mono<Void> deleteById(Long userId){
        return databaseClient.delete()
                .from(User.class)
                .matching(Criteria.where("id").is(userId))
                .then();
    }

    public Mono<User> getById(Long userId){
        return databaseClient.select()
                .from(User.class)
                .matching(Criteria.where("id").is(userId))
                .fetch()
                .one();
    }

    public Flux<User> findAll(Pageable page){
        return databaseClient.select()
                .from(User.class)
                .page(page)
                .fetch()
                .all();
    }



}
