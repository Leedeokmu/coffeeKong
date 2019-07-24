package com.coffeekong.handler;

import com.coffeekong.dto.UsersConverter;
import com.coffeekong.dto.UsersDto;
import com.coffeekong.model.Users;
import com.coffeekong.service.CreateUserService;
import com.coffeekong.service.ReadUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.springframework.web.reactive.result.view.Rendering;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RequiredArgsConstructor
@Component
public class CreateUserHandler {
    private final CreateUserService createUserService;
    private final ReadUserService readUserService;
    private final UsersConverter usersConverter;

    private Mono<ServerResponse> notFound = ServerResponse.notFound().build();

    public Mono<ServerResponse> createUserPage(ServerRequest request){
        return ServerResponse.ok()
                .render("index", Rendering.view("index")
                        .modelAttribute("content", "user-add")
                        .build()
                        .modelAttributes())
                .switchIfEmpty(notFound);
    }

    public Mono<ServerResponse> createUser(ServerRequest request){
        Map<String, String> error = new HashMap<>();
        Mono<Users> user = request.bodyToMono(UsersDto.class)
                .filter(u -> u.getPwd().equals(u.getPwdConfirm()))
                .map(usersConverter::convert)
                .switchIfEmpty(Mono.error(new Exception("password not matched")))
                .doOnError((e) -> {
                    log.error(e.getMessage());
                    error.put("error", "password not matched");
                });

        return user
                .flatMap(u -> createUserService.register(u))
                .flatMap(u -> ServerResponse.ok()
                        .build())
                .onErrorResume(e -> {
                    log.error("failed to create user : {}", e.getMessage());
                    error.put("error", "failed to create user");
                    return ServerResponse.badRequest()
                            .body(BodyInserters.fromObject(error));
                })
                ;
    }

    public Mono<ServerResponse> updateUserPage(ServerRequest request){
        Long userId = Long.parseLong(request.pathVariable("userId"));


        return readUserService.getUserById(userId)
                .flatMap(user ->  ServerResponse.ok()
                            .render("index", Rendering.view("index")
                                    .modelAttribute("content", "user-update")
                                    .modelAttribute("user", user)
                                    .build()
                                    .modelAttributes())
                            .switchIfEmpty(notFound)
                )
                .onErrorResume(e -> {
                    log.error("failed to retrieve update page : {}", e.getMessage());
                    return ServerResponse.badRequest().build();
                })
                ;
    }

    public Mono<ServerResponse> updateUser(ServerRequest request){
        Long userId = Long.parseLong(request.pathVariable("userId"));

        return request.bodyToMono(Users.class)
                .flatMap(u -> createUserService.update(userId, u))
                .flatMap(u -> ServerResponse.ok()
                        .build())
                .onErrorResume(e -> {
                    log.error("failed to update user : {}", e.getMessage());
                    return ServerResponse.badRequest().build();
                })
                ;
    }



}
