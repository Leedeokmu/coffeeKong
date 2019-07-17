package com.coffeekong;

import com.coffeekong.handler.CreateUserHandler;
import com.coffeekong.handler.DeleteUserHandler;
import com.coffeekong.handler.IndexHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@RequiredArgsConstructor
@EnableWebFlux
@Configuration
public class AppRouter {
    private final CreateUserHandler createUserHandler;
    private final DeleteUserHandler deleteUserHandler;
    private final IndexHandler indexHandler;

    @Bean
    public RouterFunction<?> userRouter() {
        return
                // 유저 생성
                route(GET("/users/add"), createUserHandler::createUserPage)
                .andRoute(POST("/users"), createUserHandler::createUser)
                .andRoute(GET("/users/{userId}/edit"), createUserHandler::updateUserPage)
                .andRoute(PUT("/users/{userId}"), createUserHandler::updateUser)
                // 유저 삭제
                .andRoute(DELETE("/users/{userId}"), deleteUserHandler::delete)
                // 유저 조회
                .andRoute(GET("/users"))
                .andRoute(GET("/users/{userId}"))





                .andRoute(GET("/index"), indexHandler::index)
                .andRoute(GET("/info/intro"), indexHandler::intro)
                .andRoute(GET("/info/location"), indexHandler::location)
                .andRoute(GET("/info/contact"), indexHandler::contact)
                .andRoute(GET("/learn"), indexHandler::learn)
                .andRoute(GET("//learn/{type}"), indexHandler::learnSubmenu)
    }
}
