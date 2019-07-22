package com.coffeekong.handler;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.springframework.web.reactive.result.view.Rendering;
import reactor.core.publisher.Mono;

@Slf4j
@RequiredArgsConstructor
@Component
public class IndexHandler {
    private static Mono<ServerResponse> notFount = ServerResponse.notFound().build();

    public Mono<ServerResponse> index(ServerRequest request) {
        return ServerResponse.ok()
                .render("index", Rendering.view("index")
                        .modelAttribute("content", "")
                        .build()
                        .modelAttributes())
                .switchIfEmpty(notFount);
    }

    public Mono<ServerResponse> intro(ServerRequest request) {
        return ServerResponse.ok()
                .render("index", Rendering.view("index")
                        .modelAttribute("content", "intro")
                        .build()
                        .modelAttributes())
                .switchIfEmpty(notFount);
    }

    public Mono<ServerResponse> location(ServerRequest request) {
        return ServerResponse.ok()
                .render("index", Rendering.view("index")
                        .modelAttribute("content", "location")
                        .build()
                        .modelAttributes())
                .switchIfEmpty(notFount);
    }

    public Mono<ServerResponse> contact(ServerRequest request) {
        return ServerResponse.ok()
                .render("index", Rendering.view("index")
                        .modelAttribute("content", "contact")
                        .build()
                        .modelAttributes())
                .switchIfEmpty(notFount);
    }

    public Mono<ServerResponse> learn(ServerRequest request) {
        return ServerResponse.ok()
                .render("learn/learn")
                .switchIfEmpty(notFount);
    }

    public Mono<ServerResponse> learnSubmenu(ServerRequest request) {
        String type = request.pathVariable("type");
        return ServerResponse.ok()
                .render("learn/learn", Rendering.view("index")
                        .modelAttribute("content", type)
                        .build()
                        .modelAttributes())
                .switchIfEmpty(notFount);
    }

}
