package com.coffeekong.handler;

import com.coffeekong.dto.Paging;
import com.coffeekong.model.User;
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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RequiredArgsConstructor
@Component
public class ReadUserHandler {
    private final ReadUserService readUserService;

    private Mono<ServerResponse> notFound = ServerResponse.notFound().build();

    public Mono<ServerResponse> listUser(ServerRequest request){
        Integer page = request.attribute("page")
                .map(Integer.class::cast)
                .orElse(0);

        Pageable pageable = PageRequest.of(page == 0 ? page : page - 1, 5, Sort.by(Sort.Direction.ASC, "id"));

        Mono<List<User>> users = readUserService.getUserList(pageable).collectList();
        Mono<Long> userTotalCount = readUserService.getUserTotalCount();

        return Mono.zip(users, userTotalCount, (userList, ttlCount) -> {
            Paging paging = new Paging();
            paging.setPageNo(page + 1);
            paging.setPageSize(pageable.getPageSize());
            paging.setTotalCount(ttlCount);

            return Rendering.view("index")
                    .modelAttribute("content", "user-add")
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
                .flatMap(user -> {
                    Map<String, Object> data = new HashMap<>();
                    data.put("content", "user-detail");
                    data.put("user", user);
                    return ServerResponse.ok()
                            .render("index", data)
                            .switchIfEmpty(notFound);
                })
                .switchIfEmpty(ServerResponse.badRequest()
                        .build())
                .onErrorResume(error -> {
                    log.error(error.getMessage());
                    return ServerResponse.badRequest()
                            .build();
                });

    }
}
