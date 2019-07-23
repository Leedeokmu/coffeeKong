package com.coffeekong.handler;

import com.coffeekong.dto.Paging;
import com.coffeekong.model.Users;
import com.coffeekong.service.ReadUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.springframework.web.reactive.result.view.Rendering;
import reactor.core.publisher.Mono;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Component
public class ReadUserHandler {
    private final ReadUserService readUserService;

    private Mono<ServerResponse> notFound = ServerResponse.notFound().build();

    public Mono<ServerResponse> listUser(ServerRequest request){
        Integer page = request.queryParam("page")
                .map(Integer::parseInt)
                .orElse(0);

        Pageable pageable = PageRequest.of(page == 0 ? page : page - 1, 5, Sort.by(Sort.Direction.ASC, "id"));

        Mono<List<Users>> users = readUserService.getUserList(pageable).collectList();
        Mono<Long> userTotalCount = readUserService.getUserTotalCount();

        return Mono.zip(users, userTotalCount, (userList, ttlCount) -> {
            Paging paging = new Paging();
            paging.setPageNo(page == 0 ? page + 1: page);
            paging.setPageSize(pageable.getPageSize());
            paging.setTotalCount(ttlCount);

            return Rendering.view("index")
                    .modelAttribute("content", "user-list")
                    .modelAttribute("user", userList)
                    .modelAttribute("paging", paging)
                    .build()
                    .modelAttributes();
        })
                .flatMap(map -> ServerResponse.ok()
                        .render("index", map)
                        .switchIfEmpty(notFound)
                )
                .onErrorResume(error -> {
                    log.error(error.getMessage());
                    return ServerResponse.badRequest()
                            .build();
                })
                ;
    }

    public Mono<ServerResponse> getUser(ServerRequest request){
        Long userId = Long.valueOf(request.pathVariable("userId"));
        return readUserService.getUserById(userId)
                .flatMap(user -> ServerResponse.ok()
                            .render("index", Rendering.view("index")
                                    .modelAttribute("content", "user-detail")
                                    .modelAttribute("user", user)
                                    .build()
                                    .modelAttributes())
                            .switchIfEmpty(notFound))
                .switchIfEmpty(ServerResponse.badRequest()
                        .build())
                .onErrorResume(error -> {
                    log.error(error.getMessage());
                    return ServerResponse.badRequest()
                            .build();
                });

    }
}
