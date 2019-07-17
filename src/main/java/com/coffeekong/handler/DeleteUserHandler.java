package com.coffeekong.handler;

import com.coffeekong.service.DeleteUserService;
import com.coffeekong.service.ReadUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Slf4j
@RequiredArgsConstructor
@Component
public class DeleteUserHandler {
    private final DeleteUserService deleteUserService;

    public Mono<ServerResponse> delete(ServerRequest request){
        Long userId = Long.parseLong(request.pathVariable("userId"));

        return deleteUserService.deleteUser(userId)
                .flatMap(user -> ServerResponse.ok()
                    .build())
                .onErrorResume((e) -> {
                    log.error(e.getMessage());
                    return ServerResponse.badRequest()
                            .build();
                });
    }

}
