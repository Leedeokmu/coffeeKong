package com.coffeekong.handler;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RequiredArgsConstructor
@Component
public class IndexHandler {
    private static Mono<ServerResponse> notFount = ServerResponse.notFound().build();

    public Mono<ServerResponse> index(ServerRequest request) {
        Map<String, Object> data = new HashMap<>();
        data.put("content", "");
        return ServerResponse.ok()
                .render("/index", data)
                .switchIfEmpty(notFount);
    }

    public Mono<ServerResponse> intro(ServerRequest request) {
        Map<String, Object> data = new HashMap<>();
        data.put("content", "intro");
        return ServerResponse.ok()
                .render("/index", data)
                .switchIfEmpty(notFount);
    }

    public Mono<ServerResponse> location(ServerRequest request) {
        Map<String, Object> data = new HashMap<>();
        data.put("content", "location");
        return ServerResponse.ok()
                .render("/index", data)
                .switchIfEmpty(notFount);
    }

    public Mono<ServerResponse> contact(ServerRequest request) {
        Map<String, Object> data = new HashMap<>();
        data.put("content", "contact");
        return ServerResponse.ok()
                .render("/index", data)
                .switchIfEmpty(notFount);
    }

    public Mono<ServerResponse> learn(ServerRequest request) {
        return ServerResponse.ok()
                .render("/learn/learn")
                .switchIfEmpty(notFount);
    }

    public Mono<ServerResponse> learnSubmenu(ServerRequest request) {
        String type = request.pathVariable("type");
        Map<String, Object> data = new HashMap<>();
        data.put("content", "type");
        return ServerResponse.ok()
                .render("/learn/learn", data)
                .switchIfEmpty(notFount);
    }

}
