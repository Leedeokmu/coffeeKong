package com.coffeekong.handler;

import com.coffeekong.model.User;
import com.coffeekong.service.CreateUserService;
import com.coffeekong.service.ReadUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.BodyInserter;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.web.reactive.function.BodyInserters.fromObject;

@Slf4j
@RequiredArgsConstructor
@Component
public class CreateUserHandler {
    private final CreateUserService createUserService;
    private final ReadUserService readUserService;

    private Mono<ServerResponse> notFound = ServerResponse.notFound().build();

    public Mono<ServerResponse> createUserPage(ServerRequest request){
        Map<String, Object> data = new HashMap<>();
        data.put("content", "user-add");
        return ServerResponse.ok()
                .render("/index", data)
                .switchIfEmpty(notFound);
    }

    public Mono<ServerResponse> createUser(ServerRequest request){
        Map<String, String> error = new HashMap<>();
        String pwdConfirm = (String) request.attribute("pwdConfirm").orElse("");
        Mono<User> user = request.bodyToMono(User.class)
                .filter(u -> u.getPwd().equals(pwdConfirm))
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
        Map<String, Object> data = new HashMap<>();
        data.put("content", "user-update");
        data.put("user", readUserService.getUserById(userId));

        return ServerResponse.ok()
                .render("/index", data)
                .switchIfEmpty(notFound);
    }

    public Mono<ServerResponse> updateUser(ServerRequest request){
        Long userId = Long.parseLong(request.pathVariable("userId"));

        return request.bodyToMono(User.class)
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
