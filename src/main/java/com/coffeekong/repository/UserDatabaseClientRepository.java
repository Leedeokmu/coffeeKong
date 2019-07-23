package com.coffeekong.repository;

import com.coffeekong.model.Users;
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

    public Mono<Void> save(Users users){
        return databaseClient.insert()
                .into(Users.class)
                .using(users)
                .then();
    }

    public Mono<Void> update(Users users){
        return databaseClient.update()
                .table(Users.class)
                .using(users)
                .then();
    }

    public Mono<Void> deleteById(Long userId){
        return databaseClient.delete()
                .from(Users.class)
                .matching(Criteria.where("id").is(userId))
                .then();
    }

    public Mono<Users> getById(Long userId){
        return databaseClient.select()
                .from(Users.class)
                .matching(Criteria.where("id").is(userId))
                .fetch()
                .one();
    }

    public Flux<Users> findAll(Pageable page){
        return databaseClient.select()
                .from(Users.class)
                .page(page)
                .fetch()
                .all();
    }

    public Mono<Long> getTotalCount(){
        return databaseClient.execute()
                .sql("SELECT count(id) from users")
                .as(Long.class)
                .fetch()
                .first()
                ;
    }



}
